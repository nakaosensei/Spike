package br.com.model.dao;

import br.com.model.Address;
import br.com.model.Alarm;
import br.com.model.Houseowner;
import static br.com.model.dao.DAOGenerico.em;
import javax.persistence.TypedQuery;

/**
 *
 * @author nakao
 */
public class DAOAddress extends DAOGenerico<Address>{
    
    public DAOAddress() {
        super(Address.class);
    }
    
    
    public Address find(Alarm a){        
        TypedQuery<Address> query = em.createQuery("SELECT c FROM "+Address.class.getSimpleName()+" AS C WHERE C.addressId = :addressId", Address.class);
        query.setParameter("addressId", a.getAddressId().getAddressId());
        return query.getSingleResult();
    }
    
}
