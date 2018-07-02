package br.com.model;

import br.com.model.Alarm;
import br.com.model.Houseowner;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-30T17:37:54")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> zipCode;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, Integer> houseNumber;
    public static volatile ListAttribute<Address, Alarm> alarmList;
    public static volatile SingularAttribute<Address, Houseowner> ownerId;
    public static volatile SingularAttribute<Address, Integer> addressId;

}