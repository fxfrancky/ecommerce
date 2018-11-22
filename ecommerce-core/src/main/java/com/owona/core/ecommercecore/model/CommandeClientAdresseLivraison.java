package com.owona.core.ecommercecore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CommandeClientAdresseLivraison implements Serializable {

    private static final long serialVersionUID = 9001223266668134199L;

    @Id
    @GeneratedValue
    private Long addresseLivraisonId;
    private String nomComplet;
    private String numTelephone;
    private String addresse;
    private String ville;
    private String departement;
    private String pays;
    private String codePostal;
    private Long addresseLivraisOnoriginale;

    @OneToOne
    @JoinColumn(name = "customerOrderId")
    @JsonIgnore
    private CommandeClient commandeClient;

    public Long getAddresseLivraisonId() {
        return addresseLivraisonId;
    }

    public void setAddresseLivraisonId(Long addresseLivraisonId) {
        this.addresseLivraisonId = addresseLivraisonId;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public Long getAddresseLivraisOnoriginale() {
        return addresseLivraisOnoriginale;
    }

    public void setAddresseLivraisOnoriginale(Long addresseLivraisOnoriginale) {
        this.addresseLivraisOnoriginale = addresseLivraisOnoriginale;
    }

    public CommandeClient getCommandeClient() {
        return commandeClient;
    }

    public void setCommandeClient(CommandeClient commandeClient) {
        this.commandeClient = commandeClient;
    }
}
