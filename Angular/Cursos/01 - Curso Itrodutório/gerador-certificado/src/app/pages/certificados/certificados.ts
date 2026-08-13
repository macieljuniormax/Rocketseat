import { Component, OnInit } from '@angular/core';
import { SecondaryButton } from "../../components/secondary-button/secondary-button";
import { ItemCertificado } from "../../components/item-certificado/item-certificado";
import { RouterLink } from '@angular/router';
import { CertificadoService } from '../../services/certificado.service';
import { ICertificado } from '../../interfaces/certificado';

@Component({
  selector: 'app-certificados',
  imports: [RouterLink, ItemCertificado, SecondaryButton],
  templateUrl: './certificados.html',
  styleUrl: './certificados.css'
})
export class Certificados implements OnInit {
  constructor(private certificadoService: CertificadoService) { }

  private _certificados: ICertificado[] = [];

  /* ===== Getters and Setters ===== */
  public get certificados(): ICertificado[] { return this._certificados; }
  public set certificados(value: ICertificado[]) { this._certificados = value; }

  ngOnInit(): void {
    this._certificados = this.certificadoService.certificados;
  }
}
