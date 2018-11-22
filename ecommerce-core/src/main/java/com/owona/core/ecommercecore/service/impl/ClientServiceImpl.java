package com.owona.core.ecommercecore.service.impl;

import com.owona.core.ecommercecore.model.Client;
import com.owona.core.ecommercecore.model.Code;
import com.owona.core.ecommercecore.model.Panier;
import com.owona.core.ecommercecore.model.Role;
import com.owona.core.ecommercecore.repository.ClientRepository;
import com.owona.core.ecommercecore.repository.PanierRepository;
import com.owona.core.ecommercecore.repository.RoleRepository;
import com.owona.core.ecommercecore.service.ClientService;
import com.owona.core.ecommercecore.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PanierRepository panierRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CodeService codeService;

    public Client findOne(Long clientId) {
        return null;
    }

    @Transactional
    public void save(Client client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        // save or update
        if(client.getClientId() == null){
            Panier panier = new Panier();
            Role role = new Role();
            role.setEmail(client.getEmail());
            role.setAuthority("ROLE_UNAUTH");
            role.setClient(client);
            // create customer first
            clientRepository.save(client);
            // save cart
            panier.setClient(client);
            panierRepository.save(panier);
            // update cartId in Customer
            client.setPanier(panier);
            client.setEnabled(true);
            clientRepository.save(client);
            // save role
            roleRepository.save(role);
            // generate active code
            Code code = new Code();
            code.setCodeDate(new Date());
            code.setCodeType(0);
            code.setClient(client);

            codeService.save(code);
        }else{
            clientRepository.save(client);
        }
    }

    public void activeAccount(String codeStr) {
        Code code = codeService.findByCodeStr(codeStr);
        if(code != null){
            Client client = code.getClient();
            Role role = new Role();
            role.setAuthority("ROLE_USER");
            role.setClient(client);
            role.setEmail(client.getEmail());
            roleRepository.save(role);
            // delete role UNAUTH
            roleRepository.delete(roleRepository.findByAuthorityAndClient("ROLE_UNAUTH", client));
            // delete active code
            codeService.delete(code);
        }
    }

    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    public boolean hasRole(String role, Client client) {
        return (roleRepository.findByAuthorityAndClient(role, client) != null);
    }

    public List<Client> getAllClient() {
        return (List<Client>) clientRepository.findAll();
    }

    public void delete(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}
