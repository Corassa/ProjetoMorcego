#include "LM35.h"
#include <Servo.h>

const int trigPin = 12;
const int echoPin = 13;
Servo motor;

int ledPin =  7; //atribui o pino 13 a variável ledPin 
int dado; //variável que receberá os dados da porta serial


const int LM35 = A0; // Pino Analogico onde vai ser ligado ao pino 2 do LM35
const int REFRESH_RATE = 500;  //Tempo de atualização entre as leituras em ms
const float CELSIUS_BASE = 0.4887585532746823069403714565; //Base de conversão para Graus Celsius ((5/1023) * 100)


void setup(){
  Serial.begin(9600);//frequência da porta serial
  pinMode(ledPin,OUTPUT); //define o pino o ledPin como saída
  Serial.begin(9600);
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  // Aguarda 1 seg antes de acessar as informações do sensor
  delay(1000);
  motor.attach(3);
}
int ang = 0;
void loop(){
  if(Serial.available() > 0){ //verifica se existe comunicação com a porta serial
      dado = Serial.read();//lê os dados da porta serial
      switch(dado){
        case 1:
           digitalWrite(ledPin,HIGH); //liga o pino ledPin
           break;
        case 2:
           digitalWrite(ledPin,LOW); //desliga o pino ledPin
           break;
        case 3:
          for(i = 0; i<180 ; i+=10){
           motor.write(i);
           Serial.print(ler());
           Serial.print(" ");
           Serial.print(i);
           ang += 10;
           Serial.print("\n");
           delay(REFRESH_RATE);
           break;
         }
    }
  }
}

float ler(){
  /*int temp = (analogRead(LM35) * CELSIUS_BASE); 
  return temp;*/
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  unsigned long duracao = pulseIn(echoPin, HIGH);
  int distancia = duracao / 58;
  return(distancia);
}
