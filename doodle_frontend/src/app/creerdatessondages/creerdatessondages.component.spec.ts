import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreerdatessondagesComponent } from './creerdatessondages.component';

describe('CreerdatessondagesComponent', () => {
  let component: CreerdatessondagesComponent;
  let fixture: ComponentFixture<CreerdatessondagesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreerdatessondagesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreerdatessondagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
