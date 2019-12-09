/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pieji
 */
@Entity
@Table(name = "reservaties")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservaties.findAll", query = "SELECT r FROM Reservaties r")
    , @NamedQuery(name = "Reservaties.findLast", query = "SELECT max(r.rId) FROM Reservaties r")
    , @NamedQuery(name = "Reservaties.findByRId", query = "SELECT r FROM Reservaties r WHERE r.rId = :rId")
    , @NamedQuery(name = "Reservaties.findByRPrijs", query = "SELECT r FROM Reservaties r WHERE r.rPrijs = :rPrijs")})
public class Reservaties implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "r_id")
    private Integer rId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "r_prijs")
    private int rPrijs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mRes")
    private List<Momenten> momentenList;
    @JoinColumn(name = "r_user", referencedColumnName = "u_id")
    @ManyToOne(optional = false)
    private Users rUser;

    public Reservaties() {
    }

    public Reservaties(Integer rId) {
        this.rId = rId;
    }

    public Reservaties(Integer rId, int rPrijs) {
        this.rId = rId;
        this.rPrijs = rPrijs;
    }

    public Integer getRId() {
        return rId;
    }

    public void setRId(Integer rId) {
        this.rId = rId;
    }

    public int getRPrijs() {
        return rPrijs;
    }

    public void setRPrijs(int rPrijs) {
        this.rPrijs = rPrijs;
    }

    @XmlTransient
    public List<Momenten> getMomentenList() {
        return momentenList;
    }

    public void setMomentenList(List<Momenten> momentenList) {
        this.momentenList = momentenList;
    }

    public Users getRUser() {
        return rUser;
    }

    public void setRUser(Users rUser) {
        this.rUser = rUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rId != null ? rId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservaties)) {
            return false;
        }
        Reservaties other = (Reservaties) object;
        if ((this.rId == null && other.rId != null) || (this.rId != null && !this.rId.equals(other.rId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Reservaties[ rId=" + rId + " ]";
    }
    
}
