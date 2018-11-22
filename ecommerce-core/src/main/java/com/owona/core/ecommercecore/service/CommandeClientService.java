package com.owona.core.ecommercecore.service;

import com.owona.core.ecommercecore.model.Client;
import com.owona.core.ecommercecore.model.CommandeClient;
import com.owona.core.ecommercecore.model.CommandeClientAdresseLivraison;
import com.owona.core.ecommercecore.model.Panier;

import java.io.IOException;
import java.util.List;

public interface CommandeClientService {

    double getCommandeClientGrandTotalByPanier(Panier panier);

    void addCommandeDumpPanier(CommandeClientAdresseLivraison commandeClientAdresseLivraison, CommandeClient commandeClient, Panier panier) throws IOException;

    List<CommandeClient> getAllCommandeClientByClient(Client client);


}
