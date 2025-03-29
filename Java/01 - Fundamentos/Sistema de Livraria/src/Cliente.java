import java.time.LocalDate;

public class Cliente {
    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private String email;

    public int getId() {
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
