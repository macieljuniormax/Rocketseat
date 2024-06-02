package pessoa;

public class Professor extends Pessoa {
  private double salario;

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  @Override
  void imprimirDadosDaPessoa() {
    super.imprimirDadosDaPessoa();
    System.out.println("Você é professor!");
  }
}
