package conta;

public class TesteContaBancaria {
  public static void main(String[] args) {
    ContaBancaria conta1 = new ContaBancaria();
    conta1.setNumero("1234");
    conta1.setTitular("Maciel");

    conta1.depositar(150);
    conta1.sacar(100);
  }
}
