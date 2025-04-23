package model;

public enum TipoArquivo {
    LIVROS("livros"),
    CLIENTES("clientes"),
    EMPRESTIMOS("emprestimos");

    private final String nomeArquivo;

    TipoArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }
}
