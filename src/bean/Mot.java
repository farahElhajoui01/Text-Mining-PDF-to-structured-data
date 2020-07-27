/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author farah
 */
@Entity
public class Mot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     private String mot;
    private Long rm=Long.valueOf(0);
    private Long acp=Long.valueOf(0);
    private Long afc=Long.valueOf(0);
    private Long acm=Long.valueOf(0);
    private Long ad=Long.valueOf(0);
    private Long c=Long.valueOf(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    public Long getRm() {
        return rm;
    }

    public void setRm(Long rm) {
        this.rm = rm;
    }

    public Long getAcp() {
        return acp;
    }

    public void setAcp(Long acp) {
        this.acp = acp;
    }

    public Long getAfc() {
        return afc;
    }

    public void setAfc(Long afc) {
        this.afc = afc;
    }

    public Long getAcm() {
        return acm;
    }

    public void setAcm(Long acm) {
        this.acm = acm;
    }

    public Long getAd() {
        return ad;
    }

    public void setAd(Long ad) {
        this.ad = ad;
    }

    public Long getC() {
        return c;
    }

    public void setC(Long c) {
        this.c = c;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mot)) {
            return false;
        }
        Mot other = (Mot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Mot[ id=" + id + " ]";
    }
    
    
    
    
}
