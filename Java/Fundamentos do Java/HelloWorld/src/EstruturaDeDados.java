import java.util.ArrayList;
import java.util.List;

public class EstruturaDeDados {
  public static void main(String[] args) {
    List<String> nomes = new ArrayList<String>();
    nomes.add("Dani");
    nomes.add("Vini");
    nomes.add("Elias");

    // for (String nome : nomes) {
    // System.err.println(nome);
    // }

    nomes.forEach(nome -> System.out.println("O nome é " + nome));
  }
}
