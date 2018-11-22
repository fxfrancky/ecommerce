package com.owona.core.ecommercecore.service.impl;

import com.owona.core.ecommercecore.model.*;
import com.owona.core.ecommercecore.repository.*;
import com.owona.core.ecommercecore.service.CommandeClientService;
import com.owona.core.ecommercecore.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class CommandeClientServiceImpl implements CommandeClientService {


    @Autowired
    private PanierService panierService;
    @Autowired
    private CommandeClientRepository commandeClientRepository;
    @Autowired
    private CommandeClientAdresseLivraisonRepository commandeClientAdresseLivraisonRepository;
    @Autowired
    private AdresseLivraisonRepository adresseLivraisonRepository;
    @Autowired
    private CommandeClientArticleRepository commandeClientArticleRepository;
    @Autowired
    private PanierArticleRepository panierArticleRepository;

    public double getCommandeClientGrandTotalByPanier(Panier panier) {
        double grandTotal = 0;
        List<PanierArticle> panierArticles = panier.getPanierArticles();

        for (PanierArticle panierArticle : panierArticles) {
            grandTotal += panierArticle.getTotalPriceDouble();
        }

        return grandTotal;
    }

    public void addCommandeDumpPanier(CommandeClientAdresseLivraison commandeClientAdresseLivraison, CommandeClient commandeClient, Panier panier) throws IOException {
        if(commandeClientAdresseLivraison == null || commandeClient == null || panier == null){
            throw new IOException();
        }
        // initiate customerOrderShippingAddress
        AdresseLivraison adresseLivraison = adresseLivraisonRepository.findById(commandeClientAdresseLivraison.getAddresseLivraisOnoriginale()).get();
        commandeClientAdresseLivraison.setAddresse(adresseLivraison.getAddresse());
        commandeClientAdresseLivraison.setVille(adresseLivraison.getVille());
        commandeClientAdresseLivraison.setPays(adresseLivraison.getPays());
        commandeClientAdresseLivraison.setNomComplet(adresseLivraison.getNomComplet());
        commandeClientAdresseLivraison.setNumTelephone(adresseLivraison.getNumeroTelephone());
        commandeClientAdresseLivraison.setDepartement(adresseLivraison.getDepartement());
        commandeClientAdresseLivraison.setCodePostal(adresseLivraison.getCodePostal());

        // initiate customer order
        commandeClient.setClient(panier.getClient());
        commandeClient.setCommandeDate(new Date());
        commandeClient.setCommandePrixTotal(panier.getGrandTotal());
        // for mapping orderItem table
        commandeClientRepository.save(commandeClient);
        panier.setGrandTotal(0);
        panierService.save(panier);
        // dump cartItem to orderItem, empty cart
        for(PanierArticle panierArticle : panier.getPanierArticles()){
            CommandeClientArticle commandeClientArticle = new CommandeClientArticle();
            commandeClientArticle.setCommandeClient(commandeClient);
            commandeClientArticle.setProduitId(panierArticle.getProduit().getProduitId());
            commandeClientArticle.setProduitNom(panierArticle.getProduit().getProduitNom());
            commandeClientArticle.setProduitPrix(panierArticle.getProduit().getProduitPrix());
            commandeClientArticle.setProduitQuantity(panierArticle.getQuantity());
            commandeClientArticleRepository.save(commandeClientArticle);
            panierArticleRepository.delete(panierArticle);
        }
        // for mapping customerOrder table
        commandeClientAdresseLivraisonRepository.save(commandeClientAdresseLivraison);

        commandeClient.setCommandeClientAdresseLivraison(commandeClientAdresseLivraison);
        commandeClientRepository.save(commandeClient);

        commandeClientAdresseLivraison.setCommandeClient(commandeClient);
        commandeClientAdresseLivraisonRepository.save(commandeClientAdresseLivraison);
    }

    public List<CommandeClient> getAllCommandeClientByClient(Client client) {
        return commandeClientRepository.findAllByClient(client);
    }
}
