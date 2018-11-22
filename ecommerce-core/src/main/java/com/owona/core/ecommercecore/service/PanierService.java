package com.owona.core.ecommercecore.service;

import com.owona.core.ecommercecore.model.Panier;

import java.io.IOException;

public interface PanierService {

    Panier validate(Object clientId) throws IOException;

    void emptyCart(Panier panier);

    void save(Panier panier);
}
