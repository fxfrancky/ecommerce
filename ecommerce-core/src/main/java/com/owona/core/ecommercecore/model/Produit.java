package com.owona.core.ecommercecore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Entity
public class Produit implements Serializable , Comparable<Produit>{

    private static final long serialVersionUID = -992248230930241426L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long produitId;

    @NotEmpty(message = "The name must not be null")
    @Length(max = 255, message = "The field must be less than 255 characters")
    private String produitNom;

    @Length(max = 255, message = "The field must be less than 255 characters")
    private String produitSummary;

    @Length(max = 255, message = "The field must be less than 255 characters")
    private String produitFabricant;

    @Column(columnDefinition = "TEXT")
    private String productDescription;

    //@Column(columnDefinition="DATETIME")
    private Date productDate;

    @Column(name = "produitVues", nullable = false)
    private long produitVues = 0;

    @Min(value = 0, message = "Product price must no be less then zero.")
    private double produitPrix;

    @NotEmpty(message = "Condition must not be null")
    private String produitCondition;

    @Min(value = 0, message = "Product unit must no be less then zero.")
    private int unitInStock;

    @Transient
    private MultipartFile productImage;

    @OneToMany(mappedBy = "produit")
    @JsonIgnore
    private List<PanierArticle> panierArticleList;

    @OneToMany(mappedBy = "produit")
    @JsonIgnore
    private List<ProduitCommentaire> ProduitCommentaireList;

    @ManyToOne
    @JoinColumn(name = "categorieId")
    private Categorie produitCategorie;

    @OneToMany(mappedBy = "produit")
    @JsonIgnore
    private List<ProduitMotCle> produitMotCles;

    /******************* Comparator ************************/
    public int compareTo(Produit produit){
        return new Double(this.getProduitPrix()).compareTo(produit.getProduitPrix());
    }

    public static class Comparators {
        public static Comparator<Produit> PRICE = new Comparator<Produit>(){
            public int compare(Produit p1, Produit p2){
                return new Double(p1.getProduitPrix()).compareTo(p2.getProduitPrix());
            }
        };
        public static Comparator<Produit> VIEWS = new Comparator<Produit>(){
            public int compare(Produit p1, Produit p2){
                return new Long(p1.getProduitVues()).compareTo(p2.getProduitVues());
            }
        };
        public static Comparator<Produit> DATE = new Comparator<Produit>(){
            public int compare(Produit p1, Produit p2){
                return (p1.getProductDate().after(p2.getProductDate())) ? 0:1;
            }
        };
    }


    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }

    public String getProduitNom() {
        return produitNom;
    }

    public void setProduitNom(String produitNom) {
        this.produitNom = produitNom;
    }

    public String getProduitSummary() {
        return produitSummary;
    }

    public void setProduitSummary(String produitSummary) {
        this.produitSummary = produitSummary;
    }

    public String getProduitFabricant() {
        return produitFabricant;
    }

    public void setProduitFabricant(String produitFabricant) {
        this.produitFabricant = produitFabricant;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public long getProduitVues() {
        return produitVues;
    }

    public void setProduitVues(long produitVues) {
        this.produitVues = produitVues;
    }

    public double getProduitPrix() {
        return produitPrix;
    }

    public void setProduitPrix(double produitPrix) {
        this.produitPrix = produitPrix;
    }

    public String getProduitCondition() {
        return produitCondition;
    }

    public void setProduitCondition(String produitCondition) {
        this.produitCondition = produitCondition;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public List<PanierArticle> getPanierArticleList() {
        return panierArticleList;
    }

    public void setPanierArticleList(List<PanierArticle> panierArticleList) {
        this.panierArticleList = panierArticleList;
    }

    public List<ProduitCommentaire> getProduitCommentaireList() {
        return ProduitCommentaireList;
    }

    public void setProduitCommentaireList(List<ProduitCommentaire> produitCommentaireList) {
        ProduitCommentaireList = produitCommentaireList;
    }

    public Categorie getProduitCategorie() {
        return produitCategorie;
    }

    public void setProduitCategorie(Categorie produitCategorie) {
        this.produitCategorie = produitCategorie;
    }

    public List<ProduitMotCle> getProduitMotCles() {
        return produitMotCles;
    }

    public void setProduitMotCles(List<ProduitMotCle> produitMotCles) {
        this.produitMotCles = produitMotCles;
    }
}
