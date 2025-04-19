package Recursion;

public class BinarySearch {
  private static boolean binarySearch(int[] data, int target, int min, int max) {
    if (min > max) {
      return false;
    } else {
      int mid = (min + max) / 2;
      if (data[mid] == target) {
        return true;
      } else if (data[mid] > target) {
        return binarySearch(data, target, min, mid - 1);
      } else {
        return binarySearch(data, target, mid + 1, max);
      }
    }
  }

  public static void main(String[] args) {
    int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    System.out.println(binarySearch(data, 9, 0, 4));
  }
}
