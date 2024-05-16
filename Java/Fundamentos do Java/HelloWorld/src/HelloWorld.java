public class HelloWorld {
  public static void main(String[] args) {
    int dadoDoTipoInt = 11;
    double dadoDoTipoDouble = 3.14;
    float dadoDoTipoFloat = 3.14F;
    long dadoTipoLongo = 733232312314325245L;
    String dadoTipoString = "Hello, World!!!";
    boolean dadoTipoBoolean = false;

    if (dadoDoTipoInt == 10) {
      System.out.println("Entrou no If");
    } else if (dadoDoTipoInt < 12) {
      System.out.println("Entrou no If do 12");
    } else {
      System.out.println("Entrou no Else");
    }

    int valorInicial = 0;
    while (valorInicial < 3) {
      System.out.println("O valor é menor que 3");
      valorInicial++;
    }

    System.out.println("***********************");

    for (int i = 0; i < 4; i++) {
      System.out.println("O valor do i é: " + i);
    }

    System.out.println("***********************");
  }
}