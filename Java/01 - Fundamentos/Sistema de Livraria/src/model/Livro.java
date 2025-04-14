package model;

import java.time.LocalDate;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private boolean disponivel;
    private LocalDate dataCadastro;

    public Livro(int id, String titulo, String autor, boolean disponivel, LocalDate dataCadastro) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
        this.dataCadastro = dataCadastro;
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
}
