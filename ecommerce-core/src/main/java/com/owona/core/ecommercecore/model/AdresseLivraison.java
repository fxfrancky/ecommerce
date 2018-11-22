package com.owona.core.ecommercecore.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class AdresseLivraison implements Serializable {

    private static final long serialVersionUID = 921227846105947776L;

    @Id
    @GeneratedValue
    private Long adresseLivraisonId;
    @NotEmpty(message="Please fill in your name")
    private String nomComplet;
    @NotEmpty(message="Please fill in your phone number")
    private String numeroTelephone;
    @NotEmpty(message="Address can not be null")
    private String addresse;
    @NotEmpty(message="City can not be null")
    private String ville;
    @NotEmpty(message="State can not be null")
    private String departement;
    @NotEmpty(message="Country can not be null")
    private String pays;
    @NotEmpty(message="ZipCode can not be null")
    private String codePostal;
    private boolean isDefault;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    public Long getAdresseLivraisonId() {
        return adresseLivraisonId;
    }

    public void setAdresseLivraisonId(Long adresseLivraisonId) {
        this.adresseLivraisonId = adresseLivraisonId;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
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

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
