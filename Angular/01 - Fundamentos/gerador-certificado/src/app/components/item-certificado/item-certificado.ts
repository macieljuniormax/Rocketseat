import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { SecondaryButton } from "../secondary-button/secondary-button";

@Component({
  selector: 'app-item-certificado',
  imports: [SecondaryButton],
  templateUrl: './item-certificado.html',
  styleUrl: './item-certificado.css'
})
export class ItemCertificado {
  constructor(private router: Router) { }

  private _nomeAluno: string = '';
  private _dataEmissao: string = '';
  private _certificateId: string = '';

  /* ===== Getters and Setters ===== */
  @Input()
  public get nomeAluno(): string { return this._nomeAluno; }
  public set nomeAluno(value: string) { this._nomeAluno = value; }
  @Input()
  public get dataEmissao(): string { return this._dataEmissao; }
  public set dataEmissao(value: string) { this._dataEmissao = value; }
  @Input()
  public get certificateId(): string { return this._certificateId; }
  public set certificateId(value: string) { this._certificateId = value; }

  public navigateToCertificate() {
    this.router.navigate(['/certificados', this._certificateId]);
  }
}
