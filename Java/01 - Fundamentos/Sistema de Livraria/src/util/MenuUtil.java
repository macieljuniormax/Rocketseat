package util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

import model.Biblioteca;

public class MenuUtil {
    public static void exibirBoasVindas() {
        System.out.println("===========================================");
        System.out.println("        📚 BEM-VINDO À LIVRARIA 📚     ");
        System.out.println("===========================================");
        System.out.println("  Sistema de Gerenciamento de Livros 💻   ");
        System.out.println("===========================================\n");
    }

    public static void exibirMenu() {
        System.out.println("🔸 MENU PRINCIPAL 🔸");
        System.out.println("1  - Listar livros");
        System.out.println("2  - Cadastrar novo livro");
        System.out.println("3  - Listar clientes");
        System.out.println("4  - Cadastrar novo cliente");
        System.out.println("5  - Emprestar livro");
        System.out.println("0  - Sair do sistema\n");
    }

    public static void menuVoltar(Scanner scanner) {
        System.out.println("\n=============================");
        System.out.println("[1] Voltar ao menu principal");
        System.out.println("[0] Encerrar o sistema\n");
        System.out.print("Escolha uma opção: ");

        String escolha = scanner.nextLine();

        switch (escolha) {
            case "1":
                ConsoleUtil.clearConsole();
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
