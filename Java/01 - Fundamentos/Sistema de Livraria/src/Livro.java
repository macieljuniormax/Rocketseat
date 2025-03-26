import java.time.LocalDate;

public class Livro {
    private long id;
    private String titulo;
    private String autor;
    private boolean disponivel;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;

    public long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    } 
}
