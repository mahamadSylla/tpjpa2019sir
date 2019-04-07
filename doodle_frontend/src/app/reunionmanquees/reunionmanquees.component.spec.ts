import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReunionmanqueesComponent } from './reunionmanquees.component';

describe('ReunionmanqueesComponent', () => {
  let component: ReunionmanqueesComponent;
  let fixture: ComponentFixture<ReunionmanqueesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReunionmanqueesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReunionmanqueesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
