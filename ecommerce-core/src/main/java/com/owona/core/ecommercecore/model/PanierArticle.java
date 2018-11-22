package com.owona.core.ecommercecore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PanierArticle implements Serializable {

    private static final long serialVersionUID = -6050058936968302003L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long panierArticleId;

    @ManyToOne
    @JoinColumn(name = "panierId")
    @JsonIgnore
    private Panier panier;

    @ManyToOne
    @JoinColumn(name = "produitId")
    private Produit produit;

    private double totalPriceDouble;

    private int quantity;

    public Long getPanierArticleId() {
        return panierArticleId;
    }

    public void setPanierArticleId(Long panierArticleId) {
        this.panierArticleId = panierArticleId;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public double getTotalPriceDouble() {
        return totalPriceDouble;
    }

    public void setTotalPriceDouble(double totalPriceDouble) {
        this.totalPriceDouble = totalPriceDouble;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
