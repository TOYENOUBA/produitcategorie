/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.produitcategorie.model;

/**
 *
 * @author TR7
 */
public class ProduitModel {
     private String ref;
    private String libelle;
    private int quantite;
    private CategorieModel categorie;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public CategorieModel getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieModel categorie) {
        this.categorie = categorie;
    }
    
    
    
}
