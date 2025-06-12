import { TestBed } from '@angular/core/testing';

import { Certificado } from './certificado.service';

describe('Certificado', () => {
  let service: Certificado;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Certificado);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
