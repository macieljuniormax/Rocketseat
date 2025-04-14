package model;

import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private Livro livro;
    private Cliente cliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private LocalDate dataDevolvida;

    public int getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public LocalDate getDataDevolvida() {
        return dataDevolvida;
    }
}
