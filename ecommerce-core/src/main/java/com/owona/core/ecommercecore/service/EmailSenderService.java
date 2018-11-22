package com.owona.core.ecommercecore.service;

import com.owona.core.ecommercecore.model.Client;

public interface EmailSenderService {

    void sendActiveCode(Client client);

    void sendResetPasswordCode(Client client);
}
