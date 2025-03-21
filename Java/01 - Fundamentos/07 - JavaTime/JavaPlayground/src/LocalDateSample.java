import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocalDateSample {
    public static void main(String[] args) {
        LocalDate dataAual = LocalDate.now();

        LocalDate meuAniversario = LocalDate.of(1995, 10, 01);
        
        String dataBR = "01/10/1995";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataConcreta = LocalDate.parse(dataBR, formatter);

        LocalDate farei30Anos = meuAniversario.plusYears(30);
        LocalDate tiraDias = meuAniversario.minusDays(7);

        System.out.println(dataAual);
        System.out.println(meuAniversario);
        System.out.println(dataConcreta);
        System.out.println(farei30Anos);
        System.out.println(tiraDias);
        System.out.println(tiraDias.isBefore(meuAniversario));
        System.out.println(farei30Anos.isAfter(meuAniversario));
        System.out.println(formatter.format(meuAniversario));

        System.out.println();
        System.out.println("/////////////////////////////////////////////////////////////");
        System.out.println();
        
        Locale[] locales = { Locale.CANADA, Locale.US, Locale.UK, Locale.of("pt", "BR") };

        for (Locale locale : locales) {
            String dataFormatada = meuAniversario.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(locale));
            System.out.println(dataFormatada);
        }

        System.out.println();
        System.out.println("/////////////////////////////////////////////////////////////");
        System.out.println();

        LocalDate data = LocalDate.of(2021,8,23);

        System.out.println(data.getDayOfMonth());   // retorna o dia do mês -> 23
        System.out.println(data.getYear());         // retorna o ano -> 2023
        System.out.println(data.getMonth());        // retorna o elemento de enum java.time.Month -> AUGUST
        System.out.println(data.getMonthValue());   // retorna o número do mês entre 1-12 -> 8
    }
}
