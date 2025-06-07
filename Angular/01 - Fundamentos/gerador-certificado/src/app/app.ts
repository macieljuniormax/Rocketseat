import { Component } from '@angular/core';
import { Navbar } from './components/navbar/navbar';
import { CommonModule } from '@angular/common';
import { PrimaryButton } from './components/primary-button/primary-button';
import { SecondaryButton } from './components/secondary-button/secondary-button';
import { ItemCertificado } from "./components/item-certificado/item-certificado";
import { BaseUi } from "./components/base-ui/base-ui";
import { Certificados } from "./pages/certificados/certificados";
import { CertificadoForm } from "./pages/certificado-form/certificado-form";
import { Certificado } from "./pages/certificado/certificado";
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [CommonModule, RouterOutlet, Navbar, BaseUi],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'gerador-certificado';
  protected navbar: boolean = true;
}
