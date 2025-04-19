package Recursion;

public class Fibbonaci {
  private static int[] fibbonaci(int n) {
    if (n <= 1) {
      int[] answer = { 0, 1 };
      return answer;
    } else {
      int[] temp = fibbonaci(n - 1);
      int[] answer = { temp[0] + temp[1], temp[0] };
      return answer;
    }
  }
}
