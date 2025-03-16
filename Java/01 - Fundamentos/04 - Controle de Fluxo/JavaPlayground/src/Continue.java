public class Continue {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("Pulando o número " + i);
                continue; // Pula a iteração quando i == 5
            }
            System.out.println("Número: " + i);
        }
    }
}
