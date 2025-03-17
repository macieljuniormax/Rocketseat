public class SistemaEnum {
    public static void main(String[] args) {
        EstadosBrasileiros eb = EstadosBrasileiros.PIAUI;

        System.out.println(eb.getNome());
        System.out.println(eb.getSigla());
        System.out.println(eb.name());

        for (EstadosBrasileiros estado : EstadosBrasileiros.values()) {
            System.out.println("Estado Localizado");
            System.out.println(estado.getNome());
            System.out.println(estado.name());
            System.out.println(estado.getSigla());
        }
    }
}
