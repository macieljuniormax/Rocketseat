package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CadastroRepository {
  private Connection connection;

  public CadastroRepository() {
    this.connection = FabricaConexao.getConexao();
  }

  public void inserir(Cadastro cadastro) {
    try {
      String sql = "INSERT INTO \"public\".\"tab_cadastro\" (nome, idade) VALUES(?, ?);";
      PreparedStatement statement = this.connection.prepareStatement(sql);
      statement.setString(1, cadastro.getNome());
      statement.setInt(2, cadastro.getIdade());
      statement.executeUpdate();

      System.out.println("Record created.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  };

  public void atualizar(Cadastro cadastro) {
    try {
      String sql = "UPDATE public.tab_cadastro SET nome=?, idade=? WHERE id=?;";
      PreparedStatement statement = this.connection.prepareStatement(sql);
      statement.setString(1, cadastro.getNome());
      statement.setInt(2, cadastro.getIdade());
      statement.setInt(3, cadastro.getId());
      statement.executeUpdate();

      System.out.println("Record updated.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  };

  public void deletar(Integer id) {
    try {
      String sql = "DELETE FROM public.tab_cadastro WHERE id=?;";
      PreparedStatement statement = this.connection.prepareStatement(sql);
      statement.setInt(1, id);
      statement.executeUpdate();

      System.out.println("Record deleted.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  };

  public ArrayList<Cadastro> listar() {
    ArrayList<Cadastro> cadastros = new ArrayList<>();
    try {
      String sql = "SELECT id, nome, idade FROM public.tab_cadastro;";
      PreparedStatement statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        Integer id = result.getInt("id");
        String nome = result.getString("nome");
        int idade = result.getInt("idade");

        Cadastro cadastro = new Cadastro();
        cadastro.setId(id);
        cadastro.setNome(nome);
        cadastro.setIdade(idade);

        cadastros.add(cadastro);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return cadastros;
  };

  public Cadastro buscar(Integer id) {
    Cadastro cadastro = null;
    try {
      String sql = "SELECT id, nome, idade FROM public.tab_cadastro WHERE id = ?;";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      ResultSet result = statement.executeQuery();
      if (result.next()) {
        String nome = result.getString("nome");
        int idade = result.getInt("idade");

        cadastro = new Cadastro();
        cadastro.setId(id);
        cadastro.setNome(nome);
        cadastro.setIdade(idade);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return cadastro;
  };
}
