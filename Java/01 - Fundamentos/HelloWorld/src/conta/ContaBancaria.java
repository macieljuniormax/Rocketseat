package conta;

public class ContaBancaria {
  private String numero;
  private String titular;
  private double saldo;

  public ContaBancaria() {
    this.saldo = 0.0;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getTitular() {
    return titular;
  }

  public void setTitular(String titular) {
    this.titular = titular;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  void depositar(double valor) {
    if (valor > 0) {
      this.saldo += valor;
      System.out.println("Depósito de R$" + valor + " realizado com sucesso. Saldo atual: R$" + this.saldo);
    } else {
      System.out.println("Valor de depósito inválido.");
    }
  }

  void sacar(double valor) {
    if (valor > 0 && this.saldo >= valor) {
      this.saldo -= valor;
      System.out.println("Saque de R$" + valor + " realizado com sucesso. Saldo atual: R$" + this.saldo);
    } else {
      System.out.println("Valor de saque inválido.");
    }
  }
}
