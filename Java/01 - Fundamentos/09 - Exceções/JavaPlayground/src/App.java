import java.text.NumberFormat;
import java.text.ParseException;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Double valor_1 = (double) (100 / 0);
        } catch (Exception e) {
            System.out.println("Erro");
            e.printStackTrace();
        } finally {
            System.err.println("Finally Block");
        }

        try {
            Double valor_2 = Double.valueOf("a1.85");
        } catch (Exception e) {
            System.out.println("Erro");
            e.printStackTrace();
        }
        
        try {
            Number valor_3 = NumberFormat.getCurrencyInstance().parse("a175");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
