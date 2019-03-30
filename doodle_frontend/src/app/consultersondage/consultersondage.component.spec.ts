import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultersondageComponent } from './consultersondage.component';

describe('ConsultersondageComponent', () => {
  let component: ConsultersondageComponent;
  let fixture: ComponentFixture<ConsultersondageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultersondageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultersondageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
