public class ExpressoesBasicas {
    public static void main(String[] args) {
        String nome = "Maciel";
        String sobrenome = "Custódio";
        Integer matricula = 6630728;
        Double salario = 2000.00;

        String textoImpresso = "Olá ".concat(nome).concat(" ").concat(sobrenome);
        String dadosFuncionario = String.format("Nome: %s\nMatricula: %d\nSalário: %,.2f", nome, matricula, salario);

        System.out.println(textoImpresso);
        System.out.println(dadosFuncionario);
    }
}
