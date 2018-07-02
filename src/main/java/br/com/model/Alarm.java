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
@Table(name = "ALARM")
@NamedQueries({
    @NamedQuery(name = "Alarm.findAll", query = "SELECT a FROM Alarm a")
    , @NamedQuery(name = "Alarm.findByAlarmId", query = "SELECT a FROM Alarm a WHERE a.alarmId = :alarmId")})
public class Alarm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ALARM_ID")
    private Integer alarmId;
    @OneToMany(mappedBy = "alarmId")
    private List<Alarmevent> alarmeventList;
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    @ManyToOne
    private Address addressId;

    public Alarm() {
    }

    public Alarm(Integer alarmId) {
        this.alarmId = alarmId;
    }

    public Integer getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(Integer alarmId) {
        this.alarmId = alarmId;
    }

    public List<Alarmevent> getAlarmeventList() {
        return alarmeventList;
    }

    public void setAlarmeventList(List<Alarmevent> alarmeventList) {
        this.alarmeventList = alarmeventList;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alarmId != null ? alarmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alarm)) {
            return false;
        }
        Alarm other = (Alarm) object;
        if ((this.alarmId == null && other.alarmId != null) || (this.alarmId != null && !this.alarmId.equals(other.alarmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.model.Alarm[ alarmId=" + alarmId + " ]";
    }
    
    public void print(DAOAlarmEvent daoAE){
        System.out.println("Alarm "+this.alarmId);
        List<Alarmevent> events = daoAE.getEventListFromAlarm(this.alarmId);
        if(events!=null&&events.size()>0){
            System.out.println("Ultimo disparo - Date:"+events.get(0).getTimeString()+" Time:"+events.get(0).getTimeString());
        }
    }

    
}
