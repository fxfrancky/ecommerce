package com.owona.core.ecommercecore.service.impl;

import com.owona.core.ecommercecore.model.Categorie;
import com.owona.core.ecommercecore.repository.CategorieRepository;
import com.owona.core.ecommercecore.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public List<String> getAllSousCategories(){
        return categorieRepository.findAllNomSousCategorie();
    }

    public List<String> getAllnomCategoriePrincipale(){
        return categorieRepository.findAllNomCategoriePrincipale();
    }

    public List<Categorie> getAllCategories(){
        return (List<Categorie>) categorieRepository.findAll();
    }

    public void save(Categorie categorie){
        categorieRepository.save(categorie);
    }

    public void delete(Long categorieId){
        categorieRepository.deleteById(categorieId);
    }

    public Categorie getCategorieById(Long categoryId){
        return categorieRepository.findById(categoryId).get();
    }
}