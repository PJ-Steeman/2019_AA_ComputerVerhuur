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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pieji
 */
@Entity
@Table(name = "computers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Computers.findAll", query = "SELECT c FROM Computers c")
    , @NamedQuery(name = "Computers.findLast", query = "SELECT max(c.cId) FROM Computers c")
    , @NamedQuery(name = "Computers.findByCId", query = "SELECT c FROM Computers c WHERE c.cId = :cId")
    , @NamedQuery(name = "Computers.findByCNaam", query = "SELECT c FROM Computers c WHERE c.cNaam = :cNaam")
    , @NamedQuery(name = "Computers.findByCOmsch", query = "SELECT c FROM Computers c WHERE c.cOmsch = :cOmsch")
    , @NamedQuery(name = "Computers.findByCLok", query = "SELECT c FROM Computers c WHERE c.cLok = :cLok")
    , @NamedQuery(name = "Computers.findByCOpl", query = "SELECT c FROM Computers c WHERE c.cOpl = :cOpl")
    , @NamedQuery(name = "Computers.findByCSerie", query = "SELECT c FROM Computers c WHERE c.cSerie = :cSerie")
    , @NamedQuery(name = "Computers.findByCAankoop", query = "SELECT c FROM Computers c WHERE c.cAankoop = :cAankoop")
    , @NamedQuery(name = "Computers.findByCHuur", query = "SELECT c FROM Computers c WHERE c.cHuur = :cHuur")})
public class Computers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_id")
    private Integer cId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "c_naam")
    private String cNaam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "c_omsch")
    private String cOmsch;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "c_lok")
    private String cLok;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "c_opl")
    private String cOpl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_serie")
    private int cSerie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_aankoop")
    private int cAankoop;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_huur")
    private int cHuur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mComp")
    private List<Momenten> momentenList;

    public Computers() {
    }

    public Computers(Integer cId) {
        this.cId = cId;
    }

    public Computers(Integer cId, String cNaam, String cOmsch, String cLok, String cOpl, int cSerie, int cAankoop, int cHuur) {
        this.cId = cId;
        this.cNaam = cNaam;
        this.cOmsch = cOmsch;
        this.cLok = cLok;
        this.cOpl = cOpl;
        this.cSerie = cSerie;
        this.cAankoop = cAankoop;
        this.cHuur = cHuur;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCNaam() {
        return cNaam;
    }

    public void setCNaam(String cNaam) {
        this.cNaam = cNaam;
    }

    public String getCOmsch() {
        return cOmsch;
    }

    public void setCOmsch(String cOmsch) {
        this.cOmsch = cOmsch;
    }

    public String getCLok() {
        return cLok;
    }

    public void setCLok(String cLok) {
        this.cLok = cLok;
    }

    public String getCOpl() {
        return cOpl;
    }

    public void setCOpl(String cOpl) {
        this.cOpl = cOpl;
    }

    public int getCSerie() {
        return cSerie;
    }

    public void setCSerie(int cSerie) {
        this.cSerie = cSerie;
    }

    public int getCAankoop() {
        return cAankoop;
    }

    public void setCAankoop(int cAankoop) {
        this.cAankoop = cAankoop;
    }

    public int getCHuur() {
        return cHuur;
    }

    public void setCHuur(int cHuur) {
        this.cHuur = cHuur;
    }

    @XmlTransient
    public List<Momenten> getMomentenList() {
        return momentenList;
    }

    public void setMomentenList(List<Momenten> momentenList) {
        this.momentenList = momentenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cId != null ? cId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Computers)) {
            return false;
        }
        Computers other = (Computers) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Computers[ cId=" + cId + " ]";
    }
    
}
