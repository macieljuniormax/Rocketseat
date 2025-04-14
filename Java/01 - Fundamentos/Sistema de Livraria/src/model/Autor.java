package model;

import java.time.LocalDate;

public class Autor {
    private int id;
    private String nome;
    private LocalDate dataNascimento;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
