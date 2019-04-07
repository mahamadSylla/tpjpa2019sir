import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultereunionComponent } from './consultereunion.component';

describe('ConsultereunionComponent', () => {
  let component: ConsultereunionComponent;
  let fixture: ComponentFixture<ConsultereunionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultereunionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultereunionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
