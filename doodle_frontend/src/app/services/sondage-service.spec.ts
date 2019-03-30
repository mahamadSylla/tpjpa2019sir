import { TestBed } from '@angular/core/testing';

import { SondageServiceService } from './sondage-service';

describe('SondageServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SondageServiceService = TestBed.get(SondageServiceService);
    expect(service).toBeTruthy();
  });
});
