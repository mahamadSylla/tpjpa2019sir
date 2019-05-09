import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SondageParticipantsComponent } from './sondage-participants.component';

describe('SondageParticipantsComponent', () => {
  let component: SondageParticipantsComponent;
  let fixture: ComponentFixture<SondageParticipantsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SondageParticipantsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SondageParticipantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
