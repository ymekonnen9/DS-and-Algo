package Queue;

public class Josephus {

  private static <E> E Josephus(LinkedCircularQueue<E> cirQue, int k) {
    if (cirQue.isEmpty())
      return null;
    while (cirQue.size() > 0) {
      for (int i = 0; i < k - 1; i++) {
        cirQue.rotate();
      }
    }

    E e = cirQue.dequeue();
    return e;

  }

  private static <E> CircularQueue<E> buildQueue(E[] array) {
    CircularQueue<E> cirQueue = new LinkedCircularQueue<>();
    for (int i = 0; i < array.length; i++) {
      cirQueue.enqueue(array[i]);
    }
    return cirQueue;
  }
}
