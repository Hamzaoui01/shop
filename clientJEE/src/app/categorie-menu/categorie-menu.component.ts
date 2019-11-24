import { Component, OnInit } from '@angular/core';
import { CategorieService } from '../categorie.service';
import { Router, OutletContext } from '@angular/router';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-categorie-menu',
  templateUrl: './categorie-menu.component.html',
  styleUrls: ['./categorie-menu.component.scss']
})
export class CategorieMenuComponent implements OnInit {

  constructor(private categorieService: CategorieService,
    private router: Router) { }
  categories;
  products;
  ngOnInit() {
    this.categorieService.getRessource("/ccategories").subscribe(data => {
      this.categories = data;
      if (this.categories[0] != null) {
        this.onGetProducts(this.categories[0]);
      }
    })
  }

  onGetProducts(a) {
    this.categorieService.getRessource("/ccategories/" + a.id).subscribe(data => {
      this.products = data;
    });
  }


}
