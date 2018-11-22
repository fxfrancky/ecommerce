package com.owona.core.ecommercecore.service.impl;

import com.owona.core.ecommercecore.model.Client;
import com.owona.core.ecommercecore.model.Code;
import com.owona.core.ecommercecore.repository.CodeRepository;
import com.owona.core.ecommercecore.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    private CodeRepository codeRepository;

    public List<Code> findByCodeTypeAndClient(int codeType, Client client) {
        return codeRepository.findByCodeTypeAndClient(codeType, client);
    }

    public void save(Code code) {

        SecureRandom random = new SecureRandom();
        String codeStr = new BigInteger(130, random).toString(32);
        code.setCodeStr(codeStr);
        codeRepository.save(code);
    }

    public Code findByCodeStr(String codeStr) {
        return codeRepository.findByCodeStr(codeStr);
    }

    public void delete(Code code) {
        codeRepository.delete(code);

    }
}
