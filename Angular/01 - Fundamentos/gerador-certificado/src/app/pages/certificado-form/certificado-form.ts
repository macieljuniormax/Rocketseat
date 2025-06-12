import { Component } from '@angular/core';
import { PrimaryButton } from "../../components/primary-button/primary-button";
import { SecondaryButton } from "../../components/secondary-button/secondary-button";
import { FormsModule, NgModel } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-certificado-form',
  imports: [CommonModule, FormsModule, PrimaryButton, SecondaryButton],
  templateUrl: './certificado-form.html',
  styleUrl: './certificado-form.css'
})
export class CertificadoForm {
  private _nome: string = '';
  private _atividade: string = '';
  private _atividades: Array<string> = [];

  // Getters and Setters
  public get nome(): string { return this._nome; }
  public set nome(value: string) { this._nome = value; }
  public get atividade(): string { return this._atividade; }
  public set atividade(value: string) { this._atividade = value; }
  public get atividades(): Array<string> { return this._atividades; }
  public set atividades(value: Array<string>) { this._atividades = value; }

  public campoInvalido(control: NgModel): boolean {
    return !!(control.invalid && (control.dirty || control.touched));
  }

  public formValido(): boolean {
    return (this.atividades.length > 0 && this.nome.length > 0);
  }

  adicionarAtividade() {
    this.atividades.push(this.atividade);
    this.atividade = '';
  }

  excluirAtividade(index: number) {
    this.atividades.splice(index, 1);
  }
}
