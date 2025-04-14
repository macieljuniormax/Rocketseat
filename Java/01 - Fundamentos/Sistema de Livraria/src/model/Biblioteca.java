package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import util.ArquivoUtil;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void adicionarLivro(String titulo, String autor, boolean disponivel) {
        StringBuilder conteudo = new StringBuilder();

        int id = 1;

        if (!this.livros.isEmpty()) {
            Livro ultimoLivro = livros.get(livros.size() - 1);
            id = ultimoLivro.getId() + 1;
        }

        conteudo.append(String.format("%08d", id) + ";");
        conteudo.append(titulo + ";");
        conteudo.append(autor + ";");
        conteudo.append(disponivel + ";");
        conteudo.append(LocalDate.now() + ";");

        ArquivoUtil.escreverArquivo(TipoArquivo.LIVROS, conteudo);
        this.carregarLivros();
    }

    public void carregarLivros() {
        this.livros.clear();

        List<String> linhas = ArquivoUtil.lerArquivo(TipoArquivo.LIVROS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (String linha : linhas) {
            String[] colunas = linha.split("\\;");

            int id = Integer.parseInt(colunas[0]);
            String titulo = colunas[1];
            String autor = colunas[2];
            boolean disponivel = Boolean.parseBoolean(colunas[3]);
            LocalDate dataCadastro = LocalDate.parse(colunas[4], formatter);

            Livro livro = new Livro(id, titulo, autor, disponivel, dataCadastro);
            livros.add(livro);
        }
    }

    public Livro buscarLivro(int id) {
        for (Livro livro : this.livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public void listarLivros() {
        for (Livro livro : this.livros) {
            System.out.println(String.format("%08d - %s, %s", livro.getId(), livro.getTitulo(), livro.getAutor()));
        }
    }

    public void adicionarCliente(String nome, LocalDate dataNascimento, String email) {
        StringBuilder conteudo = new StringBuilder();

        int id = 1;

        if (!this.clientes.isEmpty()) {
            Cliente ultimoCliente = clientes.get(clientes.size() - 1);
            id = ultimoCliente.getId() + 1;
        }

        conteudo.append(id + ";");
        conteudo.append(nome + ";");
        conteudo.append(dataNascimento + ";");
        conteudo.append(email + ";");

        ArquivoUtil.escreverArquivo(TipoArquivo.CLIENTES, conteudo);
        this.carregarClientes();
    }

    public void carregarClientes() {
        this.clientes.clear();

        List<String> linhas = ArquivoUtil.lerArquivo(TipoArquivo.CLIENTES);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (String linha : linhas) {
            String[] colunas = linha.split("\\;");

            int id = Integer.parseInt(colunas[0]);
            String nome = colunas[1];
            LocalDate dataNascimento = LocalDate.parse(colunas[2], formatter);
            String email = colunas[3];

            Cliente cliente = new Cliente(id, nome, dataNascimento, email);
            clientes.add(cliente);
        }
    }

    public Cliente buscarCliente(int id) {
        for (Cliente cliente : this.clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public void listarClientes() {
        for (Cliente cliente : this.clientes) {
            System.out.println(String.format("%d - %s, %s", cliente.getId(), cliente.getNome(), cliente.getEmail()));
        }
    }

    public void emprestarLivro(int idCliente, Livro livro) {

    }

    public void devolverLivro(int idCliente, Livro livro) {

    }
}
