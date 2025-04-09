import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ArquivoUtil {
    public static void escreverArquivo(TipoArquivo tipoArquivo, StringBuilder conteudo) {
        try {
            Path directory = Paths.get("src", "resources");
            Path filePath = directory.resolve(tipoArquivo.getNomeArquivo() + ".txt");

            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            Files.write(filePath, (conteudo.toString() + System.lineSeparator()).getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.APPEND,
                    StandardOpenOption.CREATE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> lerArquivo(TipoArquivo tipoArquivo) {
        try {
            Path arquivoOrigem = Paths.get("src/resources/" + tipoArquivo.getNomeArquivo() + ".txt");
            List<String> linhas = Files.readAllLines(arquivoOrigem);

            return linhas;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
