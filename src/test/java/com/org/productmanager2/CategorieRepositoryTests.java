package com.org.productmanager2;

import com.org.productmanager2.Repo.CaotegorieRepo;
import com.org.productmanager2.model.Categorie;
import org.assertj.core.api.Assertions;
import org.h2.util.DateTimeUtils;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.annotation.Rollback;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.List;

@DataJdbcTest

public class CategorieRepositoryTests {

/*
    @Autowired
    private CaotegorieRepo categorieRepo;

    // JUnit test for saveEmployee
    @Test
   @Order(1)
    @Rollback(value = false)
    public void saveCategorieTest(){
        Instant instant = Instant.now() ;

       // SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");

        Categorie categorie = Categorie.builder()
                .name ("Location")
                .Qte(5)
                .Date_creation(Timestamp.from(instant))
                .Date_mmodif(Timestamp.from(instant))
                .build();

        categorieRepo.save(categorie);

        Assertions.assertThat(categorie.getId()).isGreaterThan(0);
    }


  /*  @Test
    @Order(2)
    public void getCategorie(){

        Categorie categorie = categorieRepo.findById(35L).get();

        Assertions.assertThat(categorie.getId()).isEqualTo(35);

    }*/

   /* @Test
    @Order(3)
    public void getListOfCategoriesTest(){

        List<Categorie> categories = categorieRepo.findAll();

        Assertions.assertThat(categories.size()).isGreaterThan(0);

    }*/
}


