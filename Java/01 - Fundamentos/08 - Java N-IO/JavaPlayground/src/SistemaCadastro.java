import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaCadastro {
    public static void main(String[] args) {
        List<Cadastro> cadastros = new ArrayList<>();

        cadastros.add(new Cadastro("Joemia Giron Lyrio Monnerat",   "F", 8321485886L, LocalDate.of(1984, 6, 30), 35.5, false));
        cadastros.add(new Cadastro("Reginaldo Folly Barboza Brito", "M", 2127056726L, LocalDate.of(1990, 3, 17), 40.3, true));
        cadastros.add(new Cadastro("Mariza Gadelha Bastida Carneiro", "F", 9124168455L, LocalDate.of(1889, 8, 18), 40.7, false));
        cadastros.add(new Cadastro("Mirian Venancio Portela Ignacio", "M", 6832598389L, LocalDate.of(1975, 11, 21), 29.5, true));
    
        // escreverLayoutDelimitado(cadastros);
        // escreverLayoutPosicional(cadastros);
        // lerLayoutDelimitado();
        lerLayoutPosicional();
    }

    public static void escreverLayoutDelimitado(List<Cadastro> cadastros) {
        System.out.println("***** - LAYOUT DELIMITADO - *****");

        try {
            StringBuilder conteudo = new StringBuilder();

            for (Cadastro cadastro : cadastros) {
                conteudo.append(cadastro.getNome() + ";");
                conteudo.append(cadastro.getSexo() + ";");
                conteudo.append(cadastro.getTelefone() + ";");
                conteudo.append(cadastro.getDataNascimento() + ";");
                conteudo.append(cadastro.getValorSugerido() + ";");
                conteudo.append(cadastro.isCliente() + ";");
                conteudo.append(System.lineSeparator());
            }

            System.out.println(conteudo.toString());

            Path arquivoDestino = Paths.get("src/resources/delimitados/cadastro.csv");
            Files.write(arquivoDestino, conteudo.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Cadastro> lerLayoutDelimitado() {
        List<Cadastro> cadastros = new ArrayList<>();

        try {
            Path arquivoOrigem = Paths.get("src/resources/delimitados/cadastro.csv");

            List<String> linhas = Files.readAllLines(arquivoOrigem);

        for (String linha : linhas) {
            String[] colunas = linha.split("\\;");
            String nome = colunas[0];
            String sexo = colunas[1];
            Long telefone = Long.valueOf(colunas[2]);
            LocalDate dataNascimento = LocalDate.parse(colunas[3]);
            Double valorSugerido = Double.valueOf(colunas[4]);
            boolean cliente = Boolean.valueOf(colunas[5]);

            cadastros.add(new Cadastro(nome, sexo, telefone, dataNascimento, valorSugerido, cliente));
        }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Cadastro cadastro : cadastros) {
            System.out.println(cadastro.nome);
            System.out.println(cadastro.sexo);
            System.out.println(cadastro.telefone);
            System.out.println(cadastro.dataNascimento);
            System.out.println(cadastro.valorSugerido);
            System.out.println(cadastro.cliente);
        }

        return cadastros;
    }

    public static void escreverLayoutPosicional(List<Cadastro> cadastros) {
        System.out.println("***** - LAYOUT POSICIONAL - *****");

        try {
            StringBuilder conteudo = new StringBuilder();
    
            for (Cadastro cadastro : cadastros) {
                String nome = cadastro.getNome();
                if (nome.length() > 30) {
                    nome = nome.substring(0, 30);
                }
    
                if (nome.length() < 30) {
                    nome = String.format("%-30s", nome);
                }
    
                conteudo.append(nome);
                conteudo.append(cadastro.getSexo().toUpperCase());
                conteudo.append(cadastro.getTelefone());
                conteudo.append(cadastro.getDataNascimento());
                
                DecimalFormat decimalFormat = new DecimalFormat("#0000.00");
                String valorFormatado = decimalFormat.format(cadastro.getValorSugerido());
                conteudo.append(valorFormatado.replaceAll("\\,", "\\."));
    
                conteudo.append(cadastro.isCliente() ? "1" : "0");
    
                conteudo.append(System.lineSeparator());
            }

            System.out.println(conteudo.toString());

            Path arquivoDestino = Paths.get("src/resources/posicionais/cadastro.txt");
            Files.write(arquivoDestino, conteudo.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Cadastro> lerLayoutPosicional() {
        List<Cadastro> cadastros = new ArrayList<>();

        try {
          Path arquivoOrigem = Paths.get("src/resources/posicionais/cadastro.txt");
      
          List<String> linhas = Files.readAllLines(arquivoOrigem);
          
          for(String linha:linhas){
            String nome = linha.substring(0,30).trim(); 
            String sexo = linha.substring(30,31); 
            Long telefone = Long.valueOf(linha.substring(31,41));
            LocalDate dataAniversario = LocalDate.parse(linha.substring(41,51));
            Double valorSugerido = Double.valueOf(linha.substring(51,58));
            boolean cliente = linha.substring(58,59).equals("1");

            cadastros.add(new Cadastro(nome,sexo,telefone,dataAniversario,valorSugerido,cliente));
          }
        }catch (Exception ex){
            ex.printStackTrace();
        }
      
        for (Cadastro cadastro : cadastros) {
            System.out.println(cadastro.nome);
            System.out.println(cadastro.sexo);
            System.out.println(cadastro.telefone);
            System.out.println(cadastro.dataNascimento);
            System.out.println(cadastro.valorSugerido);
            System.out.println(cadastro.cliente);
        }

        return cadastros;
    }
}
