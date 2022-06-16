package com.org.productmanager2.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.web.bind.annotation.CrossOrigin;
import com.org.productmanager2.model.Produit;

import java.util.Optional;
//@CrossOrigin (origins = "http://localhost:4200")
public interface ProduitRepo extends JpaRepository<Produit,Long> {
    // Optional <Categorie> findAllCategories();
    //  Optional findCategorieById (Long id);
    void deleteCategorieById (Long id);

}
