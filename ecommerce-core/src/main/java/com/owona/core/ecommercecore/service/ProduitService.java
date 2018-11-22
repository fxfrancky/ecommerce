package com.owona.core.ecommercecore.service;

import com.owona.core.ecommercecore.model.Categorie;
import com.owona.core.ecommercecore.model.Produit;

import java.util.List;

public interface ProduitService {

    void getVisited(Long productId);

    List<Produit> getProduitsByNomCategoriePrincipale(String NomCategoriePrincipale);

    List<Produit> getProduitsByCategorie(Categorie categorie);

    List<Produit> getAllProduits();

    Produit getProduitById(Long productId);

    void save(Produit produit);

    void delete(Long produitId);

    List<Produit> sort(List<Produit> produits, String sortType);
}
