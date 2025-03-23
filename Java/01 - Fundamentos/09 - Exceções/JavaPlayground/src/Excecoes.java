public class Excecoes {
    public static void main(String[] args) {
        try {
            checkEstado("FL");
        } catch (EstadoValidateException e) {
            System.out.println(e.getMessage());
            System.out.println("Selecione um estado válido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Selecione um estado brasileiro");
        }
    }

    static void checkEstado(String nomeEstadoString) throws EstadoValidateException, Exception {
        if (nomeEstadoString.equals("FL")) {
            throw new Exception("Estado não consta no Brasil");
        }

        if (!nomeEstadoString.equals("PI")) {
            throw new EstadoValidateException();
        }

        System.out.println("Bem-vindo ao (a)" + " " + nomeEstadoString.toUpperCase());
    }
}
