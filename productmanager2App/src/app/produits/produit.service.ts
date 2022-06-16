import { Produit } from './produit';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment'

@Injectable ({providedIn:'root'})
export class ProduitService {

private apiServerUrl = environment.apiBaseUrl;
constructor (private http: HttpClient) {}
public getProduits (): Observable <Produit[]>{
return this.http.get<any>(`${this.apiServerUrl}/produit/all`);}

public addProduit (produit:any): Observable <any>{
console.log('Salut');
return this.http.post<any>(`${this.apiServerUrl}/produit/add`,produit);}

public updateProduit(produitId:number,produit:any): Observable <any>{
return this.http.put<any>(`${this.apiServerUrl}/produit/update/${produitId}`,produit);}

public deleteProduit (produitId: number): Observable <void>{
return this.http.delete<void>(`${this.apiServerUrl}/produit/delete/${produitId}`);}



}
