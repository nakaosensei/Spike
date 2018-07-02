package br.com.controller;

import br.com.model.Alarmevent;
import br.com.model.Arquivo;
import br.com.model.dao.DAOAlarmEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author nakao
 */
public class Test {
    
    public static void main(String[] args) throws IOException {
        
        DAOAlarmEvent dao = new DAOAlarmEvent();
        List<Alarmevent> e =  dao.getEventListFromAlarm(1);
        for(Alarmevent a:e){
            System.out.println(a.getAlarmId());
            a.print();
        }
    }    
}
