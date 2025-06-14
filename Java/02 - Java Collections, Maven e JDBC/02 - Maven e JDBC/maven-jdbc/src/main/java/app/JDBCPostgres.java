package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class JDBCPostgres {
  public static void main(String[] args) {
    try {
      String url = "jdbc:postgresql://localhost:5432/rocketseat-Java-02-02-maven-jdbc";
      Properties props = new Properties();
      props.setProperty("user", "postgres");
      props.setProperty("password", "123456");
      // props.setProperty("ssl", "true");
      Connection conn = DriverManager.getConnection(url, props);
      System.out.println("Conexão estabelecida com sucesso!");

      System.out.println("Banco atual: " + conn.getCatalog());

      // Forma explícita com schema:
      // Forma segura com aspas para nomes reservados:
      String instrucaoSQL = "INSERT INTO \"public\".\"tab_cadastro\" (nome, idade) VALUES(?, ?);";
      String nome = "Maciel Ferreira Custódio Júnior";
      Integer idade = 29;

      PreparedStatement pstm = conn.prepareStatement(instrucaoSQL);
      pstm.setString(1, nome);
      pstm.setInt(2, idade);
      pstm.execute();

      System.out.println("Cadastro realizado com sucesso!");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
