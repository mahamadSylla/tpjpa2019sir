import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SondagecreeComponent } from './sondagecree.component';

describe('SondagecreeComponent', () => {
  let component: SondagecreeComponent;
  let fixture: ComponentFixture<SondagecreeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SondagecreeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SondagecreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
