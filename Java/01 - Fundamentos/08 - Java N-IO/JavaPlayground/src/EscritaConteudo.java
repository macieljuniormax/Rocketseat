import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class EscritaConteudo {
    public static void main(String[] args) throws Exception {
        try {
            Path path = Paths.get("src/resources/meuarquivo.txt");

            // Lendo o pat e convertendo todos os caracteres (bytes) de uma vez
            byte[] bytesArquivo = Files.readAllBytes(path);
            String conteudo = new String(bytesArquivo);
            System.out.println(conteudo);

            String conteudoString = Files.readString(path);
            System.out.println(conteudoString);

            List<String> linhas = Files.readAllLines(path);
            for (String linha : linhas) {
                System.out.println(linha);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
