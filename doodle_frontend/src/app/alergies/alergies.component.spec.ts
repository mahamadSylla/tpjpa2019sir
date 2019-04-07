import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlergiesComponent } from './alergies.component';

describe('AlergiesComponent', () => {
  let component: AlergiesComponent;
  let fixture: ComponentFixture<AlergiesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlergiesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlergiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
