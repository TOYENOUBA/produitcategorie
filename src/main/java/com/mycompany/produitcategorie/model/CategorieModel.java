/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.produitcategorie.model;

import java.util.ArrayList;

/**
 *
 * @author TR7
 */
public class CategorieModel {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public ArrayList<ProduitModel> getProduits() {
        return produits;
    }

    public void setProduits(ArrayList<ProduitModel> produits) {
        this.produits = produits;
    }
    private String libelle;
    private ArrayList<ProduitModel> produits;
}
