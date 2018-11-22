package com.owona.core.ecommercecore.repository;

import com.owona.core.ecommercecore.model.Categorie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategorieRepository extends CrudRepository<Categorie , Long> {

    List<Categorie> findAllByNomCategoriePrincipale(String NomCategoriePrincipale);

    List<Categorie> findAllByNomSousCategorie(String SousCategorie);

    @Query(value = "SELECT DISTINCT nom_sous_categorie from categorie" , nativeQuery = true)
    List<String> findAllNomSousCategorie();

    @Query(value = "SELECT DISTINCT nom_categorie_principale from category" , nativeQuery = true)
    List<String> findAllNomCategoriePrincipale();


}
