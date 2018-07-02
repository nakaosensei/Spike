package br.com.model.dao;

import br.com.model.Address;
import br.com.model.Alarm;
import br.com.model.Houseowner;
import static br.com.model.dao.DAOGenerico.em;
import java.util.List;
import javax.persistence.TypedQuery;


/**
 *
 * @author nakao
 */
public class DAOOwner extends DAOGenerico<Houseowner>{
    
    public DAOOwner() {
        super(Houseowner.class);
    }    
    
    public boolean login(String mail, String password){
        TypedQuery<Houseowner> query = em.createQuery("SELECT c FROM "+Houseowner.class.getSimpleName()+" AS C WHERE C.ownerMail like ':mail' AND C.ownerPw like ':pw'", Houseowner.class);
        query.setParameter("mail", mail);
        query.setParameter("pw", password);
        List<Houseowner> result = query.getResultList();
        if(result.size()==1){
            return true;
        }
        return false;
    }
    
    public Houseowner find(String mail){
        TypedQuery<Houseowner> query = em.createQuery("SELECT c FROM "+Houseowner.class.getSimpleName()+" AS C WHERE C.ownerMail like ':mail'", Houseowner.class);
        query.setParameter("mail", mail);
        List<Houseowner> result = query.getResultList();
        if(result.size()==1){
            result.get(0);
        }
        return null;
    };
    
    public Houseowner find(Alarm a){
        DAOAddress daoA = new DAOAddress();
        Address ad = daoA.find(a);        
        return this.find(ad);
    }
    
    public Houseowner find(Address a){
        return this.obter(a.getOwnerId().getOwnerId());               
    }
    
}
