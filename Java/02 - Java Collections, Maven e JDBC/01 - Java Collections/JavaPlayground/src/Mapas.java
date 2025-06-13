import java.util.HashMap;
import java.util.Iterator;

public class Mapas {
  public static void main(String[] args) {
    HashMap<String, String> estadosBrasileiros = new HashMap<>();
    // TreeMap<String, String> estadosBrasileiros = new TreeMap<>();
    // LinkedHashMap<String, String> estadosBrasileiros = new LinkedHashMap<>();
    estadosBrasileiros.put("AL", "Alagoas");
    estadosBrasileiros.put("AP", "Amapá");
    estadosBrasileiros.put("AM", "Amazonas");
    estadosBrasileiros.put("BA", "Bahia");
    estadosBrasileiros.put("CE", "Ceará");
    estadosBrasileiros.put("DF", "Distrito Federal");
    estadosBrasileiros.put("ES", "Espírito Santo");
    estadosBrasileiros.put("GO", "Goiás");
    estadosBrasileiros.put("MA", "Maranhão");
    estadosBrasileiros.put("MT", "Mato Grosso");
    estadosBrasileiros.put("MS", "Mato Grosso do Sul");
    estadosBrasileiros.put("MG", "Minas Gerais");
    estadosBrasileiros.put("PA", "Pará");
    estadosBrasileiros.put("AC", "Acre");
    estadosBrasileiros.put("PB", "Paraíba");
    estadosBrasileiros.put("PR", "Paraná");
    estadosBrasileiros.put("PE", "Pernambuco");
    estadosBrasileiros.put("PI", "Piauí");
    estadosBrasileiros.put("RJ", "Rio de Janeiro");
    estadosBrasileiros.put("RN", "Rio Grande do Norte");
    estadosBrasileiros.put("RS", "Rio Grande do Sul");
    estadosBrasileiros.put("RO", "Rondônia");
    estadosBrasileiros.put("RR", "Roraima");
    estadosBrasileiros.put("SC", "Santa Catarina");
    estadosBrasileiros.put("SP", "São Paulo");
    estadosBrasileiros.put("SE", "Sergipe");
    estadosBrasileiros.put("TO", "Tocantins");

    System.out.println("Lista de Estados Brasileiros:");
    for (String sigla : estadosBrasileiros.keySet()) {
      System.out.println(sigla + ": " + estadosBrasileiros.get(sigla));
    }

    Iterator<String> keys = estadosBrasileiros.keySet().iterator();
    while (keys.hasNext()) {
      String key = keys.next();
      String estado = estadosBrasileiros.get(key);
      System.out.println("Chave: " + key + ", Estado: " + estado);
    }

    System.out.println("\nVerificando se o estado de São Paulo está presente: " + estadosBrasileiros.containsKey("SP"));
    System.out.println("Verificando se o estado de Minas está presente: " + estadosBrasileiros.containsKey("MG"));
    System.out.println("Verificando se o estado de Bahia está presente: " + estadosBrasileiros.containsValue("Bahia"));

  }
}
