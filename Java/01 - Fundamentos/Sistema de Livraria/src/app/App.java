package app;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

import model.Biblioteca;

public class App {
    public static void main(String[] args) throws Exception {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.carregarLivros();
        biblioteca.carregarClientes();
        exibirBoasVindas();

        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            exibirMenu();

            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    clearConsole();
                    System.out.println("📚 Listando livros...\n");
                    biblioteca.listarLivros();
                    menuVoltar(scanner);
                    break;
                case "2":
                    clearConsole();
                    System.out.println("📝 Cadastrando novo livro...\n");
                    menuCadastrarLivro(scanner, biblioteca);
                    menuVoltar(scanner);
                    break;
                case "3":
                    System.out.println("👥 Listando clientes...\n");
                    clearConsole();
                    System.out.println("📚 Listando livros...\n");
                    biblioteca.listarClientes();
                    menuVoltar(scanner);
                    break;
                case "4":
                    clearConsole();
                    System.out.println("🆕 Cadastrando novo cliente...\n");
                    menuCadastrarCliente(scanner, biblioteca);
                    menuVoltar(scanner);
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

    private static void exibirBoasVindas() {
        System.out.println("===========================================");
        System.out.println("        📚 BEM-VINDO À LIVRARIA 📚     ");
        System.out.println("===========================================");
        System.out.println("  Sistema de Gerenciamento de Livros 💻   ");
        System.out.println("===========================================\n");
    }

    private static void exibirMenu() {
        System.out.println("🔸 MENU PRINCIPAL 🔸");
        System.out.println("1  - Listar livros");
        System.out.println("2  - Cadastrar novo livro");
        System.out.println("3  - Listar clientes");
        System.out.println("4  - Cadastrar novo cliente");
        System.out.println("5  - Emprestar livro");
        System.out.println("0  - Sair do sistema\n");
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Não foi possível limpar o console.");
        }
    }

    public static void menuVoltar(Scanner scanner) {
        System.out.println("\n=============================");
        System.out.println("[1] Voltar ao menu principal");
        System.out.println("[0] Encerrar o sistema\n");
        System.out.print("Escolha uma opção: ");

        String escolha = scanner.nextLine();

        switch (escolha) {
            case "1":
                clearConsole();
                return;
            case "0":
                System.out.println("Até logo! 👋");
                System.exit(0);
            default:
                System.out.println("Opção inválida! Voltando ao menu principal...\n");
        }
    }

    public static void menuCadastrarLivro(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("╔═══════════════════════════════════╗");
        System.out.println("║        Cadastro de Livro          ║");
        System.out.println("╚═══════════════════════════════════╝");

        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o nome do autor: ");
        String autor = scanner.nextLine();

        biblioteca.adicionarLivro(titulo, autor, true);

        System.out.println("\n✅ Livro cadastrado com sucesso!");
    }

    public static void menuCadastrarCliente(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("╔═══════════════════════════════════╗");
        System.out.println("║       Cadastro de Cliente         ║");
        System.out.println("╚═══════════════════════════════════╝");

        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a data de nascimento: \n");
        LocalDate dataNascimento = null;
        while (dataNascimento == null) {
            try {
                System.out.print("\tDigite o DIA de nascimento: ");
                int dia = Integer.parseInt(scanner.nextLine());

                System.out.print("\tDigite o MÊS de nascimento: ");
                int mes = Integer.parseInt(scanner.nextLine());

                System.out.print("\tDigite o ANO de nascimento: ");
                int ano = Integer.parseInt(scanner.nextLine());

                dataNascimento = LocalDate.of(ano, mes, dia);
            } catch (NumberFormatException e) {
                System.out.println("❌ Por favor, digite apenas números.");
            } catch (DateTimeException e) {
                System.out.println("❌ Data inválida! Tente novamente.");
            }
        }

        System.out.print("Digite o email do cliente: ");
        String email = scanner.nextLine();

        biblioteca.adicionarCliente(nome, dataNascimento, email);

        System.out.println("\n✅ Cliente cadastrado com sucesso!");
    }
}
