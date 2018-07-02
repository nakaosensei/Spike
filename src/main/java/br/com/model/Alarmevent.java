/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ALARMEVENT")
@NamedQueries({
    @NamedQuery(name = "Alarmevent.findAll", query = "SELECT a FROM Alarmevent a")
    , @NamedQuery(name = "Alarmevent.findByIdEvent", query = "SELECT a FROM Alarmevent a WHERE a.idEvent = :idEvent")
    , @NamedQuery(name = "Alarmevent.findByActionDate", query = "SELECT a FROM Alarmevent a WHERE a.actionDate = :actionDate")
    , @NamedQuery(name = "Alarmevent.findByActionTime", query = "SELECT a FROM Alarmevent a WHERE a.actionTime = :actionTime")})
public class Alarmevent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EVENT")
    private Integer idEvent;
    @Column(name = "ACTION_DATE")
    @Temporal(TemporalType.DATE)
    private Date actionDate;
    @Column(name = "ACTION_TIME")
    @Temporal(TemporalType.TIME)
    private Date actionTime;
    @JoinColumn(name = "ALARM_ID", referencedColumnName = "ALARM_ID")
    @ManyToOne
    private Alarm alarmId;

    public Alarmevent() {
    }

    public Alarmevent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    public Alarm getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(Alarm alarmId) {
        this.alarmId = alarmId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvent != null ? idEvent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alarmevent)) {
            return false;
        }
        Alarmevent other = (Alarmevent) object;
        if ((this.idEvent == null && other.idEvent != null) || (this.idEvent != null && !this.idEvent.equals(other.idEvent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.model.Alarmevent[ idEvent=" + idEvent + " ]";
    }
    
    public String getDateString(){
        return new SimpleDateFormat("yyyy-MM-dd").format(this.actionDate);
    }
    
    public String getTimeString(){
        return new SimpleDateFormat("HH.mm.ss").format(this.actionTime);
    };
    
    public void print(){
        System.out.println("Date:"+ new SimpleDateFormat("yyyy-MM-dd").format(this.actionDate));
        System.out.println("Time:"+ new SimpleDateFormat("HH.mm.ss").format(this.actionTime));
    }
}
