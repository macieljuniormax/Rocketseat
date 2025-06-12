import { Component, OnInit } from '@angular/core';
import { Navbar } from './components/navbar/navbar';
import { CommonModule } from '@angular/common';
import { BaseUi } from "./components/base-ui/base-ui";
import { RouterOutlet } from '@angular/router';
import { CertificadoService } from './services/certificado.service';

@Component({
  selector: 'app-root',
  imports: [CommonModule, RouterOutlet, Navbar, BaseUi],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {
  constructor(private certificadoService: CertificadoService) { }

  protected title = 'gerador-certificado';
  protected navbar: boolean = true;

  ngOnInit(): void {
    const certificados = localStorage.getItem('certificados');
    this.certificadoService.certificados = certificados ? JSON.parse(certificados) : [];
    console.log(this.certificadoService.certificados);
  }
}
