package app;

import java.util.Scanner;

import model.Biblioteca;
import util.ConsoleUtil;
import util.MenuUtil;

public class App {
    public static void main(String[] args) throws Exception {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.carregarLivros();
        biblioteca.carregarClientes();
        MenuUtil.exibirBoasVindas();

        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            MenuUtil.exibirMenu();

            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    ConsoleUtil.clearConsole();
                    System.out.println("📚 Listando livros...\n");
                    biblioteca.listarLivros();
                    MenuUtil.menuVoltar(scanner);
                    break;
                case "2":
                    ConsoleUtil.clearConsole();
                    System.out.println("📝 Cadastrando novo livro...\n");
                    MenuUtil.menuCadastrarLivro(scanner, biblioteca);
                    MenuUtil.menuVoltar(scanner);
                    break;
                case "3":
                    System.out.println("👥 Listando clientes...\n");
                    ConsoleUtil.clearConsole();
                    System.out.println("📚 Listando livros...\n");
                    biblioteca.listarClientes();
                    MenuUtil.menuVoltar(scanner);
                    break;
                case "4":
                    ConsoleUtil.clearConsole();
                    System.out.println("🆕 Cadastrando novo cliente...\n");
                    MenuUtil.menuCadastrarCliente(scanner, biblioteca);
                    MenuUtil.menuVoltar(scanner);
                    break;
                case "5":
                    System.out.println("📖 Emprestando livro...\n");
                    // chamada para emprestar livro
                    break;
                case "0":
                    System.out.println("💤 Encerrando o sistema. Até logo!\n");
                    executando = false;
                    break;
                default:
                    System.out.println("❌ Opção inválida! Tente novamente.\n");
            }
        }

        scanner.close();
    }
}
