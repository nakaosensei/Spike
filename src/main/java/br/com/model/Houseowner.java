/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "HOUSEOWNER")
@NamedQueries({
    @NamedQuery(name = "Houseowner.findAll", query = "SELECT h FROM Houseowner h")
    , @NamedQuery(name = "Houseowner.findByOwnerId", query = "SELECT h FROM Houseowner h WHERE h.ownerId = :ownerId")
    , @NamedQuery(name = "Houseowner.findByOwnerName", query = "SELECT h FROM Houseowner h WHERE h.ownerName = :ownerName")
    , @NamedQuery(name = "Houseowner.findByOwnerMail", query = "SELECT h FROM Houseowner h WHERE h.ownerMail = :ownerMail")
    , @NamedQuery(name = "Houseowner.findByOwnerPw", query = "SELECT h FROM Houseowner h WHERE h.ownerPw = :ownerPw")})
public class Houseowner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OWNER_ID")
    private Integer ownerId;
    @Column(name = "OWNER_NAME")
    private String ownerName;
    @Column(name = "OWNER_MAIL")
    private String ownerMail;
    @Column(name = "OWNER_PW")
    private String ownerPw;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerId")
    private List<Address> addressList;

    public Houseowner() {
    }

    public Houseowner(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerMail() {
        return ownerMail;
    }

    public void setOwnerMail(String ownerMail) {
        this.ownerMail = ownerMail;
    }

    public String getOwnerPw() {
        return ownerPw;
    }

    public void setOwnerPw(String ownerPw) {
        this.ownerPw = ownerPw;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ownerId != null ? ownerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Houseowner)) {
            return false;
        }
        Houseowner other = (Houseowner) object;
        if ((this.ownerId == null && other.ownerId != null) || (this.ownerId != null && !this.ownerId.equals(other.ownerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.model.Houseowner[ ownerId=" + ownerId + " ]";
    }
    
    public void print(){
        System.out.println("name:"+this.ownerName+" mail:"+this.ownerMail);
    }
}
