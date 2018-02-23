/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Donnes;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author utilisateur
 */
@Embeddable
public class HistoriquePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_partie")
    private int idPartie;
    @Basic(optional = false)
    @Column(name = "pseudo")
    private String pseudo;

    public HistoriquePK() {
    }

    public HistoriquePK(int idPartie, String pseudo) {
        this.idPartie = idPartie;
        this.pseudo = pseudo;
    }

    public int getIdPartie() {
        return idPartie;
    }

    public void setIdPartie(int idPartie) {
        this.idPartie = idPartie;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPartie;
        hash += (pseudo != null ? pseudo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoriquePK)) {
            return false;
        }
        HistoriquePK other = (HistoriquePK) object;
        if (this.idPartie != other.idPartie) {
            return false;
        }
        if ((this.pseudo == null && other.pseudo != null) || (this.pseudo != null && !this.pseudo.equals(other.pseudo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Donnes.HistoriquePK[ idPartie=" + idPartie + ", pseudo=" + pseudo + " ]";
    }
    
}
