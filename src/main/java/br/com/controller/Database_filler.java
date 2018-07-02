/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.model.Address;
import br.com.model.Alarm;
import br.com.model.Houseowner;
import br.com.model.dao.DAOAddress;
import br.com.model.dao.DAOAlarm;
import br.com.model.dao.DAOAlarmEvent;
import br.com.model.dao.DAOOwner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nakao
 */
public class Database_filler {
    private DAOAddress daoAdress;
    private DAOOwner daoOwner;
    private DAOAlarmEvent daoEvent;
    private DAOAlarm daoAlarm;
    
    public Database_filler(){
        this.daoAdress = new DAOAddress();
        this.daoOwner = new DAOOwner();
        this.daoEvent = new DAOAlarmEvent();
        this.daoAlarm = new DAOAlarm();
    }
    
    public void fillDatabase(){
        Address ad = new Address();        
        ad.setHouseNumber(809);
        ad.setStreet("Prefeito Devete de Paula Xavier");
        ad.setZipCode("87302190");
        
        
        Alarm alarm1 = new Alarm();        
        Alarm alarm2 = new Alarm();
        Alarm alarm3 = new Alarm();
        
        alarm1.setAddressId(ad);
        alarm2.setAddressId(ad);
        alarm3.setAddressId(ad);
        
        Houseowner ho = new Houseowner();
        ho.setOwnerId(1);
        ho.setOwnerMail("nakaosensei@gmail.com");
        ho.setOwnerName("Thiago Nakao");
        ho.setOwnerPw("123456");
        
        ad.setOwnerId(ho);
        List<Address> al = new ArrayList<Address>();
        al.add(ad);
        ho.setAddressList(al);
        
        this.daoOwner.inserir(ho);
        this.daoAdress.inserir(ad);                
        this.daoAlarm.inserir(alarm1);
        this.daoAlarm.inserir(alarm2);
        this.daoAlarm.inserir(alarm3);        
    }
    
    public static void main(String[] args){
        Database_filler df = new Database_filler();
        df.fillDatabase();
    }
}
