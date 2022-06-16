package com.org.productmanager2.service;
//import javax.persistence.*;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import lombok.Value;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import com.org.productmanager2.Repo.CaotegorieRepo;
import com.org.productmanager2.model.Categorie;
//import org.springframework.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategorieService {
    private final CaotegorieRepo categorieRepo;
    @Autowired
    public CategorieService (CaotegorieRepo categorieRepo) {
        this.categorieRepo = categorieRepo;

    }
    public Categorie addCategorie (Categorie categorie)
    {
        return categorieRepo.save(categorie);
    }
    public List <Categorie> findAllCategories (){
        return categorieRepo.findAll();

    }
    public Categorie updateCategorie (Long id,Categorie categorie)
    {
        this.deleteCategorie(id);
        return categorieRepo.save(categorie);
    }

    /* public Categorie findCategorieById (Long id) throws UserPrincipalNotFoundException {
          return categorieRepo.findCategorieById(id).orElseThrow(()->new UserPrincipalNotFoundException("User by id"+ id +"was not found"));
      }*/
    public void deleteCategorie(Long id)
    {
        categorieRepo.deleteById(id);
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



    //@Value()
    //@Value("${report.path}")






    public String generateReport() {
        String reportPath = "C:\\Users\\0000\\Desktop\\Report";
        List<Categorie> categories = new ArrayList<>();
        categorieRepo.findAll().stream().forEach(e -> categories.add(e));


        try {
            File file = ResourceUtils.getFile("classpath:Cat.jrxml");
            InputStream input = new FileInputStream(file);


            // Compile the Jasper report from .jrxml to .japser
            JasperReport jasperReport = JasperCompileManager.compileReport(input);


            // Get your data source
            JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(categories);


            // Add parameters
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("createdBy", "JavaHelper.org");


            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, source);


            // Export the report to a PDF file
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\Categorie.pdf");
            System.out.println("PDF File Generated !!");


            JasperExportManager.exportReportToXmlFile(jasperPrint, reportPath + "\\Categorie.xml", true);
            System.out.println("XML File Generated !!");


            JasperExportManager.exportReportToHtmlFile(jasperPrint, reportPath + "\\Categorie.html");
            System.out.println("HTML Generated");

            xlsx(jasperPrint);
            csv(jasperPrint);

            return "Report successfully generated @path= " + reportPath;

        } catch (Exception e) {
            return e.getMessage();
        }
    }


   private void csv(JasperPrint jasperPrint) throws JRException {
          String reportPath = "C:\\Users\\0000\\Desktop\\Report";

        JRCsvExporter exporter = new JRCsvExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleWriterExporterOutput(reportPath + "\\Categorie.csv"));


        SimpleCsvExporterConfiguration configuration = new SimpleCsvExporterConfiguration();
        configuration.setFieldDelimiter(",");
        exporter.setConfiguration(configuration);
        exporter.exportReport();
    }


    // Ref: https://www.programcreek.com/java-api-examples/?class=net.sf.jasperreports.export.SimpleXlsxReportConfiguration&method=setOnePagePerSheet
    private void xlsx(JasperPrint jasperPrint) throws JRException {
        String reportPath = "C:\\Users\\0000\\Desktop\\Report";

        // Exports a JasperReports document to XLSX format. It has character output type and exports the document to a grid-based layout.
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(reportPath + "\\Categorie.xlsx"));


        SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
        configuration.setOnePagePerSheet(true);
        configuration.setRemoveEmptySpaceBetweenColumns(true);
        configuration.setDetectCellType(true);
        exporter.setConfiguration(configuration);


        exporter.exportReport();
    }

}
