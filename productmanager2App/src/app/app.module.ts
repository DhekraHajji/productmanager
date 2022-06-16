import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { CommonModule } from "@angular/common";
import { AppComponent } from './app.component';

import { APP_INITIALIZER } from '@angular/core';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';


//import { ProduitsComponent } from './produits/produits.component';
import { Routes, RouterModule } from "@angular/router";
import { ProduitsComponent } from './produits/produits.component';
import { AppRoutingModule } from './app-routing.module';
//import { ProduitListItIsComponent } from './produit-list-it-is/produit-list-it-is.component';
const routes: Routes = [
{ path:"produits", component:ProduitsComponent }
];



function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8280/auth/',
        realm: 'security',
        clientId: 'angular-client',
      },
      initOptions: {
        onLoad: 'login-required',  // allowed values 'login-required', 'check-sso';
        flow: "standard"          // allowed values 'standard', 'implicit', 'hybrid';
      },
    });
}





@NgModule({
  declarations: [
    AppComponent,
    ProduitsComponent,
   // ProduitsComponent


  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],

  imports: [
     BrowserModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
         CommonModule,

        AppRoutingModule,
        KeycloakAngularModule,

        ],

  providers: [


 {
    provide: APP_INITIALIZER,
    useFactory: initializeKeycloak,
    multi: true,
    deps: [KeycloakService],
  },



  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
