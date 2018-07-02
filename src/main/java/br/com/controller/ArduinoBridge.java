package br.com.controller;


import br.com.model.Address;
import br.com.model.Alarm;
import br.com.model.Alarmevent;
import br.com.model.Arquivo;
import br.com.model.Houseowner;
import br.com.model.Mail;
import br.com.model.dao.DAOAddress;
import br.com.model.dao.DAOAlarm;
import br.com.model.dao.DAOAlarmEvent;
import br.com.model.dao.DAOOwner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArduinoBridge implements SerialPortEventListener {

    SerialPort serialPort;
    private static final String PORT_NAMES[] = {
        "/dev/tty.usbserial-A9007UX1", // Mac OS X
        "/dev/ttyACM0",// Raspberry Pi
        "/dev/ttyACM1",// Raspberry Pi
        "/dev/ttyUSB0", // Linux
        "COM3", // Windows
    };
    private BufferedReader input;
    private OutputStream output;
    private static final int TIME_OUT = 2000;
    private static final int DATA_RATE = 9600;
    private DAOAddress daoAdress;
    private DAOOwner daoOwner;
    private DAOAlarmEvent daoEvent;
    private DAOAlarm daoAlarm;
    
    public void initialize() {
        daoAdress = new DAOAddress();
        daoOwner = new DAOOwner();
        daoEvent = new DAOAlarmEvent();
        daoAlarm = new DAOAlarm();
        System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");

        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }
        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {    
            serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);
            System.out.println("Porta detectada: " + serialPort);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();            

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    public synchronized void serialEvent(SerialPortEvent oEvent) {
        try {
            this.turnOn();
        } catch (IOException ex) {
            System.out.println("FAIL");
            Logger.getLogger(ArduinoBridge.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String alarmIntro = input.readLine();
                try{
                    int alarmDisparado = Integer.parseInt(alarmIntro);
                    System.out.println(alarmDisparado);
                    Alarm a = this.daoAlarm.obter(alarmDisparado);
                    Alarmevent fireAlarm = new Alarmevent();
                    fireAlarm.setActionDate(Calendar.getInstance().getTime());
                    fireAlarm.setAlarmId(a);
                    fireAlarm.setActionTime(Calendar.getInstance().getTime());
                    daoEvent.inserir(fireAlarm);
                    Houseowner ho = daoOwner.find(a);
                    Address ad = daoAdress.find(a);
                    Mail.sendMail("O Alarme "+a.getAlarmId()+" da residência "+ad.getStreet()+","+ad.getHouseNumber()+" disparou", "EMERGÊNCIA, O ALARME DA RESIDÊNCIA "+ad.getStreet()+" "+ad.getHouseNumber()+" DISPAROU\nDia:"+fireAlarm.getDateString()+" Horario:"+fireAlarm.getTimeString(), ho.getOwnerMail());                    
                }catch(NumberFormatException e){                    
                }
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }    
    
    public void turnOn() throws IOException{
        String file = Arquivo.lerArquivo("src/main/java/br/com/files/scriptAtivo.ino");        
        output.write(file.getBytes());
    }
    
    public void turnOff() throws IOException{
        Path path = Paths.get("src/main/java/br/com/files/scriptInativo.ino");
        byte[] data = Files.readAllBytes(path);
        output.write(data);
    }
}
