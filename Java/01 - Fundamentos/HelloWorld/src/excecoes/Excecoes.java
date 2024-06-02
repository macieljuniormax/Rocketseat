package excecoes;

import pessoa.Pessoa;

public class Excecoes {
  // -> Checked exceptions
  // As exceções verificadas são aquelas que o compilador do Java exige que sejam
  // tratadas, pois são previsíveis e podem ser tratadas de forma apropriada.

  // -> Unchecked exceptions
  // As exceções não verificadas (unchecked exceptions) são aquelas que o
  // compilador não consegue prever no momento da compilação, geralmente ocorrendo
  // durante a execução do programa.

  public static void main(String[] args) {
    // try {
    // validarNumero();
    // } catch (Exception e) {
    // System.out.println("Deu ruim");
    // e.printStackTrace();
    // }

    Pessoa p = null;
    p.getCpf();
  }

  public static void validarNumero() throws Exception {
    int numero = 10;
    if (numero < 100) {
      throw new Exception("O número é menor que 100");
    }
  }
}
