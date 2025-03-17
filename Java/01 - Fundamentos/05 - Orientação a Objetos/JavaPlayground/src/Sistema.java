public class Sistema {
    public static void main(String[] args) {
        Cliente maciel = new Cliente("Maciel");
        Cliente izabel = new Cliente("Izabel");

        maciel.solicitarLimiteCredito(200.00);
        izabel.solicitarLimiteCredito(100.00);
        maciel.comprar(50.0);
        izabel.comprar(25.0);

        System.out.println(maciel.limiteCredito);
        System.out.println(izabel.limiteCredito);
    }
}
