package br.com.model;

import br.com.model.Alarm;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-02T08:59:41")
@StaticMetamodel(Alarmevent.class)
public class Alarmevent_ { 

    public static volatile SingularAttribute<Alarmevent, Date> actionTime;
    public static volatile SingularAttribute<Alarmevent, Alarm> alarmId;
    public static volatile SingularAttribute<Alarmevent, Integer> idEvent;
    public static volatile SingularAttribute<Alarmevent, Date> actionDate;

}