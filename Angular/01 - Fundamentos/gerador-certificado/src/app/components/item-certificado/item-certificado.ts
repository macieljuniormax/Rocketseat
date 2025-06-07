import { Component } from '@angular/core';
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

  private _certificateId: string = '1';

  public navigateToCertificate() {
    this.router.navigate(['/certificados', this._certificateId]);
  }

  // Getters and Setters
  public get certificateId(): string {
    return this._certificateId;
  }
  public set certificateId(value: string) {
    this._certificateId = value;
  }
}
