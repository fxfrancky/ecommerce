package com.owona.core.ecommercecore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ProduitCommentaire implements Serializable {

    private static final long serialVersionUID = -992248230930241426L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentaireId;

    //@Column(columnDefinition = "TEXT")
    private String commentaireContents;

    private int commentaireStarts;

    @ManyToOne
    @JoinColumn(name = "produitId")
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    //@Column(columnDefinition="DATETIME")
    private Date commentaireDate;

    public Long getCommentaireId() {
        return commentaireId;
    }

    public void setCommentaireId(Long commentaireId) {
        this.commentaireId = commentaireId;
    }

    public String getCommentaireContents() {
        return commentaireContents;
    }

    public void setCommentaireContents(String commentaireContents) {
        this.commentaireContents = commentaireContents;
    }

    public int getCommentaireStarts() {
        return commentaireStarts;
    }

    public void setCommentaireStarts(int commentaireStarts) {
        this.commentaireStarts = commentaireStarts;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getCommentaireDate() {
        return commentaireDate;
    }

    public void setCommentaireDate(Date commentaireDate) {
        this.commentaireDate = commentaireDate;
    }
}
