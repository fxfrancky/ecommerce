package com.owona.core.ecommercecore.service;

import com.owona.core.ecommercecore.model.Client;

import java.util.List;

public interface ClientService {

    Client findOne(Long clientId);

    void save(Client client);

    void activeAccount(String codeStr);

    Client findByEmail(String email);

    boolean hasRole(String role, Client client);

    List<Client> getAllClient();

    void delete(Long clientId);
}
