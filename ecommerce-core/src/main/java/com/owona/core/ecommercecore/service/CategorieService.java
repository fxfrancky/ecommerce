package com.owona.core.ecommercecore.service;

import com.owona.core.ecommercecore.model.Categorie;

import java.util.List;

public interface CategorieService {

    List<Categorie> getAllCategories();

    List<String> getAllnomCategoriePrincipale();

    List<String> getAllSousCategories();

    void save(Categorie categorie);

    void delete(Long categorieId);

    Categorie getCategorieById(Long categorieId);
}
