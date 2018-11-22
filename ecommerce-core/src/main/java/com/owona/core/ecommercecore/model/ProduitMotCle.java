package com.owona.core.ecommercecore.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class ProduitMotCle implements Serializable {

    private static final long serialVersionUID = -992248230930241426L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long motCleId;

    @NotEmpty(message = "Can not be null")
    private String motCleContents;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Produit produit;

    public Long getMotCleId() {
        return motCleId;
    }

    public void setMotCleId(Long motCleId) {
        this.motCleId = motCleId;
    }

    public String getMotCleContents() {
        return motCleContents;
    }

    public void setMotCleContents(String motCleContents) {
        this.motCleContents = motCleContents;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}

