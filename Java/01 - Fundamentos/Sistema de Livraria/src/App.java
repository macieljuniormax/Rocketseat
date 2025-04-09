public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.carregarLivros();
        biblioteca.carregarClientes();

        biblioteca.listarLivros();
        biblioteca.listarClientes();
    }
}
