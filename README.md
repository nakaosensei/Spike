# Spike
This is a simple arduino project with 3 movement sensors, one buzzer that sends an email to a client in case the sensors detect movement, the idea is to simulate an alarm system. Additionally, it will be possible to access the information about the alarm fire sequence of this prototype through console.  
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

Now you can connect the USB cable from the arduino on the computer, open the Arduino Genuino IDE, you must make a program that reads the   input the arduino
get's in the 3 sensors and active the buzzer, additionally, it's necessary to write which alarm fired in the Serial, because the Java
application will get the arduino input from there.  
You can see the code that i used in this application by opening this file in arduino genuino ide:
src/main/java/br/com/files/scriptAtivo.ino

The code here is quite simple, all I do there is to set the 3 movement sensors as inputs, and the buzzer as output, then I read the values from the 3 input sensors, if any of them fired in the last 100 cycles, I print they identification number in the Serial output. NOTE:The serial will be used by the java application to get what alarm fired at what time.

Not that you made your arduino code, let's create a Java application that can read the result's write in the Serial port, for that you will need the following external jars:  
1x rxtxcomm.jar  
1x Mysql connector 5.1.39(can be any acctualy, i used this one).  
1x eclipselink persistence  
1x javax.mail  
1x javax.activation  

The most of these can be easily downloaded through Maven, add the following to your pom.xml.  

Well, the only problem will be the rxtxcomm, which you should find the jar in you operational system, to do that, follow this tutorial:  
https://docs.google.com/document/d/e/2PACX-1vQSTA9ZHnrKgeJIDlze04O_JAbpYKKXLcbh5tQu3UCxhoALRafSE8F3VKDWZuFU6UO_Qv5mNnOC7ncX/pub  

Also, we will save the fire alarm in a database, for that, use the script Database to create the database used in this application.  

The database contain 4 tables, they are:  
ALARMEVENT -> Saves the fire alarm history  
ALARM -> Identification for each movement sensor, each alarm can have many alarm events, but each event can only have one alarm  
ADDRESS -> Address location, one address can have many alarms, but each alarm resides in just one address  
HOUSEOWNER -> Contains information about the owner of an address, his informations will be used to send an email when some alarm
fire, one owner can have many addresses, and one address is tied to one owner.  

Now, ,create a java application in your favourite IDE, if you are using maven, add the dependencies described in your pom.xml and add the rxtx jar, if you're not using maven, download all the jars and add then to your project.  

The first thing we've gotta do is to get the information written in the Serial port by the Arduino, to do that we will use the ArduinoBridge class, open it.  

As you can see, this class implements SerialPortEventListener, first it tries to find out what Serial port are you using in a while structure, then when it finds out, it instantiates the class serial port, after that it also instantiate the class inputStream reader that will be
used later. NOTE: BEFORE ANYTHING, YOU SHOULD CALL THE INITIALIZE() METHOD.  

Note that there is another big method in this class, called serialEvent, we programmed it to react to every change in the Serial port we are listening to, here is where we get the information that the arduino sent to us, each time an alarm fires, it prints it's number in the serial, so here we obtain it's id, get the date time and register an alarmEvent in the ALARMEVENT table for that alarm/date, also, we send
an email to the owner of the address which has that alarm that fired.  

Well, sending the email was really easy through the Mail class, all you have to do is to set the SMTP parameters and use POP, I’ve implemented
a send mail method that uses the default email nksecuresystem@gmail.com, an email that i created just for this project.  

You will also note that there is Java objects and DAO's to access the database, this is because i used a persistence unity to access the database, basically I’ve created the Java classes with the correct annotations, created the persistence unity, configured it with my database credentials, and did it. Later on, I’ve used a class called DAOGenerico, this class uses the persistence unity to access any Object referring to the database, but i extended a single DAOVersion for each one of our for tables, so we've got:  
DAOAddress  
DAOAlarm  
DAOOwner  
DAOAlarmEvent  

If you decide to look in these, you will see that some of them have some methods to get some information in the database, for example, DAOOwner has an method called login that checks if there is a determined mail/pw in the database, and returns the object if it exists, i used JQPL to make those queries.  

Well, now we have a system that every time an alarm fires, it sends an email to the owner of the address where the alarm fired, it also activates the buzzer but that is just to de notate what should happen in real life, but we still can't do anything with the information stored in the database, let's make an simple interface where we retrieve some information about it, like the last time an alarm fired and also the sequence which they fired for an Address, for that, check the InterfaceController class, there I’ve implemented a simple text/console interface where you can get the fire alarm information for a specific user, in this case, myself.  

Please note, before running the  InterfaceController main method, you should run the fillDatabase method from DatabaseFiller class, this project have a structure that could support a level where there is many alarms in a lot of addresses, and each house has a owner with an login and password, where he can choose an address and then see for each of them, which alarm fired at what time, but this has not been yet implemented, for that i would probably use an web interface instead of a simple console interface for demonstration.  

There is nothing complex here, there is an old-fashioned menu where you can choose to show the alarms from the addresses that the user nakaosensei@gmail.com has(that should be just one address, with 3 alarms/sensors), also, the second option displays the fire sequence from the alarms.  

And DONE! Now you have a system that stores the alarm fire in a mysql Database, send an email warning the house owner that the alarm of his house fired, and also can check the fire sequence. Hurray =).  





 
 



 

























