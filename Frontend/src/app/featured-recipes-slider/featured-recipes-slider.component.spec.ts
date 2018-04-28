import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FeaturedRecipesSliderComponent } from './featured-recipes-slider.component';

describe('FeaturedRecipesSliderComponent', () => {
  let component: FeaturedRecipesSliderComponent;
  let fixture: ComponentFixture<FeaturedRecipesSliderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FeaturedRecipesSliderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FeaturedRecipesSliderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
