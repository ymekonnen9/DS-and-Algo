package CircularlyLinkedList;

public class CircularlyLinkedList<E> {

  private static class Node<E> {
    private E element;
    private Node<E> next;

    public Node(E ele, Node<E> n) {
      this.element = ele;
      this.next = n;
    }

    public E getElement() {
      return element;
    }

    public Node<E> getNext() {
      return next;
    }

    public void setNext(Node<E> nex) {
      this.next = nex;
    }
  }

  private Node<E> tail = null;
  private int size = 0;

  public CircularlyLinkedList() {
  };

  public boolean isEmpty() {
    return size == 0;
  }

  public int getSize() {
    return size;
  }

  public E getFirst() {
    if (isEmpty()) {
      return null;
    } else {
      return tail.getNext().getElement();
    }
  }

  public E getLast() {
    if (isEmpty()) {
      return null;
    } else {
      return tail.getElement();
    }
  }

  public void rotate() {
    if (!isEmpty()) {
      tail = tail.getNext();
    }
  }

  public void addFirst(E ele) {
    if (isEmpty()) {
      tail = new Node<E>(ele, null);
      tail.setNext(tail);
    } else {
      Node<E> newFirstNode = new Node<E>(ele, tail.getNext());
      tail.setNext(newFirstNode);
    }
    size++;
  }

  public void addLast(E ele) {
    if (isEmpty()) {
      Node<E> newLast = new Node<E>(ele, tail);
      tail = newLast;
    } else {
      addFirst(ele);
      tail = tail.getNext();
    }
  }

}
