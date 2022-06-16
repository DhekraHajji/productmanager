package com.org.productmanager2;

import com.org.productmanager2.Repo.CaotegorieRepo;
import com.org.productmanager2.model.Categorie;
//import com.org.productmanager2.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootApplication
public class Productmanager2Application {

/*@Autowired
	private CaotegorieRepo repository;
@Autowired
private ReportService service;
@GetMapping ("/getCategoriess")
public List <Categorie> getCategoriess(){

	return repository.findAll();
}*/

	/*@GetMapping("/report/{format}")
	public String generateReport (@PathVariable String format)throws FileNotFoundException, JRException {
		return service.exportReport(format);
	}*/

	public static void main(String[] args) {
		SpringApplication.run(Productmanager2Application.class, args);
	}

}
