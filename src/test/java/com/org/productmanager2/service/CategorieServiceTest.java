package com.org.productmanager2.service;

import com.org.productmanager2.Repo.CaotegorieRepo;
import com.org.productmanager2.model.Categorie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.RequestEntity.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CategorieServiceTest {
@Mock
private CaotegorieRepo categorieRepo;
private AutoCloseable autoCloseable;
private CategorieService underTest;

@BeforeEach
void setUp()
{

    autoCloseable = MockitoAnnotations.openMocks(this);
    underTest = new CategorieService(categorieRepo);
}
@AfterEach
void tearDown() throws Exception {
    autoCloseable.close();

}

    @Test
    void canAddCategorie() {

    Categorie categorie = new Categorie ("Lunette",5,null,null);
    underTest.addCategorie(categorie);

    ArgumentCaptor<Categorie> categorieArgumentCaptor = ArgumentCaptor.forClass(Categorie.class);
    verify(categorieRepo).save(categorieArgumentCaptor.capture());
Categorie captureCategorie = categorieArgumentCaptor.getValue();
assertThat(captureCategorie).isEqualTo(categorie);

    }

    @Test
    void canFindAllCategories() {
    underTest.findAllCategories();
    verify(categorieRepo).findAll();
    }


    @Disabled

    @Test
    void updateCategorie() {
    }




    @Test
    void deleteCategorie() {
        underTest.deleteCategorie(5L);
        verify(categorieRepo).deleteById(5L);
    }

  /*  private MockMvc mockMvc;

    private CategorieService categorieService;
    @Test

    public void givenEmployeeId_whenDeleteEmployee_thenReturn200() throws Exception{
        // given - precondition or setup
        long employeeId = 35L;
        willDoNothing().given(categorieService).deleteCategorie(employeeId);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform((RequestBuilder) delete("/categorie/{id}", employeeId));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print());
    }*/
}