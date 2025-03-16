public class Ternaria {

    public static void main(String[] args) {
        int numero = 10;
    
        // Usando operador ternário para definir se o número é positivo, negativo ou zero
        String resultado = (numero > 0) ? "Positivo" : (numero < 0) ? "Negativo" : "Zero";
    
        System.out.println("O número é: " + resultado); 

        // Ternário encadeado
        int numero2 = 8;

        String resultado2 = (numero2== 0) ? "Zero"
                          : (numero2 < 0) ? "Negativo"
                          : (numero2 % 2 == 0) ? "Par Positivo"
                          : "Ímpar Positivo";

        System.out.println("O número é: " + resultado2);
    }
}
