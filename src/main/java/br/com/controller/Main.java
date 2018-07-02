package br.com.controller;
/**
 *
 * @author nakao
 */
public class Main {
public static void main(String[] args) throws Exception {
        ArduinoBridge main = new ArduinoBridge();
        main.initialize();
        Thread t = new Thread() {
            public void run() {
                try {
                    while(true){
                        Thread.sleep(10000);
                    }                    
                } catch (InterruptedException ie) {
                }
            }
        };
        t.start();
        System.out.println("Started");
    }    
}
