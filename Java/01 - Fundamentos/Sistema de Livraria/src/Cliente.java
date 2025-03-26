import java.time.LocalDate;

public class Cliente {
    private long id;
    private String nome;
    private LocalDate dataNascimento;
    private String email;

    public long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public String getEmail() {
        return email;
    }
}
