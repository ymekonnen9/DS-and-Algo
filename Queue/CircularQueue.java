package Queue;

import CircularlyLinkedList.CircularlyLinkedList;

public class CircularQueue<E> implements Queue<E> {

  private CircularlyLinkedList<E> Cqueue;

  public CircularQueue() {
    Cqueue = new CircularlyLinkedList<E>();
  }

  public void enqueue(E e) {
    Cqueue.addLast(e);
  }

  public E dequeue() {
    return Cqueue.getFirst();
  }

  public E first() {
    return Cqueue.getFirst();
  }

  public int size() {
    return Cqueue.getSize();
  }

  public boolean isEmpty() {
    return Cqueue.isEmpty();
  }

  public void rotate() {
    Cqueue.rotate();
  }

}
