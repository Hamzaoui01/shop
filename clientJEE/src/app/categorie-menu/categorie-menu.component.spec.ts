import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CategorieMenuComponent } from './categorie-menu.component';

describe('CategorieMenuComponent', () => {
  let component: CategorieMenuComponent;
  let fixture: ComponentFixture<CategorieMenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CategorieMenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CategorieMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
