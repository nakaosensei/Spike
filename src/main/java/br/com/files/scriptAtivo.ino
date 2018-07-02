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

