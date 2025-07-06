import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { SecondaryButton } from "../../components/secondary-button/secondary-button";
import { ActivatedRoute, RouterLink } from '@angular/router';
import { CertificadoService } from '../../services/certificado.service';
import { ICertificado } from '../../interfaces/certificado';
import html2canvas from 'html2canvas';

@Component({
  selector: 'app-certificado',
  imports: [RouterLink, SecondaryButton],
  templateUrl: './certificado.html',
  styleUrl: './certificado.css'
})
export class Certificado implements OnInit {
  constructor(
    private certificadoService: CertificadoService,
    private route: ActivatedRoute
  ) { }

  private _id: string | null = null;
  private _certificado: ICertificado | undefined = undefined;

  /* ===== Getters and Setters ===== */
  public get certificado(): ICertificado | undefined { return this._certificado; }
  public set certificado(value: ICertificado | undefined) { this._certificado = value; }

  @ViewChild('certificadoContainer') private readonly _certificadoContainer!: ElementRef;

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this._id = params.get('id');
      this._certificado = this.certificadoService.certificados.find(item => item.id === this._id);
    })
  }

  public downloadCertificado(): void {
    if (!this.certificado) {
      return;
    }

    html2canvas(this._certificadoContainer.nativeElement, { scale: 2 }).then(
      canvas => {
        const link = document.createElement('a');
        link.href = canvas.toDataURL('image/png');
        link.download = `certificado_${this.certificado?.nome.replace(/\s+/g, '_')}.png`;
        link.click();
      }
    )
  }
}
