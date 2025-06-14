package app;

public class SistemaCadastro {
  public static void main(String[] args) {
    FabricaConexao.conectar();

    CadastroRepository cadastroRepository = new CadastroRepository();
    Cadastro cadastro = new Cadastro();
    cadastro.setNome("Maciel Ferreira Custódio Júnior");
    cadastro.setIdade(29);

    cadastroRepository.salvar(cadastro);
  }
}
