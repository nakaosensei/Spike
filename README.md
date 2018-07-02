# Spike
A simple arduino project with 3 movement sensors, one buzzer that send's an email to a client in case the sensors detect movement, the idea is to simulate an alarm system. Additionaly, it will be possible to access the information about the alarm fire sequence of this prototype through console.

This is a project that should not consume much of your time if do you want to reproduce it, to do it you will need:
1x Arduino Uno
3x Movement Sensors
1x Buzzer Arduino Module
1x Usb Cable to connect the Arduino and the Computer
1x Computer with a USB port, JDK + Java IDE, Mysql Database, Arduino Genuino IDE installed.

The first thing to do is mount the circuit, for the code of this project work do as the following:
Presence Sensor 1 - Arduino Port 2
Presence Sensor 2 - Arduino Port 5
Presence Sensor 3 - Arduino Port 4
Buzzer - Arduino Port 3

Also, this components should run using 3V-5V range for VCC, connect the energy VCC/GND pins from the components as you want.

Now you can connect the USB cable from the arduino on the computer, open the Arduino Genuino IDE, you must make a program that read's the input the arduino
get's in the 3 sensors and active the buzzer, additionally, it's necessary to write wich alarm fired in the Serial, because the Java
applitaction will get the arduino input from there.
The code above is an implementation example, there are many other ways to achieve the same result.

int pinoBuzzer = 3;
int pinoPresenca1 = 2;
int pinoPresenca2 = 5;
int pinoPresenca3 = 4;
int ciclos1=0;
int ciclos2=0;
int ciclos3=0;
int ciclosPraDisparar=100;
int disparou1=0,disparou2=0,disparou3=0; 
 
void setup() {
 pinMode(pinoBuzzer,OUTPUT);
 pinMode(pinoPresenca1,INPUT);
 pinMode(pinoPresenca2,INPUT);
 pinMode(pinoPresenca3,INPUT);
 Serial.begin(9600);
 
}

void loop() {
  int presenceSensor1,presenceSensor2,presenceSensor3;
  presenceSensor1 = digitalRead(pinoPresenca1);
  presenceSensor2 = digitalRead(pinoPresenca2);
  presenceSensor3 = digitalRead(pinoPresenca3);
    
  if(hasMoved(presenceSensor1)||disparou1){
    if(disparou1==0){
      Serial.println("1");      
    }
    ciclos1++;
    disparou1=1;
    if(ciclos1<=ciclosPraDisparar){
      playSong();      
    }else{
      ciclos1=0;
      disparou1=0;    
    }    
  }
  
  
  if(hasMoved(presenceSensor2)||disparou2){
    if(disparou2==0){
      Serial.println("2");        
    }    
    ciclos2++;
    disparou2=1;
    if(ciclos2<=ciclosPraDisparar){
      playSong();
    }else{
      ciclos2=0;
      disparou2=0;
    }
  }
  if(hasMoved(presenceSensor3)||disparou3){
    if(disparou3==0){
      Serial.println("3");  
    }
    ciclos3++;
    disparou3=1;
    if(ciclos3<=ciclosPraDisparar){
      playSong();
    }else{
      disparou3=0;
      ciclos3=0;
    }    
  }  
}

int hasMoved(int input){
   if(input==HIGH){
      return 1;
   }
   return 0;
}

void playSong(){
    tone(pinoBuzzer,262,200); //DO
    delay(50);
    tone(pinoBuzzer,262,200); //DO
    delay(50);               
}

Not that you made your arduino code, let's create a Java application that can read the result's write in the Serial port, 



















