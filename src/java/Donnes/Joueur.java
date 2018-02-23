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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author utilisateur
 */
@Entity
@Table(name = "joueur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Joueur.findAll", query = "SELECT j FROM Joueur j")
    , @NamedQuery(name = "Joueur.findByPseudo", query = "SELECT j FROM Joueur j WHERE j.pseudo = :pseudo")
    , @NamedQuery(name = "Joueur.findByPassword", query = "SELECT j FROM Joueur j WHERE j.password = :password")
    , @NamedQuery(name = "Joueur.findByAge", query = "SELECT j FROM Joueur j WHERE j.age = :age")
    , @NamedQuery(name = "Joueur.findBySexe", query = "SELECT j FROM Joueur j WHERE j.sexe = :sexe")
    , @NamedQuery(name = "Joueur.findByVille", query = "SELECT j FROM Joueur j WHERE j.ville = :ville")
    , @NamedQuery(name = "Joueur.findByNbrPartieJouer", query = "SELECT j FROM Joueur j WHERE j.nbrPartieJouer = :nbrPartieJouer")
    , @NamedQuery(name = "Joueur.findByNbrVictoire", query = "SELECT j FROM Joueur j WHERE j.nbrVictoire = :nbrVictoire")
    , @NamedQuery(name = "Joueur.findByNbrVectMoyen", query = "SELECT j FROM Joueur j WHERE j.nbrVectMoyen = :nbrVectMoyen")
    , @NamedQuery(name = "Joueur.findByScoreMoy", query = "SELECT j FROM Joueur j WHERE j.scoreMoy = :scoreMoy")
    , @NamedQuery(name = "Joueur.findByMoyNbrSuiteGagner", query = "SELECT j FROM Joueur j WHERE j.moyNbrSuiteGagner = :moyNbrSuiteGagner")
    , @NamedQuery(name = "Joueur.findByMoyNbrChouPerdue", query = "SELECT j FROM Joueur j WHERE j.moyNbrChouPerdue = :moyNbrChouPerdue")
    , @NamedQuery(name = "Joueur.findByNbrsuitesgagnes", query = "SELECT j FROM Joueur j WHERE j.nbrsuitesgagnes = :nbrsuitesgagnes")
    , @NamedQuery(name = "Joueur.findByNbrchouettesperdues", query = "SELECT j FROM Joueur j WHERE j.nbrchouettesperdues = :nbrchouettesperdues")})
public class Joueur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pseudo")
    private String pseudo;
    @Column(name = "password")
    private String password;
    @Column(name = "age")
    private Integer age;
    @Column(name = "sexe")
    private Character sexe;
    @Column(name = "ville")
    private String ville;
    @Column(name = "nbr_partie_jouer")
    private Integer nbrPartieJouer;
    @Column(name = "nbr_victoire")
    private Integer nbrVictoire;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nbr_vect_moyen")
    private Double nbrVectMoyen;
    @Column(name = "score_moy")
    private Double scoreMoy;
    @Column(name = "moy_nbr_suite_gagner")
    private Double moyNbrSuiteGagner;
    @Column(name = "moy_nbr_chou_perdue")
    private Double moyNbrChouPerdue;
    @Column(name = "nbrsuitesgagnes")
    private Integer nbrsuitesgagnes=0;
    @Column(name = "nbrchouettesperdues")
    private Integer nbrchouettesperdues=0;
    @OneToMany(mappedBy = "winner")
    private Set<Partie> partieSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "joueur")
    private Set<Historique> historiqueSet;
    @Transient
    private int Score=0;
    @Transient
    private int etat=0;
    @Transient
    private int tour;
    @Transient
    public int des []={0,0,0};
   
    public Joueur() {
    }

   
    
    public Joueur(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getSexe() {
        return sexe;
    }

    public void setSexe(Character sexe) {
        this.sexe = sexe;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }
    
    public int getEtat() {
        return etat;
    }

    public int getTour() {
        return tour;
    }
   
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getNbrPartieJouer() {
        return nbrPartieJouer;
    }

    public void setNbrPartieJouer(Integer nbrPartieJouer) {
        this.nbrPartieJouer = nbrPartieJouer;
    }

    public Integer getNbrVictoire() {
        return nbrVictoire;
    }

    public void setNbrVictoire(Integer nbrVictoire) {
        this.nbrVictoire = nbrVictoire;
    }

    public Double getNbrVectMoyen() {
        return nbrVectMoyen;
    }

    public void setNbrVectMoyen(Double nbrVectMoyen) {
        this.nbrVectMoyen = nbrVectMoyen;
    }

    public Double getScoreMoy() {
        return scoreMoy;
    }

    public void setScoreMoy(Double scoreMoy) {
        this.scoreMoy = scoreMoy;
    }

    public Double getMoyNbrSuiteGagner() {
        return moyNbrSuiteGagner;
    }

    public void setMoyNbrSuiteGagner(Double moyNbrSuiteGagner) {
        this.moyNbrSuiteGagner = moyNbrSuiteGagner;
    }

    public Double getMoyNbrChouPerdue() {
        return moyNbrChouPerdue;
    }

    public void setMoyNbrChouPerdue(Double moyNbrChouPerdue) {
        this.moyNbrChouPerdue = moyNbrChouPerdue;
    }

    public Integer getNbrsuitesgagnes() {
        return nbrsuitesgagnes;
    }

    public void setNbrsuitesgagnes(Integer nbrsuitesgagnes) {
        this.nbrsuitesgagnes = nbrsuitesgagnes;
    }

    public Integer getNbrchouettesperdues() {
        return nbrchouettesperdues;
    }

    public void setNbrchouettesperdues(Integer nbrchouettesperdues) {
        this.nbrchouettesperdues = nbrchouettesperdues;
    }

    @XmlTransient
    public Set<Partie> getPartieSet() {
        return partieSet;
    }

    public void setPartieSet(Set<Partie> partieSet) {
        this.partieSet = partieSet;
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
        hash += (pseudo != null ? pseudo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Joueur)) {
            return false;
        }
        Joueur other = (Joueur) object;
        if ((this.pseudo == null && other.pseudo != null) || (this.pseudo != null && !this.pseudo.equals(other.pseudo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Donnes.Joueur[ pseudo=" + pseudo + " ]";
    }
    
}
