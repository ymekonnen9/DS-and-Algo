package Recursion;

public class Factorial {
  private static int factorial(int n) {
    if (n < 0)
      throw new IllegalArgumentException();
    if (n == 0) {
      return 1;
    } else {
      return n * factorial(n - 1);
    }

  }

  public static void main(String[] args) {
    int result = factorial(3);
    System.out.println(result);
  }
}
