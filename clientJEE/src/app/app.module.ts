import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CategorieMenuComponent } from './categorie-menu/categorie-menu.component';
import { HttpClientModule } from '@angular/common/http';
import { CategorieService } from './categorie.service';
import { ProductsComponent } from './products/products.component';
import { LoginComponent } from './login/login.component';
import { FormsModule }   from '@angular/forms';
import { AdminProductsComponent } from './admin-products/admin-products.component';
import { AdminCategoriesComponent } from './admin-categories/admin-categories.component';
import { AdminUsersComponent } from './admin-users/admin-users.component';
import { HomeComponent } from './home/home.component';
//import { JwtHelperService} from '@auth0/angular-jwt'

@NgModule({
  declarations: [
    AppComponent,
    CategorieMenuComponent,
    ProductsComponent,
    LoginComponent,
    AdminProductsComponent,
    AdminCategoriesComponent,
    AdminUsersComponent,
    HomeComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    //JwtHelperService
  ],
  providers: [
    CategorieService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
