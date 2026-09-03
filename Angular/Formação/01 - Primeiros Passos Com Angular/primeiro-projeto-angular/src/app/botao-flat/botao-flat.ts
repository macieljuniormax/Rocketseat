import { Component } from '@angular/core';

@Component({
  selector: 'app-botao-flat',
  imports: [],
  template: ` <button class="btn btn-filled" (click)="filtrar()">Filtrar</button> `,
  styles: `
    .btn {
      --primary-orange: #f55a00;
      --white: #ffffff;

      font-family: Arial, Helvetica, sans-serif;
      padding: 12px 24px;
      font-size: 1em;
      font-weight: bold;
      border-radius: 8px;
      cursor: pointer;
      min-width: 150px;
      text-align: center;
      box-sizing: border-box;
    }

    .btn-filled {
      background-color: var(--primary-orange);
      border: 2px solid var(--primary-orange);
      color: var(--white);
    }
  `,
})
export class BotaoFlat {
  protected filtrar(): void {
    console.log('Método Filtrar');
  }
}
