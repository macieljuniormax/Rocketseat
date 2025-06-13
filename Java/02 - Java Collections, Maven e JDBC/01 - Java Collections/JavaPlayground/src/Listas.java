import java.util.ArrayList;

public class Listas {
  public static void main(String[] args) {
    ArrayList<String> linguagens = new ArrayList<>();
    linguagens.add("Java");
    linguagens.add("Python");
    linguagens.add("JavaScript");
    linguagens.add("C++");
    linguagens.add("Ruby");
    linguagens.add("C#");
    linguagens.add("Go");
    linguagens.add("Java");

    linguagens.remove("Java");
    linguagens.add(6, "Swift");

    System.out.println("Comprimento da lista: " + linguagens.size());
    System.out.println("A linguagem na posição 3 é: " + linguagens.get(3));
    System.out.println("A linguagem Java está na posição: " + linguagens.indexOf("Java"));
    System.out.println("A linguagem Go está na posição: " + linguagens.indexOf("Go"));
    System.out.println("Temos a linguagem Ruby na lista? " + linguagens.contains("Ruby"));

    for (String string : linguagens) {
      System.out.println("Linguagem: " + string);
    }
  }
}
