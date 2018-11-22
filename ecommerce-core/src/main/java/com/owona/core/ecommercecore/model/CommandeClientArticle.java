package com.owona.core.ecommercecore.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CommandeClientArticle implements Serializable {

    private static final long serialVersionUID = 8892553931694642183L;

    @Id
    @GeneratedValue
    private Long CommandeClientArticleId;

    private Long produitId;
    private int produitQuantity;
    private double produitPrix;
    private String produitNom;

    @ManyToOne
    @JoinColumn(name = "commandeClientId")
    private CommandeClient commandeClient;

    public Long getCommandeClientArticleId() {
        return CommandeClientArticleId;
    }

    public void setCommandeClientArticleId(Long commandeClientArticleId) {
        CommandeClientArticleId = commandeClientArticleId;
    }

    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }

    public int getProduitQuantity() {
        return produitQuantity;
    }

    public void setProduitQuantity(int produitQuantity) {
        this.produitQuantity = produitQuantity;
    }

    public double getProduitPrix() {
        return produitPrix;
    }

    public void setProduitPrix(double produitPrix) {
        this.produitPrix = produitPrix;
    }

    public String getProduitNom() {
        return produitNom;
    }

    public void setProduitNom(String produitNom) {
        this.produitNom = produitNom;
    }

    public CommandeClient getCommandeClient() {
        return commandeClient;
    }

    public void setCommandeClient(CommandeClient commandeClient) {
        this.commandeClient = commandeClient;
    }
}
