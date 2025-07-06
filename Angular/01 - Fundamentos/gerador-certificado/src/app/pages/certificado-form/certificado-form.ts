import { Component, ViewChild } from '@angular/core';
import { PrimaryButton } from "../../components/primary-button/primary-button";
import { SecondaryButton } from "../../components/secondary-button/secondary-button";
import { FormsModule, NgForm, NgModel } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ICertificado } from '../../interfaces/certificado';
import { CertificadoService } from '../../services/certificado.service';
import { v4 as uuid } from 'uuid';
import { Router } from '@angular/router';

@Component({
  selector: 'app-certificado-form',
  imports: [CommonModule, FormsModule, PrimaryButton, SecondaryButton],
  templateUrl: './certificado-form.html',
  styleUrl: './certificado-form.css'
})
export class CertificadoForm {
  constructor(
    private certificadoService: CertificadoService,
    private router: Router
  ) { }

  private _atividade: string = '';
  private _certificado: ICertificado = { id: '', nome: '', atividades: [], dataEmissao: '' };

  /* ===== Getters and Setters ===== */
  public get atividade(): string { return this._atividade; }
  public set atividade(value: string) { this._atividade = value; }
  public get certificado(): ICertificado { return this._certificado; }
  public set certificado(value: ICertificado) { this._certificado = value; }

  @ViewChild('form') private readonly _form!: NgForm;

  public campoInvalido(control: NgModel): boolean {
    return !!(control.invalid && (control.dirty || control.touched));
  }

  public formValido(): boolean {
    return (this.certificado.atividades.length > 0 && this.certificado.nome.length > 0);
  }

  public adicionarAtividade(): void {
    if (this.atividade.length > 0) {
      this.certificado.atividades.push(this.atividade);
      this.atividade = '';
    }
  }

  public excluirAtividade(index: number): void {
    this.certificado.atividades.splice(index, 1);
  }

  public submit(): void {
    if (!this.formValido()) {
      return;
    }

    this.certificado.id = uuid();
    this.certificado.dataEmissao = this.dataAtual();
    this.certificadoService.adicionarCertificado(this.certificado)
    this.router.navigate(['/certificados', this.certificado.id]);


    // this.limparCampos();
    // this._form.resetForm();
  }

  private dataAtual(): string {
    const data = new Date();
    const dia = String(data.getDate()).padStart(2, '0');
    const mes = String(data.getMonth() + 1).padStart(2, '0');
    const ano = data.getFullYear();
    const dataFormatada = `${dia}/${mes}/${ano}`;

    return dataFormatada;
  }

  private limparCampos(): void {
    this.certificado = { id: '', nome: '', atividades: [], dataEmissao: '' };
  }
}
