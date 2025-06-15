package app;

import java.util.ArrayList;

public class SistemaCadastro {
  public static void main(String[] args) {
    FabricaConexao.conectar();

    CadastroRepository cadastroRepository = new CadastroRepository();
    ArrayList<Cadastro> cadastros = cadastroRepository.listar();

    for (Cadastro cadastro : cadastros) {
      System.out
          .println("ID: " + cadastro.getId() + ", Nome: " + cadastro.getNome() + ", Idade: " + cadastro.getIdade());
    }

    System.out.println("-----------------------------");

    Cadastro cadastro = cadastroRepository.buscar(2);
    if (cadastro != null) {
      System.out.println("Cadastro encontrado: ID: " + cadastro.getId() + ", Nome: " + cadastro.getNome() + ", Idade: "
          + cadastro.getIdade());
    } else {
      System.out.println("Cadastro não encontrado.");
    }

    // Cadastro cadastro = new Cadastro();
    // cadastro.setNome("Rodrigo Calazans");
    // cadastro.setIdade(35);
    // cadastro.setId(3);

    // cadastroRepository.deletar(1);
  }
}
