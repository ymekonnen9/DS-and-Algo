package Queue;

public class Josephus {

  public static <E> E Josephus(LinkedCircularQueue<E> cirQue, int k) {
    if (cirQue.isEmpty())
      return null;
    while (cirQue.size() > 1) {
      for (int i = 0; i < k - 1; i++) {
        cirQue.rotate();
      }
      cirQue.dequeue();
    }

    return cirQue.dequeue();

  }

  public static <E> CircularQueue<E> buildQueue(E[] array) {
    LinkedCircularQueue<E> cirQueue = new LinkedCircularQueue<>();
    for (int i = 0; i < array.length; i++) {
      cirQueue.enqueue(array[i]);
    }
    return cirQueue;
  }

  public static void main(String[] args) {
    String[] a1 = { "Alice", "Bob", "Cindy", "Doug", "Ed", "Fred" };
    String[] a2 = { "Gene", "Hope", "Irene", "Jack", "Kim", "Lance" };
    String[] a3 = { "Mike", "Roberto" };
    System.out.println("First winner is " + Josephus((LinkedCircularQueue<String>) buildQueue(a1), 3));
    System.out.println("Second winner is " + Josephus((LinkedCircularQueue<String>) buildQueue(a2), 10));
    System.out.println("Third winner is " + Josephus((LinkedCircularQueue<String>) buildQueue(a3), 7));
  }
}
