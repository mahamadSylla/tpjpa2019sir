import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreersondageComponent } from './creersondage.component';

describe('CreersondageComponent', () => {
  let component: CreersondageComponent;
  let fixture: ComponentFixture<CreersondageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreersondageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreersondageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
