import { Component, OnInit } from '@angular/core';
import { Categorie } from './categorie';
import { CategorieService } from './categorie.service';
//import { Produit } from './produit';
//import { ProduitService } from './produit.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm, FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public categories!: Categorie [];
 public deleteCategorie!: Categorie;
// public editCategorie: Categorie;
 public addForm: any;
 // public updateForm: FormGroup;
  public category:any;
  public router: any;;
 // public produit:any;
  //public produits!: any;


  constructor (private categorieService: CategorieService, private fb: FormBuilder){

  }

public goToProduits()
  {
  this.router.navigate(["/produits"])
  }



  ngOnInit (){this.getCategories();

  this.addForm = this.fb.group({
        name: ['', Validators.required],
        Qte: ['', Validators.required],
        Date_creation: [null, Validators.required],
        Date_mmodif: [null, Validators.required]

      });
  }

/*  public getProduits(): void {

  this.produitService.getProduits().subscribe(
  (response: Produit[]) => {
  this.produits = response;
  },
  (error: HttpErrorResponse) => {
  alert(error.message);
  }
  );
  }*/



  public getCategories(): void {

  this.categorieService.getCategories().subscribe(
  (response: Categorie[]) => {
  this.categories = response;
  },
  (error: HttpErrorResponse) => {
  alert(error.message);
  }
  );
  }

  public onDeleteCategorie (categorieId: number): void {
    this.categorieService.deleteCategorie(categorieId).subscribe(
    (response: void) => {
    console.log(response);
    this.getCategories();

    },
    (error: HttpErrorResponse)=> {

    alert (error.message)}
    );


    }

  /*  public onGenerateReport:void()
    {
     this.categorieService.generateReport().subscribe(
        (response: void) => {
        console.log(response);

        },
        (error: HttpErrorResponse)=> {

        alert (error.message)}
        );

    }*/

public onAddCategorie():void {
 //public onAddCategorie(addForm: NgForm):void {
 //document.getElementById(addbutton).click();
  this.category = {
      name: this.addForm.get('name')?.value,
      qte: this.addForm.get('Qte')?.value,
      date_creation: this.addForm.get('Date_creation')?.value,
       date_mmodif: this.addForm.get('Date_mmodif')?.value
    };

 // this.categorieService.addCategorie(addForm.value).subscribe(
 this.categorieService.addCategorie(this.category).subscribe(
  (response: Categorie) => {
  console.log(response);
  this.getCategories();

  },
  (error: HttpErrorResponse)=> {

  alert (error.message)}
  );
}



 /*public onUpdateCategorie(categorie: Categorie): void {
    this.categorieService.updateCategorie(categorie).subscribe(
    (response: Categorie) => {
    console.log(response);
    this.getCategories();

    },
    (error: HttpErrorResponse)=> {

    alert (error.message)}
    );


    }*/

  /*  public onUpdateCategorie(categorieId: number):void {
     //public onAddCategorie(addForm: NgForm):void {
     //document.getElementById(addbutton).click();
      this.category = {

          name: this.addForm.get('name')?.value,
          qte: this.addForm.get('Qte')?.value,
          date_creation: this.addForm.get('Date_creation')?.value,
           date_mmodif: this.addForm.get('Date_mmodif')?.value
        };

     // this.categorieService.addCategorie(addForm.value).subscribe(
     this.categorieService.updateCategorie(categorieId,this.category).subscribe(
      (response: Categorie) => {
      console.log(response);
      this.getCategories();

      },
      (error: HttpErrorResponse)=> {

      alert (error.message)}
      );
    }*/


  public onOpenModal (categorie:Categorie, mode:string):void {
  const container = document.getElementById('main-container');
  const button = document.createElement ('button');
  button.type='button';
  button.style.display='none';
  button.setAttribute('data-bs-toggle','modal');
 if (mode === 'add'){  button.setAttribute('data-bs-target','#addCategorieModal');}
   if (mode === 'delete'){
   this.deleteCategorie = categorie;
   button.setAttribute('data-bs-target','#deleteCategorieModal');}
 if (mode === 'update'){
  // this.editCategorie = categorie;
   button.setAttribute('data-bs-target','#updateCategorieModal');}

container!.appendChild(button);
button.click();
  }



}

