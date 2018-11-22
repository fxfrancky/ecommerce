package com.owona.core.ecommercecore.service.impl;

import com.owona.core.ecommercecore.model.Categorie;
import com.owona.core.ecommercecore.model.Produit;
import com.owona.core.ecommercecore.repository.CategorieRepository;
import com.owona.core.ecommercecore.repository.ProduitRepository;
import com.owona.core.ecommercecore.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CategorieRepository categorieRepository;

    public void getVisited(Long productId) {
        Produit produit = produitRepository.findById(productId).get();
        produit.setProduitVues(produit.getProduitVues()+1);
        produitRepository.save(produit);
    }

    public List<Produit> getProduitsByNomCategoriePrincipale(String nomCategoriePrincipale) {
        List<Categorie> categorieList = categorieRepository.findAllByNomCategoriePrincipale(nomCategoriePrincipale);
        List<Produit> products = new ArrayList<Produit>();
        for(Categorie categorie: categorieList){
            for(Produit product : categorie.getProduitList()){
                products.add(product);
            }
        }
        return products;
    }

    public List<Produit> getProduitsByCategorie(Categorie categorie) {
        return produitRepository.findAllByProduitCategorie(categorie);
    }

    public List<Produit> getAllProduits() {
        return (List<Produit>) produitRepository.findAll();
    }

    public Produit getProduitById(Long productId) {
        return produitRepository.findById(productId).get();
    }

    public void save(Produit produit) {
        produitRepository.save(produit);
    }

    public void delete(Long produitId) {
        produitRepository.deleteById(produitId);
    }

    public List<Produit> sort(List<Produit> produits, String sortType) {
        // 0: Price ASC, 1: Price DESC
        if(sortType.equals("0")){
            Collections.sort(produits, Produit.Comparators.PRICE);
        }
        if(sortType.equals("1")){
            Collections.sort(produits, Produit.Comparators.PRICE);
            Collections.reverse(produits);
        }
        return produits;
    }
}
