package com.owona.core.ecommercecore.repository;

import com.owona.core.ecommercecore.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {

    Client findByEmail(String email);
}
