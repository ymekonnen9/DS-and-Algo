package Stack;

import SinglyLinkedList.SinglyLinkedList;

public class LinkedListStack<E> implements Stack<E> {

  private SinglyLinkedList<E> linkedlist;

  public LinkedListStack() {
    linkedlist = new SinglyLinkedList<>();
  }

  public void push(E e) {
    linkedlist.addFirst(e);
  }

  public E pop() {
    return linkedlist.removeFirst();
  }

  public E top() {
    return linkedlist.getFirst();
  }

  public int size() {
    return linkedlist.size();
  }

  public boolean isEmpty() {
    return linkedlist.isEmpty();
  }

}
