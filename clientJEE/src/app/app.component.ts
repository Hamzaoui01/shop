import { Component } from '@angular/core';
import { AuthenticationService } from './authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  constructor(private auth:AuthenticationService){}
  ngOnInit(): void {
    this.auth.loadTocken();
  }
  title = 'clientJEE';
  isAuthenticated(){
    return this.auth.isAuthenticated();
  }
  isAdmin(){
    return this.auth.isAdmin();
  }
  isUser(){
    return this.auth.isUser();
  }
  onLogout(){
    console.log("jjjjjjjj");
    
    this.auth.logout();
  }
}
