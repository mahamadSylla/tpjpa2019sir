import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReunionassisteesComponent } from './reunionassistees.component';

describe('ReunionassisteesComponent', () => {
  let component: ReunionassisteesComponent;
  let fixture: ComponentFixture<ReunionassisteesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReunionassisteesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReunionassisteesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
