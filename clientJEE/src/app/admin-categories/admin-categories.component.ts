import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategorieService } from '../categorie.service';

@Component({
  selector: 'app-admin-categories',
  templateUrl: './admin-categories.component.html',
  styleUrls: ['./admin-categories.component.scss']
})
export class AdminCategoriesComponent implements OnInit {

  constructor(private categorieService:CategorieService,
    private router:Router) {}
  categories;

  ngOnInit() {
   this.onGetAllCategories();
  }

  onGetAllCategories(){
    this.categorieService.getRessource("/ccategories").subscribe(data=>{
      this.categories=data;
    })
  }

  onDelete(c){
    this.categorieService.deleteRessource(c._links.self.href).subscribe(
      data=>{
        this.onGetAllCategories();
      },error=>{
        console.log(error);        
      }
    );
  }
  mode="list";
  onNewCat(){
    this.mode="new-cat";
  }
  onSaveCat(categorie){
    let url=this.categorieService.host+"/categories";
    this.categorieService.postRessource(url,categorie).subscribe(
      data=>{
        this.mode="list";
        this.onGetAllCategories();
      },
      error=>{
        console.log(error);
        
      }
    )    
  }
  _currentCat;
  onUpdate(categorie){         
    //this.categorieService.getRessource()
    this.mode="update-cat";
    let url=this.categorieService.host+"/categories";
    this.categorieService.getRessource(categorie._links.self.href).subscribe(
      data=>{
        console.log(data);
        this._currentCat=data;        
      },
      error=>{
        console.log("nooooooo"+error);        
      }
    )    
  }
  onPutCat(categorie){
    this._currentCat.name=categorie.name;
    this.categorieService.putRessource(this._currentCat._links.self.href,categorie).subscribe(
      data=>{
        this.mode="list";
        this.onGetAllCategories();
      },
      error=>{
        console.log(error);        
      }
    )    
  }
}
