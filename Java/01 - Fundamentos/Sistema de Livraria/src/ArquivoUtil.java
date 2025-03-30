import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ArquivoUtil {
    public static void escreverArquivo(TipoArquivo tipoArquivo, String conteudo) {
        try {
            Path directory = Paths.get("src", "resources");
            Path filePath = directory.resolve(tipoArquivo.getNomeArquivo() + "txt");

            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
