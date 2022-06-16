import { Component, OnInit } from '@angular/core';

import { Produit } from './produit';
import { ProduitService } from './produit.service';
//import { Produit } from './produit';
//import { ProduitService } from './produit.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm, FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css']
})
export class ProduitsComponent implements OnInit {
  public produits!: any;
 public deleteProduit!: any;
// public editCategorie: Categorie;
 public addForm: any;
 // public updateForm: FormGroup;
  public produit:any;
  public router: any;;
 // public produit:any;
  //public produits!: any;


  constructor (private produitService: ProduitService, private fb: FormBuilder){

  }

public goToProduits()
  {
  this.router.navigate(["/produits"])
  }



  ngOnInit (){this.getProduits();

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

  public getProduits(): void {

  this.produitService.getProduits().subscribe(
  (response: Produit[]) => {
  this.produits = response;
  },
  (error: HttpErrorResponse) => {
  alert(error.message);
  }
  );
  }

  public onDeleteProduit (produitId: number): void {
    this.produitService.deleteProduit(produitId).subscribe(
    (response: void) => {
    console.log(response);
    this.getProduits();

    },
    (error: HttpErrorResponse)=> {

    alert (error.message)}
    );


    }

public onAddProduit():void {
 //public onAddCategorie(addForm: NgForm):void {
 //document.getElementById(addbutton).click();
  this.produit = {
      name: this.addForm.get('name')?.value,
      qte: this.addForm.get('Qte')?.value,
      date_creation: this.addForm.get('Date_creation')?.value,
       date_mmodif: this.addForm.get('Date_mmodif')?.value
    };

 // this.categorieService.addCategorie(addForm.value).subscribe(
 this.produitService.addProduit(this.produit).subscribe(
  (response: Produit) => {
  console.log(response);
  this.getProduits();

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


  public onOpenModal (produit:Produit, mode:string):void {
  const container = document.getElementById('main-container');
  const button = document.createElement ('button');
  button.type='button';
  button.style.display='none';
  button.setAttribute('data-bs-toggle','modal');
 if (mode === 'add'){  button.setAttribute('data-bs-target','#addCategorieModal');}
   if (mode === 'delete'){
   this.deleteProduit = produit;
   button.setAttribute('data-bs-target','#deleteCategorieModal');}
 if (mode === 'update'){
  // this.editCategorie = categorie;
   button.setAttribute('data-bs-target','#updateCategorieModal');}

container!.appendChild(button);
button.click();
  }



}



