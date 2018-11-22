package com.owona.core.ecommercecore.repository;

import com.owona.core.ecommercecore.model.Client;
import com.owona.core.ecommercecore.model.CommandeClient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommandeClientRepository extends CrudRepository<CommandeClient , Long> {

    List<CommandeClient> findAllByClient(Client client);
}

