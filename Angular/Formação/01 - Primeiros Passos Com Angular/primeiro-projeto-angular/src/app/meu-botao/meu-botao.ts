import { Component } from '@angular/core';

@Component({
  selector: 'app-meu-botao',
  imports: [],
  templateUrl: './meu-botao.html',
  styleUrl: './meu-botao.css',
})
export class MeuBotao {
  protected limpar(): void {
    console.log('Método Limpar');
  }
}
