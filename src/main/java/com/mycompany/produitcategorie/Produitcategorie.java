/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.produitcategorie;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author TR7
 */
public class Produitcategorie {

    public static void main(String[] args) {
        Categorie c = new Categorie();
       Document cat = new Document();
      
       List prods = new ArrayList();
       Document produit1 = new Document();
       Document produit2 = new Document();
       Document produit3 = new Document();
       produit2.append("ref", "prod11").append("libelle", "radio").append("quantite", 11);
       produit1.append("ref", "prod12").append("libelle", "pc").append("quantite", 20);
       produit3.append("ref", "prod3").append("libelle", "phone").append("quantite", 105);
       prods.add(produit1);
       prods.add(produit2);
       prods.add(produit3);
       cat.append("code", "categ5").append("libelle", "categorie5").append("produits",prods);
       c.insert(cat);
    }
}
