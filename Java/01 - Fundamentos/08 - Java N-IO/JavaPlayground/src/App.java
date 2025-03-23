import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Path path = Paths.get("src/resources/meuarquivo.txt");
            List<String> nomes = new ArrayList<>();
            nomes.add("Maciel");
            nomes.add("Rodrigo");

            StringBuilder conteudo = new StringBuilder();
            nomes.forEach(n -> conteudo.append(n + "\n"));

            Files.write(path, conteudo.toString().getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
