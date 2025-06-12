import { Component } from '@angular/core';
import { SecondaryButton } from "../../components/secondary-button/secondary-button";
import { ItemCertificado } from "../../components/item-certificado/item-certificado";
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-certificados',
  imports: [RouterLink, ItemCertificado, SecondaryButton],
  templateUrl: './certificados.html',
  styleUrl: './certificados.css'
})
export class Certificados {

}
