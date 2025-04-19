package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandomSelect<E> {
  public Object[] removeRandom(E[] arr, int i) {
    ArrayList<E> newArrayList = new ArrayList<>(Arrays.asList(arr));
    newArrayList.remove(i);
    return newArrayList.toArray();
  }

  public void random(E[] arr) {
    Random rand = new Random();
    while (arr.length > 0) {
      int i = rand.nextInt(arr.length);
      arr = (E[]) removeRandom(arr, i);
    }

  }

  public static void main(String[] args) {
    RandomSelect<Integer> newRandomSelect = new RandomSelect<>();
    Integer[] arra = { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
    newRandomSelect.random(arra);
  }

}
