/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.model.Address;
import br.com.model.Alarmevent;
import br.com.model.Houseowner;
import br.com.model.dao.DAOAlarm;
import br.com.model.dao.DAOAlarmEvent;
import br.com.model.dao.DAOOwner;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nakao
 */
public class InterfaceController {
    public static void main(String[] args) {
        DAOAlarm daoA = new DAOAlarm();
        DAOAlarmEvent daoE = new DAOAlarmEvent();
        DAOOwner daoO = new DAOOwner();
        Scanner in = new Scanner(System.in);
        Houseowner owner = daoO.find("nakaosensei@gmail.com");
        owner.print();
        Integer input=0;
        while(!input.equals("2")){
            System.out.println("1-Exibir disparos recentes dos alarmes");
            System.out.println("2-Exibir sequencia de disparo");
            System.out.println("3-Sair");
            input = Integer.parseInt(in.nextLine());
            switch(input){
                case 1:
                    for(Address s:owner.getAddressList()){
                        s.print(daoE);
                    }                    
                    break;
                case 2:
                    List<Alarmevent> events = daoE.getEventListFromAdress(1);
                    for(Alarmevent e:events){
                        e.print();
                    }
                    break;                
                default:
                    break;
            }                
                
            
        }       
    }
}
