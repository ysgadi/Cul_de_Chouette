/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Donnes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author utilisateur
 */
@Entity
@Table(name = "historique")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historique.findAll", query = "SELECT h FROM Historique h")
    , @NamedQuery(name = "Historique.findByIdPartie", query = "SELECT h FROM Historique h WHERE h.historiquePK.idPartie = :idPartie")
    , @NamedQuery(name = "Historique.findByPseudo", query = "SELECT h FROM Historique h WHERE h.historiquePK.pseudo = :pseudo")
    , @NamedQuery(name = "Historique.findByNbrSuiteGanger", query = "SELECT h FROM Historique h WHERE h.nbrSuiteGanger = :nbrSuiteGanger")
    , @NamedQuery(name = "Historique.findByNbrChouPerdue", query = "SELECT h FROM Historique h WHERE h.nbrChouPerdue = :nbrChouPerdue")
    , @NamedQuery(name = "Historique.findByScoreJoueur", query = "SELECT h FROM Historique h WHERE h.scoreJoueur = :scoreJoueur")})
public class Historique implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistoriquePK historiquePK;
    @Column(name = "nbr_suite_ganger")
    private Integer nbrSuiteGanger;
    @Column(name = "nbr_chou_perdue")
    private Integer nbrChouPerdue;
    @Column(name = "score_joueur")
    private Integer scoreJoueur;
    @JoinColumn(name = "pseudo", referencedColumnName = "pseudo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Joueur joueur;
    @JoinColumn(name = "id_partie", referencedColumnName = "id_partie", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Partie partie;

    public Historique() {
    }

    public Historique(HistoriquePK historiquePK) {
        this.historiquePK = historiquePK;
    }

    public Historique(int idPartie, String pseudo) {
        this.historiquePK = new HistoriquePK(idPartie, pseudo);
    }

    public HistoriquePK getHistoriquePK() {
        return historiquePK;
    }

    public void setHistoriquePK(HistoriquePK historiquePK) {
        this.historiquePK = historiquePK;
    }

    public Integer getNbrSuiteGanger() {
        return nbrSuiteGanger;
    }

    public void setNbrSuiteGanger(Integer nbrSuiteGanger) {
        this.nbrSuiteGanger = nbrSuiteGanger;
    }

    public Integer getNbrChouPerdue() {
        return nbrChouPerdue;
    }

    public void setNbrChouPerdue(Integer nbrChouPerdue) {
        this.nbrChouPerdue = nbrChouPerdue;
    }

    public Integer getScoreJoueur() {
        return scoreJoueur;
    }

    public void setScoreJoueur(Integer scoreJoueur) {
        this.scoreJoueur = scoreJoueur;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historiquePK != null ? historiquePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historique)) {
            return false;
        }
        Historique other = (Historique) object;
        if ((this.historiquePK == null && other.historiquePK != null) || (this.historiquePK != null && !this.historiquePK.equals(other.historiquePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Donnes.Historique[ historiquePK=" + historiquePK + " ]";
    }
    
}
