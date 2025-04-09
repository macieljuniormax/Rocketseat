import java.time.LocalDate;
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

    public void adicionarCliente(int id, String nome, LocalDate dataNascimento, String email) {
        StringBuilder conteudo = new StringBuilder();

        conteudo.append(id + ";");
        conteudo.append(nome + ";");
        conteudo.append(dataNascimento + ";");
        conteudo.append(email + ";");

        ArquivoUtil.escreverArquivo(TipoArquivo.CLIENTES, conteudo);
    }

    public void emprestarLivro(int idCliente, Livro livro) {

    }

    public Livro buscarLivro(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public Cliente buscarCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}
