package com.org.productmanager2.service;


//import javax.persistence.*;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import com.org.productmanager2.Repo.ProduitRepo;
//import com.products.productmanager1.Repo.ProduitRepo;
import com.org.productmanager2.model.Produit;
//import org.springframework.*;
import java.io.File;
import java.io.FileNotFoundException;
//import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProduitService {
    private final ProduitRepo produitRepo;
    @Autowired
    public ProduitService (ProduitRepo produitRepo) {
        this.produitRepo = produitRepo;

    }
    public Produit addProduit (Produit produit)
    {
        return produitRepo.save(produit);
    }
    public List <Produit> findAllProduits (){
        return produitRepo.findAll();

    }
    public Produit updateProduit (Long id,Produit produit)
    {
        return produitRepo.save(produit);
    }

    /* public Categorie findCategorieById (Long id) throws UserPrincipalNotFoundException {
          return categorieRepo.findCategorieById(id).orElseThrow(()->new UserPrincipalNotFoundException("User by id"+ id +"was not found"));
      }*/
    public void deleteProduit(Long id)
    {
        produitRepo.deleteById(id);
    }


   /* public  String exportReport (String reportFormat) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\0000\\Desktop\\Report";
        List<Categorie> categories = categorieRepo.findAll();
        File file = ResourceUtils.getFile("classpath:Cat.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(categories);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "OGA");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        if (reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint,  path + "\\Cat.html");
        }

        if (reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint,  path + "\\Cat.pdf");
        }

        return "report generated in path:"+ path;
    }*/

}


