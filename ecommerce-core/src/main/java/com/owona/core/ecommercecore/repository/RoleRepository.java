package com.owona.core.ecommercecore.repository;

import com.owona.core.ecommercecore.model.Client;
import com.owona.core.ecommercecore.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByAuthorityAndClient(String auth, Client client);
}
