import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
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
        Livro livro = new Livro(id, titulo, autor, disponivel, dataCadastro, dataAtualizacao);
        this.livros.add(livro);
    }

    public void emprestarLivro(int idCliente, Livro livro) {

    }
}
