package pessoa;

public class Aluno extends Pessoa {
  private String matricula;

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  @Override
  void imprimirDadosDaPessoa() {
    super.imprimirDadosDaPessoa();
    System.out.println("Você é aluno!");
  }
}
