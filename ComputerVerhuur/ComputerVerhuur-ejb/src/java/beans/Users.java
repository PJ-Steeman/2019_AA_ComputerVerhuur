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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUId", query = "SELECT u FROM Users u WHERE u.uId = :uId")
    , @NamedQuery(name = "Users.findByUNaam", query = "SELECT u FROM Users u WHERE u.uNaam = :uNaam")
    , @NamedQuery(name = "Users.findByUWachtwoord", query = "SELECT u FROM Users u WHERE u.uWachtwoord = :uWachtwoord")
    , @NamedQuery(name = "Users.findByURichting", query = "SELECT u FROM Users u WHERE u.uRichting = :uRichting")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "u_id")
    private String uId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "u_naam")
    private String uNaam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "u_wachtwoord")
    private String uWachtwoord;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "u_richting")
    private String uRichting;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rUser")
    private List<Reservaties> reservatiesList;

    public Users() {
    }

    public Users(String uId) {
        this.uId = uId;
    }

    public Users(String uId, String uNaam, String uWachtwoord, String uRichting) {
        this.uId = uId;
        this.uNaam = uNaam;
        this.uWachtwoord = uWachtwoord;
        this.uRichting = uRichting;
    }

    public String getUId() {
        return uId;
    }

    public void setUId(String uId) {
        this.uId = uId;
    }

    public String getUNaam() {
        return uNaam;
    }

    public void setUNaam(String uNaam) {
        this.uNaam = uNaam;
    }

    public String getUWachtwoord() {
        return uWachtwoord;
    }

    public void setUWachtwoord(String uWachtwoord) {
        this.uWachtwoord = uWachtwoord;
    }

    public String getURichting() {
        return uRichting;
    }

    public void setURichting(String uRichting) {
        this.uRichting = uRichting;
    }

    @XmlTransient
    public List<Reservaties> getReservatiesList() {
        return reservatiesList;
    }

    public void setReservatiesList(List<Reservaties> reservatiesList) {
        this.reservatiesList = reservatiesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uId != null ? uId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.uId == null && other.uId != null) || (this.uId != null && !this.uId.equals(other.uId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Users[ uId=" + uId + " ]";
    }
    
}
