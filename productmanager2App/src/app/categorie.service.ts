import { Categorie } from './categorie';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment'

@Injectable ({providedIn:'root'})
export class CategorieService {

private apiServerUrl = environment.apiBaseUrl;
constructor (private http: HttpClient) {}
public getCategories (): Observable <Categorie[]>{
return this.http.get<any>(`${this.apiServerUrl}/categorie/all`);}

public addCategorie (categorie:any): Observable <any>{
console.log('Salut');
return this.http.post<any>(`${this.apiServerUrl}/categorie/add`,categorie);}

public updateCategorie(categorieId:number,categorie:any): Observable <any>{
return this.http.put<any>(`${this.apiServerUrl}/categorie/update/${categorieId}`,categorie);}

public deleteCategorie (categorieId: number): Observable <void>{
return this.http.delete<void>(`${this.apiServerUrl}/categorie/delete/${categorieId}`);}

/*public generateReport ():Observable <any>{
return this.http.get<any>('${this.apiServerUrl}/categorie/report/');
}
*/


}
