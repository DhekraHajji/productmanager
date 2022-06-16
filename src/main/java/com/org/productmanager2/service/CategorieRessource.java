package com.org.productmanager2.service;
//import java.lang.*;
//import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.org.productmanager2.model.Categorie;
import com.org.productmanager2.service.CategorieService;

import java.io.FileNotFoundException;
import java.util.List;
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@CrossOrigin(origins = "*")
@RequestMapping ("/categorie")



//@CrossOrigin(origins = "http://localhost:4200")
public class CategorieRessource {
    private final CategorieService categorieService;
    public CategorieRessource(CategorieService categorieService) {
        this.categorieService= categorieService;
    }

    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")

    public ResponseEntity <List<Categorie>> getAllCategories (){
        List<Categorie> categories = categorieService.findAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

 /*@GetMapping("/find/{id}")
    public ResponseEntity <Categorie> getCategorieById (@PathVariable("id") Long id){
        Categorie categorie = categorieService.findCategorieById(id);
        return new ResponseEntity<>(categorie, HttpStatus.OK);
    }*/


    @PostMapping ("/add")
    public ResponseEntity <Categorie> addCategorie (@RequestBody Categorie categorie){
        Categorie newCategorie = categorieService.addCategorie(categorie);
        return new ResponseEntity<>(newCategorie, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity <Categorie> updateCategorie (@PathVariable("id") Long id,@RequestBody Categorie categorie){
        Categorie updateCategorie = categorieService.updateCategorie(id,categorie);
        return new ResponseEntity<>(updateCategorie, HttpStatus.CREATED);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity <?> deleteCategorie (@PathVariable("id") Long id){
        categorieService.deleteCategorie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

   /* @GetMapping("/{format}")
    public String generateReport (@PathVariable String format)throws FileNotFoundException, JRException{
        return categorieService.exportReport(format);
    }*/

    @Autowired


    @GetMapping("/report")
    public String empReport() {
        return categorieService.generateReport();
    }
}
