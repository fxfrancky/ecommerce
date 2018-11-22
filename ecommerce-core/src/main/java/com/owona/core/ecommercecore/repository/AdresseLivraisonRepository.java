package com.owona.core.ecommercecore.repository;


import com.owona.core.ecommercecore.model.AdresseLivraison;
import com.owona.core.ecommercecore.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdresseLivraisonRepository extends CrudRepository<AdresseLivraison,Long> {

    List<AdresseLivraison> findAllByClient(Client client);
}
