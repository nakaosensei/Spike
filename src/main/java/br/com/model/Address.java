/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import br.com.model.dao.DAOAlarmEvent;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ADDRESS")
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findByAddressId", query = "SELECT a FROM Address a WHERE a.addressId = :addressId")
    , @NamedQuery(name = "Address.findByStreet", query = "SELECT a FROM Address a WHERE a.street = :street")
    , @NamedQuery(name = "Address.findByHouseNumber", query = "SELECT a FROM Address a WHERE a.houseNumber = :houseNumber")
    , @NamedQuery(name = "Address.findByZipCode", query = "SELECT a FROM Address a WHERE a.zipCode = :zipCode")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ADDRESS_ID")
    private Integer addressId;
    @Column(name = "STREET")
    private String street;
    @Column(name = "HOUSE_NUMBER")
    private Integer houseNumber;
    @Column(name = "ZIP_CODE")
    private String zipCode;
    @OneToMany(mappedBy = "addressId")
    private List<Alarm> alarmList;
    @JoinColumn(name = "OWNER_ID", referencedColumnName = "OWNER_ID")
    @ManyToOne(optional = false)
    private Houseowner ownerId;

    public Address() {
    }

    public Address(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public List<Alarm> getAlarmList() {
        return alarmList;
    }

    public void setAlarmList(List<Alarm> alarmList) {
        this.alarmList = alarmList;
    }

    public Houseowner getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Houseowner ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.model.Address[ addressId=" + addressId + " ]";
    }
    public void print(DAOAlarmEvent daoAE){
        System.out.println("Street:"+this.street);
	System.out.println("Number:"+this.houseNumber);
	System.out.println("Zip-Code:"+this.zipCode);
	System.out.println("Alarms List:");
	for(Alarm a:this.alarmList){
	    List<Alarmevent> events = daoAE.getEventListFromAlarm(a.getAlarmId());
	    if(events!=null&&events.size()>0){
	        System.out.println("Alarm "+a.getAlarmId()+" Last Fire Date:" + events.get(0).getDateString()+" Hour:"+events.get(0).getTimeString());
	    }else{
	        System.out.println("Alarm "+a.getAlarmId());
	    }            
	}
    }
}
