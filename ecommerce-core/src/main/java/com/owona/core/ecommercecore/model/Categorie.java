package com.owona.core.ecommercecore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
public class Categorie implements Serializable {

    private static final long serialVersionUID = -992248230930241426L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categorieId;

    @NotEmpty(message = "Can not be null")
    private String nomCategoriePrincipale;

    @NotEmpty(message = "Can not be null")
    private String nomSousCategorie;

    @OneToMany(mappedBy = "produitCategorie")
    @JsonIgnore
    private List<Produit> produitList;

    public Long getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }

    public String getNomCategoriePrincipale() {
        return nomCategoriePrincipale;
    }

    public void setNomCategoriePrincipale(String nomCategoriePrincipale) {
        this.nomCategoriePrincipale = nomCategoriePrincipale;
    }

    public String getNomSousCategorie() {
        return nomSousCategorie;
    }

    public void setNomSousCategorie(String nomSousCategorie) {
        this.nomSousCategorie = nomSousCategorie;
    }

    public List<Produit> getProduitList() {
        return produitList;
    }

    public void setProduitList(List<Produit> produitList) {
        this.produitList = produitList;
    }
}
