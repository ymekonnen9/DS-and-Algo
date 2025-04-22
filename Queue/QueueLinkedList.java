package Queue;

import SinglyLinkedList.SinglyLinkedList;

public class QueueLinkedList<E> implements Queue<E> {
  private SinglyLinkedList<E> queue;

  public QueueLinkedList() {
    queue = new SinglyLinkedList<E>();
  }

  public void enqueue(E e) {
    queue.addLast(e);
  }

  public E dequeue() {
    return queue.removeFirst();
  }

  public E first() {
    return queue.getFirst();
  }

  public int size() {
    return queue.size();
  }

  public boolean isEmpty() {
    return queue.isEmpty();
  }

}
