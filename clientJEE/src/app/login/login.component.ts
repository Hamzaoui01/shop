import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private auth:AuthenticationService) { }

  ngOnInit() {
  }
  onLogin(data){
    console.log(data);   
    this.auth.login(data).subscribe(response=>{
      //console.log(response.headers.get('Authorization')); 
      this.auth.saveTocken(response.headers.get('Authorization'));      
    },error=>{
      console.log("ereur authentification");
      
    })
  }

  isAdmin(){
    return this.auth.isAdmin();
  }
  isUser(){
    return this.auth.isUser();
  }


}
