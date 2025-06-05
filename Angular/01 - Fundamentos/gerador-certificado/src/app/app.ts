import { Component } from '@angular/core';
import { Navbar } from './components/navbar/navbar';
import { CommonModule } from '@angular/common';
import { PrimaryButton } from './components/primary-button/primary-button';
import { SecondaryButton } from './components/secondary-button/secondary-button';
import { ItemCertificado } from "./components/item-certificado/item-certificado";
import { BaseUi } from "./components/base-ui/base-ui";

@Component({
  selector: 'app-root',
  imports: [Navbar, CommonModule, PrimaryButton, SecondaryButton, ItemCertificado, BaseUi],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'gerador-certificado';
  protected navbar: boolean = true;
}
