package DoubleEndedQueue;

public class Dqueue<E> implements Queue<E> {
  private DoublyLinkedList<E> DQ;

  public Dqueue() {
    DQ = new DoublyLinkedList<>();
  }

  public void enqeue(E e) {
    DQ.addLast(e);
  }

  public E deqeue() {
    return DQ.removeFirst();
  }

  public E first() {
    return DQ.getFirst();
  }

  public void add(E e) {
    DQ.addFirst(e);
  }

  public E pop() {
    return DQ.removeFirst();
  }

  public E last() {
    return DQ.getLast();
  }

  public int size() {
    return DQ.size();
  }

  public boolean isEmpty() {
    return DQ.isEmpty();
  }

}
