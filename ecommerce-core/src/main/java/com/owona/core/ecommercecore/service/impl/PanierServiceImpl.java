package com.owona.core.ecommercecore.service.impl;

import com.owona.core.ecommercecore.model.Panier;
import com.owona.core.ecommercecore.model.PanierArticle;
import com.owona.core.ecommercecore.repository.PanierArticleRepository;
import com.owona.core.ecommercecore.repository.PanierRepository;
import com.owona.core.ecommercecore.service.CommandeClientService;
import com.owona.core.ecommercecore.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

@Service
public class PanierServiceImpl implements PanierService {

    @Autowired
    private PanierRepository panierRepository;
    @Autowired
    private CommandeClientService commandeClientService;
    @Autowired
    private PanierArticleRepository panierArticleRepository;

    public Panier getPanierByPanierId(Long panierId){
        return panierRepository.findById(panierId).get();
       // return panierRepository.findOne(panierId);
    }

    public void update(Panier panier){
        double grandTotal = commandeClientService.getCommandeClientGrandTotalByPanier(panier);
        Double truncatedDouble = new BigDecimal(grandTotal)
                .setScale(3, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        panier.setGrandTotal(truncatedDouble);

        panierRepository.save(panier);
    }

    public Panier validate(Object panierId) throws IOException {
        if(panierId == null){
            throw new IOException("Please Login.");
        }

        Panier panier = panierRepository.findById((Long) panierId).get();
        if(panier == null || panier.getPanierArticles().size() == 0){
            throw new IOException("cart null or cartItem size == 0.c");
        }
        update(panier);
        return panier;
    }

    public void emptyCart(Panier panier){
        for(PanierArticle panierArticle : panier.getPanierArticles()){
            panierArticleRepository.delete(panierArticle);
        }
        panier.setGrandTotal(0);
        panierRepository.save(panier);
    }

    public void save(Panier panier){
        panierRepository.save(panier);
    }
}
