package com.org.productmanager2.Repo;

import com.org.productmanager2.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaotegorieRepo extends JpaRepository<Categorie,Long> {
    // Optional <Categorie> findAllCategories();
    //  Optional findCategorieById (Long id);
    // void deleteCategorieById (Long id);

}