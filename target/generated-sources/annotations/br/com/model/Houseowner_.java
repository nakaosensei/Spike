package br.com.model;

import br.com.model.Address;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-30T17:37:54")
@StaticMetamodel(Houseowner.class)
public class Houseowner_ { 

    public static volatile SingularAttribute<Houseowner, String> ownerMail;
    public static volatile SingularAttribute<Houseowner, String> ownerName;
    public static volatile ListAttribute<Houseowner, Address> addressList;
    public static volatile SingularAttribute<Houseowner, String> ownerPw;
    public static volatile SingularAttribute<Houseowner, Integer> ownerId;

}