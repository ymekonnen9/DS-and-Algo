package Arrays;

import java.util.Arrays;
import java.util.Random;

public class ArraysMethods {
  public static void main(String[] args) {
    int[] data = new int[10];
    Random rand = new Random();
    rand.setSeed(System.currentTimeMillis());

    for (int i = 0; i < data.length; i++) {
      data[i] = rand.nextInt(100);
    }

    int[] ori = Arrays.copyOf(data, data.length);
    System.out.println(Arrays.equals(data, ori));
    Arrays.sort(data);

    System.out.println(Arrays.equals(data, ori));
    System.out.println(Arrays.toString(data));
    System.out.println(Arrays.toString(ori));
  }
}
