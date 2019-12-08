/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pieji
 */
@Entity
@Table(name = "momenten")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Momenten.findAll", query = "SELECT m FROM Momenten m")
    , @NamedQuery(name = "Momenten.findLast", query = "SELECT max(m.mId) FROM Momenten m")
    , @NamedQuery(name = "Momenten.findByMComp", query = "SELECT m FROM Momenten m WHERE m.mComp = :mComp")
    , @NamedQuery(name = "Momenten.findByMId", query = "SELECT m FROM Momenten m WHERE m.mId = :mId")
    , @NamedQuery(name = "Momenten.findByMVan", query = "SELECT m FROM Momenten m WHERE m.mVan = :mVan")
    , @NamedQuery(name = "Momenten.findByMTot", query = "SELECT m FROM Momenten m WHERE m.mTot = :mTot")})
public class Momenten implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "m_id")
    private Integer mId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "m_van")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mVan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "m_tot")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mTot;
    @JoinColumn(name = "m_comp", referencedColumnName = "c_id")
    @ManyToOne(optional = false)
    private Computers mComp;
    @JoinColumn(name = "m_res", referencedColumnName = "r_id")
    @ManyToOne(optional = false)
    private Reservaties mRes;

    public Momenten() {
    }

    public Momenten(Integer mId) {
        this.mId = mId;
    }

    public Momenten(Integer mId, Date mVan, Date mTot) {
        this.mId = mId;
        this.mVan = mVan;
        this.mTot = mTot;
    }

    public Integer getMId() {
        return mId;
    }

    public void setMId(Integer mId) {
        this.mId = mId;
    }

    public Date getMVan() {
        return mVan;
    }

    public void setMVan(Date mVan) {
        this.mVan = mVan;
    }

    public Date getMTot() {
        return mTot;
    }

    public void setMTot(Date mTot) {
        this.mTot = mTot;
    }

    public Computers getMComp() {
        return mComp;
    }

    public void setMComp(Computers mComp) {
        this.mComp = mComp;
    }

    public Reservaties getMRes() {
        return mRes;
    }

    public void setMRes(Reservaties mRes) {
        this.mRes = mRes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mId != null ? mId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Momenten)) {
            return false;
        }
        Momenten other = (Momenten) object;
        if ((this.mId == null && other.mId != null) || (this.mId != null && !this.mId.equals(other.mId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Momenten[ mId=" + mId + " ]";
    }
    
}
