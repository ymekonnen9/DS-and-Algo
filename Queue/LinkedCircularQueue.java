package Queue;

import CircularlyLinkedList.CircularlyLinkedList;

public class LinkedCircularQueue<E> implements CircularQueue<E> {
  private CircularlyLinkedList<E> circularlinkedlist;

  public LinkedCircularQueue() {
    circularlinkedlist = new CircularlyLinkedList<E>();
  }

  public void enqueue(E e) {
    circularlinkedlist.addLast(e);
  }

  public E dequeue() {
    return circularlinkedlist.removeFirst();
  }

  public E first() {
    return circularlinkedlist.getFirst();
  }

  public int size() {
    return circularlinkedlist.getSize();

  }

  public boolean isEmpty() {
    return circularlinkedlist.isEmpty();
  }

  public void rotate() {
    circularlinkedlist.rotate();
  }

}
