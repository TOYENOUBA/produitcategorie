/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.produitcategorie;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.ErrorCategory;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.*;
import com.mongodb.client.MongoCursor;

/**
 *
 * @author TR7
 */
public class Categorie {
    private MongoDatabase db;
    private MongoClient client;

    public Categorie() {
        connexion();
    }
    
    
    public void connexion(){
        try {
            // 
            System.out.println("Hello World!");
            // Connect to MongoDB Server on localhost, port 27017 (default)
            client = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
                // Connect to Database "cartoon"
            db = client.getDatabase("magasin");
                System.out.println("Successful database connection established. \n");

        } catch (Exception exception) {
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
        }
    }
    
    public void insert(Document categ) {
        MongoCollection collection = db.getCollection("categorie");
        Produit pro = new Produit();
        
        try {
            //verification, si la nouvelle categorie avec des produits
            if(categ.containsKey("produits")){
                //on recupere la liste de tout les produits de la collection produit
                MongoCursor mc = pro.getAll();
                //on recupere tout les produit du champ produit de la nouvelle categorie qu'on veut inserer
                ArrayList p=(ArrayList)categ.get("produits");
                
                for (int i = 0; i < p.size(); i++) {
                    Document j = (Document) p.get(i);
                    while (mc.hasNext()) {
                        Document k = (Document) mc.next();
                        //on verifie si les produit existe deja dans la base de donnees. si oui on ajoute un champs categorie au produit exitant
                        // si non on insert de nouveau produit dans la base de donnes avec la categorie correspondante
                        if (j.get("ref").equals(k.get("ref"))) {
                            Document upd=k;
                            upd.append("categorie", new Document().append("code", categ.get("code")).append("libelle", categ.get("code")));
                            pro.updateCat(k);
                        } else{
                            Document newProd =j;
                            newProd.append("categorie", new Document().append("code", categ.get("code")).append("libelle", categ.get("code")));
                            pro.add(newProd);
                        }
                        
                    }
      
                }
            }
           
            collection.insertOne(categ);
            System.out.println("cat ajouter \n");
        } catch (MongoWriteException mwe) {
            if (mwe.getError().getCategory().equals(ErrorCategory.DUPLICATE_KEY)) {
                System.out.println("le document existe deja");
            }
        }
    }
    
    public void update(){
        MongoCollection collection = db.getCollection("categorie");
        
        Document up = (Document)collection.find(Filters.eq("code", "cat")).first();
        System.out.println(up.toJson());
        collection.updateOne(new Document("code","cat"),new Document("$set", new Document("libelle","produit public") ) );
        System.out.println("\nModifier categorie:");
        Document dilbert = (Document)collection.find(Filters.eq("code", "cat")).first();
        System.out.println(dilbert.toJson());
    }
    
    public void delete(){
            System.out.println("\nDelete documents with an id greater than or equal to 4.");
            MongoCollection collection = db.getCollection("categorie");
            collection.deleteOne(Filters.gte("code","cat"));
            System.out.println("del done");
    }
    
}
