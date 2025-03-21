import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeSample {
    public static void main(String[] args) {
        LocalTime horaAtual = LocalTime.now();

        LocalTime horaMinutoSegundoEspecifico = LocalTime.of(13,21,42); 

        LocalTime horaMinutoEspecifico = LocalTime.of(13,21); 

        LocalTime horaDeUmaString = LocalTime.parse("13:21:42");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
        LocalTime horaDeUmaStringDespadronizada = LocalTime.parse("132142", formatter); 

        System.out.println(horaAtual);
        System.out.println(horaMinutoSegundoEspecifico);
        System.out.println(horaMinutoEspecifico);
        System.out.println(horaDeUmaString);
        System.out.println(horaDeUmaStringDespadronizada);

        System.out.println();
        System.out.println("/////////////////////////////////////////////////////////////");
        System.out.println();

        LocalTime horaAgora = LocalTime.now();
        LocalTime horaAtualMais30Minutos = horaAgora.plusMinutes(30);
        LocalTime horaAtualMenos2Horas = horaAgora.minusHours(2);

        System.out.println(horaAgora);
        System.out.println(horaAtualMais30Minutos);
        System.out.println(horaAtualMenos2Horas);

        System.out.println();
        System.out.println("/////////////////////////////////////////////////////////////");
        System.out.println();
    }
}
