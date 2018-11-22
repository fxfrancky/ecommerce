package com.owona.core.ecommercecore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class CommandeClient implements Serializable {
    @Id
    @GeneratedValue
    private Long commandeClientId;

    private double CommandePrixTotal;

    //@Column(columnDefinition="DATETIME")
    private Date CommandeDate;

    @OneToOne
    @JoinColumn(name = "addresseLivraisonId")
    @JsonIgnore
    private CommandeClientAdresseLivraison commandeClientAdresseLivraison;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    @OneToMany(mappedBy = "commandeClient", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CommandeClientArticle> commandeClientArticle;

    public Long getCommandeClientId() {
        return commandeClientId;
    }

    public void setCommandeClientId(Long commandeClientId) {
        this.commandeClientId = commandeClientId;
    }

    public double getCommandePrixTotal() {
        return CommandePrixTotal;
    }

    public void setCommandePrixTotal(double commandePrixTotal) {
        CommandePrixTotal = commandePrixTotal;
    }

    public Date getCommandeDate() {
        return CommandeDate;
    }

    public void setCommandeDate(Date commandeDate) {
        CommandeDate = commandeDate;
    }

    public CommandeClientAdresseLivraison getCommandeClientAdresseLivraison() {
        return commandeClientAdresseLivraison;
    }

    public void setCommandeClientAdresseLivraison(CommandeClientAdresseLivraison commandeClientAdresseLivraison) {
        this.commandeClientAdresseLivraison = commandeClientAdresseLivraison;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<CommandeClientArticle> getCommandeClientArticle() {
        return commandeClientArticle;
    }

    public void setCommandeClientArticle(List<CommandeClientArticle> commandeClientArticle) {
        this.commandeClientArticle = commandeClientArticle;
    }
}
