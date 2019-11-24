import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductsCategorieComponent } from './products-categorie/products-categorie.component';
import { LoginComponent } from './login/login.component';
import { AdminCategoriesComponent } from './admin-categories/admin-categories.component';
import { AdminProductsComponent } from './admin-products/admin-products.component';
import { AdminUsersComponent } from './admin-users/admin-users.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  
  {path:"adminCategories",component:AdminCategoriesComponent},
  {path:"adminProducts",component:AdminProductsComponent},
  {path:"adminUsers",component:AdminUsersComponent},
  {path:"login",component:LoginComponent},
  {path:"",component:HomeComponent},
 // {path:"products/:url",component:ProductsCategorieComponent,outlet:"second"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
