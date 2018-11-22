package com.owona.core.ecommercecore.repository;

import com.owona.core.ecommercecore.model.Produit;
import com.owona.core.ecommercecore.model.ProduitCommentaire;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProduitCommentaireRepository extends CrudRepository<ProduitCommentaire, Long> {

    List<ProduitCommentaire> findByProduit(Produit produit);
}

