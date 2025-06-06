import { Component } from '@angular/core';
import { PrimaryButton } from "../../components/primary-button/primary-button";
import { SecondaryButton } from "../../components/secondary-button/secondary-button";

@Component({
  selector: 'app-certificado-form',
  imports: [PrimaryButton, SecondaryButton],
  templateUrl: './certificado-form.html',
  styleUrl: './certificado-form.css'
})
export class CertificadoForm {

}
