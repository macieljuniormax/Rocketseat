package com.maciel.ioc_di;

import org.springframework.stereotype.Component;

@Component
public class MeuComponent {

  public String chamarMeuComponente() {
    return "Meu Componente foi chamado!";
  }
}
