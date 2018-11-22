package com.owona.core.ecommercecore.service.impl;

import com.owona.core.ecommercecore.model.Client;
import com.owona.core.ecommercecore.model.Role;
import com.owona.core.ecommercecore.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("utilisateurDetailsService")
public class UtilisateurDetailsService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(email);
        if(client == null){
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(client.getEmail(), client.getPassword(),
                client.isEnabled(), true, true, true, getGrantedAuthorities(client));
    }


    private List<GrantedAuthority> getGrantedAuthorities(Client client){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Role role : client.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        return authorities;
    }
}
