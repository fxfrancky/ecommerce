package com.owona.core.ecommercecore.repository;

import com.owona.core.ecommercecore.model.Client;
import com.owona.core.ecommercecore.model.Code;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CodeRepository extends CrudRepository<Code , Long> {

    List<Code> findByCodeTypeAndClient(int codeType, Client client);

    Code findByCodeStr(String codeStr);
}
