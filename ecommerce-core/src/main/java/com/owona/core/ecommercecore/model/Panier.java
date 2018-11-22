package com.owona.core.ecommercecore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Panier implements Serializable {

    private static final long serialVersionUID = -992248230930241426L;

    @Id
    @GeneratedValue
    private Long panierId;

    @OneToMany(mappedBy = "panier", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<PanierArticle> panierArticles;

    @OneToOne
    @JoinColumn(name = "clientId")
    @JsonIgnore
    private Client client;

    private double grandTotal;

    public Long getPanierId() {
        return panierId;
    }

    public void setPanierId(Long panierId) {
        this.panierId = panierId;
    }

    public List<PanierArticle> getPanierArticles() {
        return panierArticles;
    }

    public void setPanierArticles(List<PanierArticle> panierArticles) {
        this.panierArticles = panierArticles;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
}