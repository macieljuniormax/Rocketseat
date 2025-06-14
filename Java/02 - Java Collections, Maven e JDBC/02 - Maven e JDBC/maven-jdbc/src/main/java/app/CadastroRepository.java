package app;

import java.sql.Connection;
import java.util.ArrayList;

public class CadastroRepository {
  private Connection conexao;

  public CadastroRepository() {
    this.conexao = FabricaConexao.getConexao();
  }

  public void salvar(Cadastro cadastro) {
  };

  public void alterar(Cadastro cadastro) {
  };

  public void excluir(Integer id) {
  };

  public ArrayList<Cadastro> listar(Cadastro cadastro) {
    return new ArrayList<Cadastro>();
  };

  public Cadastro buscar(Cadastro cadastro) {
    return new Cadastro();
  };
}
