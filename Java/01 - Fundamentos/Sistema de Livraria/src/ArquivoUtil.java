import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ArquivoUtil {
    public static void escreverArquivo(TipoArquivo tipoArquivo, String conteudo) {
        try {
            Path directory = Paths.get("src", "resources");
            Path filePath = directory.resolve(tipoArquivo.getNomeArquivo() + ".txt");

            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            Files.write(filePath, conteudo.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND,
                    StandardOpenOption.CREATE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
