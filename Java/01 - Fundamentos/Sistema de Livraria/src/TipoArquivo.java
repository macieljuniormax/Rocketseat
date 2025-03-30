public enum TipoArquivo {
    LIVROS("livros"),
    CLIENTES("clientes"),
    AUTORES("autores");

    private final String nomeArquivo;

    TipoArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }
}
