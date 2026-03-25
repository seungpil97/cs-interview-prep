package week2;

public class GCDemo {
  public static void main(String[] args) {
    for (int i = 0; i < 1_000_000; i++) {
      String s = new String("garbage" + i);
    }
    System.out.println("Done");
  }
}
