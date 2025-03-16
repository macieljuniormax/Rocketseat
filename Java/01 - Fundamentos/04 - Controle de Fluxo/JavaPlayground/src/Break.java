public class Break {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("Interrompendo o loop no número " + i);
                break; // Sai do loop quando i == 5
            }
            System.out.println("Número: " + i);
        }
    }
}
