import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  jwt:string;
  username:String;
  roles:Array<String>
  host="http://localhost:8080"
  constructor(private http:HttpClient) { }
  login(data){
    return this.http.post(this.host+"/login",data,{observe:'response'})
  }
  saveTocken(jwt:string){
    localStorage.setItem('tocken',jwt);
    this.jwt=jwt;
    this.parseJWT();
  }
  parseJWT() {     
   let jwtHeler=new JwtHelperService();
    let jwtObjet=jwtHeler.decodeToken(this.jwt);
    this.username=jwtObjet.sub;
    this.roles=jwtObjet.roles;    
  }
  isAdmin(){
    return this.roles.indexOf('ADMIN')>=0;
  }
  isUser(){
    return this.roles.indexOf('USER')>=0;
  }
  isAuthenticated(){
    return this.roles&&(this.isAdmin()||this.isUser);
  }
  loadTocken(){
    this.jwt=localStorage.getItem("tocken");
    this.parseJWT();
  }
  logout(){
    this.jwt=undefined;
    this.username=undefined;
    this.roles=undefined;
    localStorage.removeItem("tocken");
    console.log("Loging out");  
  }
}
