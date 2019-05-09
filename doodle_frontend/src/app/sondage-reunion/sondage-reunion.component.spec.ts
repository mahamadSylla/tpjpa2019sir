import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SondageReunionComponent } from './sondage-reunion.component';

describe('SondageReunionComponent', () => {
  let component: SondageReunionComponent;
  let fixture: ComponentFixture<SondageReunionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SondageReunionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SondageReunionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
