package com.owona.core.ecommercecore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = -1836726872479056197L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;

    @NotEmpty(message = "Email can not be blank")
    private String email;

    @NotEmpty (message = "Password can not be blank")
    private String password;

    @NotEmpty (message = "Name can not be blank")
    private String nomClient;

    //@Column(columnDefinition="DATETIME")
    private Date registerDate;

    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "panier")
    @JsonIgnore
    private Panier panier;

    @OneToMany(mappedBy = "client")
    private List<Role> roles;

    @OneToMany(mappedBy = "client")
    private List<ProduitCommentaire> produitCommentaireList;

    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<AdresseLivraison> adresseLivraisonList;

    @OneToMany(mappedBy = "client")
    private List<Code> codes;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<ProduitCommentaire> getProduitCommentaireList() {
        return produitCommentaireList;
    }

    public void setProduitCommentaireList(List<ProduitCommentaire> produitCommentaireList) {
        this.produitCommentaireList = produitCommentaireList;
    }

    public List<AdresseLivraison> getAdresseLivraisonList() {
        return adresseLivraisonList;
    }

    public void setAdresseLivraisonList(List<AdresseLivraison> adresseLivraisonList) {
        this.adresseLivraisonList = adresseLivraisonList;
    }

    public List<Code> getCodes() {
        return codes;
    }

    public void setCodes(List<Code> codes) {
        this.codes = codes;
    }
}
