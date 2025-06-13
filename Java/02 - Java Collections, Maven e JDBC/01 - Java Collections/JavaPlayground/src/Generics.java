import java.util.ArrayList;
import java.util.Collections;

public class Generics {
  public static void main(String[] args) {
    ArrayList<String> prateleira = new ArrayList<>();

    prateleira.add("Livro E");
    prateleira.add("Livro C");
    prateleira.add("Livro A");
    prateleira.add("Livro D");
    prateleira.add("Livro B");

    Collections.sort(prateleira);

    for (String livro : prateleira) {
      System.out.println(livro);
    }

    Collections.shuffle(prateleira);
    for (String livro : prateleira) {
      System.out.println(livro);
    }
  }
}
