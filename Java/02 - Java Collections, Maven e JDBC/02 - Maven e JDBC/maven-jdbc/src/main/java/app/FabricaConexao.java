package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class FabricaConexao {
  private static Connection conexao;

  public static Connection getConexao() {
    return conexao;
  }

  public static void conectar() {
    try {
      if (conexao == null) {
        String url = "jdbc:postgresql://localhost:5432/rocketseat-Java-02-02-maven-jdbc";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "123456");
        conexao = DriverManager.getConnection(url, props);
        System.out.println("Conexão estabelecida com sucesso!");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
