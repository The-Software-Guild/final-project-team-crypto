import { TestBed } from '@angular/core/testing';

import { CryptosService } from './cryptolist/cryptos/cryptos.service';

describe('CryptosService', () => {
  let service: CryptosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CryptosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
