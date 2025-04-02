public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        ArquivoUtil.escreverArquivo(TipoArquivo.LIVROS, "Fazendo um teste");
        ArquivoUtil.escreverArquivo(TipoArquivo.LIVROS, "Fazendo um teste");
    }
}
