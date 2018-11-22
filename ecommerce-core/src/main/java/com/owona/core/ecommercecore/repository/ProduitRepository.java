package com.owona.core.ecommercecore.repository;

import com.owona.core.ecommercecore.model.Categorie;
import com.owona.core.ecommercecore.model.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProduitRepository extends CrudRepository<Produit, Long>, PagingAndSortingRepository<Produit, Long> {


    List<Produit> findAllByProduitCategorie(Categorie categorie);
}
