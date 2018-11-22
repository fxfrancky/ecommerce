package com.owona.core.ecommercecore.service;

import com.owona.core.ecommercecore.model.Client;
import com.owona.core.ecommercecore.model.Code;

import java.util.List;

public interface CodeService {

    List<Code> findByCodeTypeAndClient(int codeType, Client client);

    void save(Code code);

    Code findByCodeStr(String codeStr);

    void delete(Code code);
}
