package Recursion;

import java.io.File;

public class DiskUsage {
  private static long diskUsage(File root) {
    long total = root.length();
    if (root.isDirectory()) {
      for (String child : root.list()) {
        File newChild = new File(root, child);
        total += diskUsage(newChild);
      }
    }
    System.out.println(total);
    return total;
  }
}
