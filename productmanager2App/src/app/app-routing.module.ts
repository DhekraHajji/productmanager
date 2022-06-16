import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
//import { ProduitListItIsComponent } from './produit-list-it-is/produit-list-it-is.component';
import { ProduitsComponent } from './produits/produits.component';

const routes: Routes = [
 {path:'produits', component:ProduitsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
