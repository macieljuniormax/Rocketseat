import java.time.LocalDate;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private boolean disponivel;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;

    public Livro(int id, String titulo, String autor, boolean disponivel, LocalDate dataCadastro,
            LocalDate dataAtualizacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
    }
    
    public int getId() {
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
