import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditerSondageComponent } from './editer-sondage.component';

describe('EditerSondageComponent', () => {
  let component: EditerSondageComponent;
  let fixture: ComponentFixture<EditerSondageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditerSondageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditerSondageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
