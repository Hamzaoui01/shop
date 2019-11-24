import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class CategorieService {
  host="http://localhost:8088";
  constructor(private http:HttpClient) { }
 
  getRessource(url){
    console.log("browsing to "+this.host+url);
    
    return this.http.get(this.host+url);
  }
  getRessourceWithAutrization(url){
    let headers=new HttpHeaders({'Authorization':localStorage.getItem("tocken")});
    return this.http.get(url,{headers:headers});
  }
  deleteRessource(url){
    let headers=new HttpHeaders({'Authorization':localStorage.getItem("tocken")});
    return this.http.delete(url,{headers:headers});
  }
  postRessource(url,data){
    let headers=new HttpHeaders({'Authorization':localStorage.getItem("tocken")});
    return this.http.post(url,data,{headers:headers});
  }
  putRessource(url,data){
    let headers=new HttpHeaders({'Authorization':localStorage.getItem("tocken")});
    return this.http.put(url,data,{headers:headers});
  }
}
