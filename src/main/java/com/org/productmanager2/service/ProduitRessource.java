package com.org.productmanager2.service;


//import java.lang.*;
//import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.org.productmanager2.model.Produit;
import com.org.productmanager2.service.ProduitService;

import java.io.FileNotFoundException;
import java.util.List;
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@CrossOrigin(origins = "*")
@RequestMapping ("/produit")



//@CrossOrigin(origins = "http://localhost:4200")
public class ProduitRessource {
    private final ProduitService produitService;
    public ProduitRessource (ProduitService produitService) {
        this.produitService = produitService;
    }

    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")

    public ResponseEntity <List<Produit>> getAllProduits (){
        List<Produit> produits = produitService.findAllProduits();
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }

 /*@GetMapping("/find/{id}")
    public ResponseEntity <Categorie> getCategorieById (@PathVariable("id") Long id){
        Categorie categorie = categorieService.findCategorieById(id);
        return new ResponseEntity<>(categorie, HttpStatus.OK);
    }*/


    @PostMapping ("/add")
    public ResponseEntity <Produit> addProduit (@RequestBody Produit produit){
        Produit newProduit = produitService.addProduit(produit);
        return new ResponseEntity<>(newProduit, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity <Produit> updateProduit (@PathVariable("id") Long id,@RequestBody Produit produit){
        Produit updateProduit= produitService.updateProduit(id,produit);
        return new ResponseEntity<>(updateProduit, HttpStatus.CREATED);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity <?> deleteProduit (@PathVariable("id") Long id){
        produitService.deleteProduit(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

   /* @GetMapping("/{format}")
    public String generateReport (@PathVariable String format)throws FileNotFoundException, JRException{
        return categorieService.exportReport(format);
    }*/
}


