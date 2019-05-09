import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlagesComponent } from './plages.component';

describe('PlagesComponent', () => {
  let component: PlagesComponent;
  let fixture: ComponentFixture<PlagesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlagesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
