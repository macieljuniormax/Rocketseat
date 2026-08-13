import { Injectable } from '@angular/core';
import { ICertificado } from '../interfaces/certificado';

@Injectable({
  providedIn: 'root'
})
export class CertificadoService {
  private _certificados: ICertificado[] = [];

  // Getters and Setters
  public get certificados(): ICertificado[] { return this._certificados; }
  public set certificados(value: ICertificado[]) { this._certificados = value; }

  public adicionarCertificado(certificado: ICertificado): void {
    this.certificados.unshift({ ...certificado });
    localStorage.setItem('certificados', JSON.stringify(this._certificados));
  }
}
