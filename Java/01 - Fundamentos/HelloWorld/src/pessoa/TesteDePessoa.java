package pessoa;

public class TesteDePessoa {
  public static void main(String[] args) {
    Aluno aluno = new Aluno();
    aluno.setCpf("33322211100");
    aluno.setNome("Maciel");
    aluno.setIdade(28);
    aluno.setMatricula("190100087");

    Professor professor = new Professor();
    professor.setCpf("33322211100");
    professor.setNome("Rodrigo");
    professor.setIdade(34);
    professor.setSalario(5000.00);

    professor.imprimirDadosDaPessoa();
    aluno.imprimirDadosDaPessoa();
  }
}
