package br.com.model;

import br.com.model.Address;
import br.com.model.Alarmevent;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-02T08:59:41")
@StaticMetamodel(Alarm.class)
public class Alarm_ { 

    public static volatile SingularAttribute<Alarm, Integer> alarmId;
    public static volatile ListAttribute<Alarm, Alarmevent> alarmeventList;
    public static volatile SingularAttribute<Alarm, Address> addressId;

}