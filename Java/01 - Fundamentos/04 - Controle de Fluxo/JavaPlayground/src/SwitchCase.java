public class SwitchCase {
    public static void main(String[] args) {
        int numero = 3;
        
        String classificacao;

        switch (numero) {
            case 1:
                classificacao = "Muito Baixo";
                break;
            case 2:
                classificacao = "Baixo";
                break;
            case 3:
                classificacao = "Médio";
                break;
            case 4:
                classificacao = "Alto";
                break;
            case 5:
                classificacao = "Muito Alto";
                break;
            default:
                classificacao = "Fora da faixa";
        }

        System.out.println("Classificação: " + classificacao);
    }
}
