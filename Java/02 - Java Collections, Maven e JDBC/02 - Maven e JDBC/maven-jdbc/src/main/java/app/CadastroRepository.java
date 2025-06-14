package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CadastroRepository {
  private Connection connection;

  public CadastroRepository() {
    this.connection = FabricaConexao.getConexao();
  }

  public void incluir(Cadastro cadastro) {
    try {
      String instrucaoSQL = "INSERT INTO \"public\".\"tab_cadastro\" (nome, idade) VALUES(?, ?);";
      PreparedStatement statement = connection.prepareStatement(instrucaoSQL);
      statement.setString(1, cadastro.getNome());
      statement.setInt(2, cadastro.getIdade());
      statement.executeUpdate();
      System.out.println("Record created.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
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
