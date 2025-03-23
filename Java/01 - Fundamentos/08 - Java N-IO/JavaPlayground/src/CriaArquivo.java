import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CriaArquivo {
    public static void main(String[] args) {
        try {
            // Defina o caminho
            Path directory = Paths.get("src", "resources"); 
            Path filePath = directory.resolve("meuarquivo.txt");

            // Criar diretório se não existir
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            // Criar o arquivo se não existir
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
                System.out.println("Arquivo criado em: " + filePath.toAbsolutePath());
            } else {
                System.out.println("Arquivo já existe em: " + filePath.toAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
