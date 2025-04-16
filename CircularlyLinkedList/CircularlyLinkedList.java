package CircularlyLinkedList;

public class CircularlyLinkedList<E> implements Cloneable {

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

  public boolean equals(Object o) {
    CircularlyLinkedList<E> other = (CircularlyLinkedList<E>) o;
    if (other == null)
      return false;
    if (other.getClass() != this.getClass())
      return false;
    if (getSize() != other.getSize())
      return false;
    Node<E> walkA = tail.getNext();
    Node<E> walkB = other.tail.getNext();
    for (int i = 0; i < size; i++) {
      if (!walkA.getElement().equals(walkB.getElement()))
        return false;
      walkA = walkA.getNext();
      walkB = walkB.getNext();
    }

    return true;

  }

  public CircularlyLinkedList<E> clone() throws CloneNotSupportedException {
    CircularlyLinkedList<E> other = (CircularlyLinkedList<E>) super.clone();
    Node<E> originalHead = tail.getNext();

    Node<E> newHead = new Node<>(originalHead.getElement(), null);

    Node<E> newTail = newHead;

    Node<E> walk = originalHead.getNext();
    for (int i = 1; i < size; i++) {
      Node<E> newNode = new Node<>(walk.getElement(), null);
      newTail.setNext(newNode);
      newTail = newNode;
    }

    newTail.setNext(newHead);

    other.tail = newTail;
    other.size = size;

    return other;
  }

}
