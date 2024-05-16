package primeirasAulas;

import java.util.HashSet;

public class ColecaoHashSet {
  public static void main(String[] args) {
    HashSet<Integer> numeros = new HashSet<>();
    numeros.add(10);
    numeros.add(20);
    numeros.add(30);
    numeros.add(40);

    System.out.println(numeros.size());

    numeros.remove(20);

    for (Integer elemento : numeros) {
      System.out.println(elemento);
    }

    System.out.println(numeros.contains(10));
    System.out.println(numeros.contains(20));

  }
}
