package com.owona.core.ecommercecore.service.impl;

import com.owona.core.ecommercecore.model.AdresseLivraison;
import com.owona.core.ecommercecore.model.Client;
import com.owona.core.ecommercecore.repository.AdresseLivraisonRepository;
import com.owona.core.ecommercecore.service.ClientAdresseService;
import com.owona.core.ecommercecore.service.ClientService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientAdresseServiceImpl implements ClientAdresseService {

    @Autowired
    private AdresseLivraisonRepository adresseLivraisonRepository;

    @Autowired
    private ClientService clientService;


    public List<AdresseLivraison> getAllAdresseLivraisonByClientId(Object clientId) {
        Client client = clientService.findOne((Long) clientId);
        return adresseLivraisonRepository.findAllByClient(client);
    }

    @Transactional
    public void addAdresseLivraison(Object clientId, AdresseLivraison adresseLivraison) {

        Client client = clientService.findOne((Long)clientId);
        // if there is no default shipping address, then set it up
        adresseLivraison.setDefault(true);
        Hibernate.initialize(client.getAdresseLivraisonList());
        for(AdresseLivraison adresseLivraison_ : client.getAdresseLivraisonList()){
            if(adresseLivraison_.isDefault()){
                adresseLivraison_.setDefault(false);
                break;
            }
        }
        adresseLivraison.setClient(client);
        adresseLivraisonRepository.save(adresseLivraison);
    }
}
