import java.time.LocalDate;

public class Autor {
    private long id;
    private String nome;
    private LocalDate dataNascimento;

    public long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    } 
}
