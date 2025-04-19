package Recursion;

public class ReverseArray {
  private static void reverseArray(int[] data, int low, int high) {
    if (low < high) {
      int temp = data[low];
      data[low] = data[high];
      data[high] = temp;
      reverseArray(data, low + 1, high - 1);
    }
  }
}
