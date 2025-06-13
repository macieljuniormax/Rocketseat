import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Conjuntos {
  public static void main(String[] args) {
    HashSet<String> linguagens = new HashSet<String>();
    LinkedHashSet<String> linguagensOrdInsercao = new LinkedHashSet<String>();
    TreeSet<String> linguagensOrdenadas = new TreeSet<String>();

    linguagens.add("Java");
    linguagens.add("Python");
    linguagens.add("JavaScript");
    linguagens.add("C++");
    linguagens.add("Ruby");
    linguagens.add("C#");
    linguagens.add("Go");
    linguagens.add("Java");
    linguagens.add("Swift");

    linguagensOrdInsercao.add("Java");
    linguagensOrdInsercao.add("Python");
    linguagensOrdInsercao.add("JavaScript");
    linguagensOrdInsercao.add("C++");
    linguagensOrdInsercao.add("Ruby");
    linguagensOrdInsercao.add("C#");
    linguagensOrdInsercao.add("Go");
    linguagensOrdInsercao.add("Java");
    linguagensOrdInsercao.add("Swift");

    linguagensOrdenadas.add("Java");
    linguagensOrdenadas.add("Python");
    linguagensOrdenadas.add("JavaScript");
    linguagensOrdenadas.add("C++");
    linguagensOrdenadas.add("Ruby");
    linguagensOrdenadas.add("C#");
    linguagensOrdenadas.add("Go");
    linguagensOrdenadas.add("Java");
    linguagensOrdenadas.add("Swift");

    for (String string : linguagens) {
      System.out.println("Linguagem: " + string);
    }

    System.out.println("\n =============== \n");

    for (String string : linguagensOrdInsercao) {
      System.out.println("Linguagem: " + string);
    }

    System.out.println("\n =============== \n");

    for (String string : linguagensOrdenadas) {
      System.out.println("Linguagem: " + string);
    }
  }
}
