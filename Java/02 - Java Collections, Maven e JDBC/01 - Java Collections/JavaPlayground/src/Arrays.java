public class Arrays {
  public static void main(String[] args) {
    Integer[] array = new Integer[] { 2, 4, 10, 15, 5, 3 };
    array[3] = 20;

    for (Integer integer : array) {
      System.out.println(integer);
    }

    System.out.println(array[3]);
  }
}
