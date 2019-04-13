import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreationUserComponent } from './creation-user.component';

describe('CreationUserComponent', () => {
  let component: CreationUserComponent;
  let fixture: ComponentFixture<CreationUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreationUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreationUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
