import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

    public void adicionarLivro(int id, String titulo, String autor, boolean disponivel, LocalDate dataCadastro,
            LocalDate dataAtualizacao) {
        StringBuilder conteudo = new StringBuilder();

        conteudo.append(id + ";");
        conteudo.append(titulo + ";");
        conteudo.append(autor + ";");
        conteudo.append(disponivel + ";");
        conteudo.append(dataCadastro + ";");
        conteudo.append(dataAtualizacao + ";");

        ArquivoUtil.escreverArquivo(TipoArquivo.LIVROS, conteudo);
    }

    public void carregarLivros() {
        List<String> linhas = ArquivoUtil.lerArquivo(TipoArquivo.LIVROS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (String linha : linhas) {
            String[] colunas = linha.split("\\;");

            int id = Integer.parseInt(colunas[0]);
            String titulo = colunas[1];
            String autor = colunas[2];
            boolean disponivel = Boolean.parseBoolean(colunas[3]);
            LocalDate dataCadastro = LocalDate.parse(colunas[4], formatter);
            LocalDate dataAtualizacao = LocalDate.parse(colunas[5], formatter);

            Livro livro = new Livro(id, titulo, autor, disponivel, dataCadastro, dataAtualizacao);
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
            System.out.println(String.format("%d - %s, %s", livro.getId(), livro.getTitulo(), livro.getAutor()));
        }
    }

    public void adicionarCliente(int id, String nome, LocalDate dataNascimento, String email) {
        StringBuilder conteudo = new StringBuilder();

        conteudo.append(id + ";");
        conteudo.append(nome + ";");
        conteudo.append(dataNascimento + ";");
        conteudo.append(email + ";");

        ArquivoUtil.escreverArquivo(TipoArquivo.CLIENTES, conteudo);
    }

    public void carregarClientes() {
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

}
