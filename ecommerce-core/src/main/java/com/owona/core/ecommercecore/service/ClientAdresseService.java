package com.owona.core.ecommercecore.service;

import com.owona.core.ecommercecore.model.AdresseLivraison;

import java.util.List;

public interface ClientAdresseService {

    List<AdresseLivraison> getAllAdresseLivraisonByClientId(Object clientId);

    void addAdresseLivraison(Object clientId, AdresseLivraison adresseLivraison);
}
