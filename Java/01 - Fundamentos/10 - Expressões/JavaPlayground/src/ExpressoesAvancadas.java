import java.time.LocalDate;

public class ExpressoesAvancadas {
    public static void main(String[] args) {
        String nome = "Maciel Ferreira Custódio Júnior";
        Integer matricula = 6630728;
        Double salario = 2000.00;
        LocalDate dataAdmissao = LocalDate.now();

        String dadosFuncionario = String.format("Nome: %-35.35s Matricula: %09d Salário: %,.2f", nome, matricula, salario);
        String dataAdmissaoFormatada = String.format("Data de Admissão: %td/%<tm/%<tY", dataAdmissao);
        
        System.out.println(dadosFuncionario);
        System.out.println(dataAdmissaoFormatada);
    }
}
