import { Injectable } from '@angular/core';
import { ICertificado } from '../interfaces/certificado';

@Injectable({
  providedIn: 'root'
})
export class CertificadoService {
  private _certificados: ICertificado[] = [];

  // Getters and Setters
  public get certificados(): ICertificado[] { return this._certificados; }

  public adicionarCertificado(certificado: ICertificado): void {
    this._certificados.push({ ...certificado });
    console.log(this.certificados);
  }
}
