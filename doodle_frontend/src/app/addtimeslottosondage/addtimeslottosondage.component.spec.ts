import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddtimeslottosondageComponent } from './addtimeslottosondage.component';

describe('AddtimeslottosondageComponent', () => {
  let component: AddtimeslottosondageComponent;
  let fixture: ComponentFixture<AddtimeslottosondageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddtimeslottosondageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddtimeslottosondageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
