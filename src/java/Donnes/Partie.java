/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Donnes;

import java.io.Serializable;
import java.util.Set;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author utilisateur
 */
@Entity
@Table(name = "partie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partie.findAll", query = "SELECT p FROM Partie p")
    , @NamedQuery(name = "Partie.findByIdPartie", query = "SELECT p FROM Partie p WHERE p.idPartie = :idPartie")
    , @NamedQuery(name = "Partie.findByScoretotale", query = "SELECT p FROM Partie p WHERE p.scoretotale = :scoretotale")
    , @NamedQuery(name = "Partie.findByNbrsuite", query = "SELECT p FROM Partie p WHERE p.nbrsuite = :nbrsuite")
    , @NamedQuery(name = "Partie.findByNbrchouettes", query = "SELECT p FROM Partie p WHERE p.nbrchouettes = :nbrchouettes")
    , @NamedQuery(name = "Partie.findByLimitscore", query = "SELECT p FROM Partie p WHERE p.limitscore = :limitscore")})
public class Partie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_partie")
    private Integer idPartie;
    @Column(name = "scoretotale")
    private Integer scoretotale;
    @Column(name = "nbrsuite")
    private Integer nbrsuite;
    @Column(name = "nbrchouettes")
    private Integer nbrchouettes;
    @Column(name = "limitscore")
    private Integer limitscore;
    @JoinColumn(name = "winner", referencedColumnName = "pseudo")
    @ManyToOne
    private Joueur winner;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partie")
    private Set<Historique> historiqueSet;

    public Partie() {
    }

    public Partie(Integer idPartie) {
        this.idPartie = idPartie;
    }

    public Integer getIdPartie() {
        return idPartie;
    }

    public void setIdPartie(Integer idPartie) {
        this.idPartie = idPartie;
    }

    public Integer getScoretotale() {
        return scoretotale;
    }

    public void setScoretotale(Integer scoretotale) {
        this.scoretotale = scoretotale;
    }

    public Integer getNbrsuite() {
        return nbrsuite;
    }

    public void setNbrsuite(Integer nbrsuite) {
        this.nbrsuite = nbrsuite;
    }

    public Integer getNbrchouettes() {
        return nbrchouettes;
    }

    public void setNbrchouettes(Integer nbrchouettes) {
        this.nbrchouettes = nbrchouettes;
    }

    public Integer getLimitscore() {
        return limitscore;
    }

    public void setLimitscore(Integer limitscore) {
        this.limitscore = limitscore;
    }

    public Joueur getWinner() {
        return winner;
    }

    public void setWinner(Joueur winner) {
        this.winner = winner;
    }

    @XmlTransient
    public Set<Historique> getHistoriqueSet() {
        return historiqueSet;
    }

    public void setHistoriqueSet(Set<Historique> historiqueSet) {
        this.historiqueSet = historiqueSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPartie != null ? idPartie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partie)) {
            return false;
        }
        Partie other = (Partie) object;
        if ((this.idPartie == null && other.idPartie != null) || (this.idPartie != null && !this.idPartie.equals(other.idPartie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Donnes.Partie[ idPartie=" + idPartie + " ]";
    }
    
}
