import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro(1, "A Química", "Stepheny Meyer", true, LocalDate.now(), LocalDate.of(2024, 4, 9));
        biblioteca.adicionarCliente(1, "Maciel Ferreira Custódio Júnior", LocalDate.of(1995, 10, 1),
                "maciel_custodio@icloud.com");
    }
}
