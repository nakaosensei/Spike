package br.com.model.dao;

import br.com.model.Address;
import br.com.model.Alarm;

import br.com.model.Alarmevent;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author nakao
 */
public class DAOAlarmEvent extends DAOGenerico<Alarmevent>{
    
    public DAOAlarmEvent() {
        super(Alarmevent.class);
    }
    
    public List<Alarmevent> getEventListFromAlarm(int alarmId){
        TypedQuery<Alarmevent> query = em.createQuery("SELECT c FROM "+Alarmevent.class.getSimpleName()+" AS C WHERE C.alarmId.alarmId= :alarmId ORDER BY C.actionDate,C.actionTime DESC", Alarmevent.class);
        query.setParameter("alarmId", alarmId);
        
        return query.getResultList();  
    }
    
   public List<Alarmevent> getEventListFromAdress(int addressId){
        TypedQuery<Alarmevent> query = em.createQuery("SELECT c FROM "+Alarmevent.class.getSimpleName()+" AS C WHERE C.alarmId.addressId.addressId = :addressId ORDER BY C.actionDate,C.actionTime DESC", Alarmevent.class);
        query.setParameter("addressId", addressId);        
        return query.getResultList();  
    }
    
   
    
}