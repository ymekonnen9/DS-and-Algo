package DoubleEndedQueue;

public class DoublyLinkedList<E> {
  private static class Node<E> {
    private E element;
    private Node<E> previous;
    private Node<E> next;

    public Node(E ele, Node<E> prev, Node<E> nex) {
      this.element = ele;
      this.previous = prev;
      this.next = nex;
    }

    public E getElement() {
      return this.element;
    }

    public Node<E> getPrevious() {
      return this.previous;
    }

    public Node<E> getNext() {
      return this.next;
    }

    public void setPrevious(Node<E> prev) {
      this.previous = prev;
    }

    public void setNext(Node<E> nex) {
      this.next = nex;
    }

  }

  private Node<E> header;
  private Node<E> trailer;
  private int size;

  public DoublyLinkedList() {
    header = new Node<E>(null, null, null);
    trailer = new Node<E>(null, null, null);
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public E getFirst() {
    if (isEmpty())
      return null;
    return header.getNext().getElement();
  }

  public E getLast() {
    if (isEmpty())
      return null;
    return trailer.getPrevious().getElement();
  }

  public void addElement(E ele, Node<E> predecessor, Node<E> successor) {
    Node<E> newFirst = new Node<E>(ele, null, null);
    newFirst.setPrevious(predecessor);
    newFirst.setNext(successor);
    successor.setPrevious(newFirst);
    predecessor.setNext(newFirst);
    size++;
  }

  public void addFirst(E e) {
    addElement(e, header, header.getNext());
  }

  public void addLast(E e) {
    addElement(e, trailer.getPrevious(), trailer);
  }

  public E remove(Node<E> node) {
    E ele = node.getElement();
    node.getPrevious().setNext(node.getNext());
    node.getNext().setPrevious(node.getPrevious());
    size--;
    return ele;
  }

  public E removeFirst() {
    if (isEmpty())
      return null;
    return remove(header.getNext());
  }

  public E removeLast() {
    if (isEmpty())
      return null;
    return remove(trailer.getPrevious());
  }

  public boolean equals(Object o) {
    DoublyLinkedList<E> other = (DoublyLinkedList<E>) o;
    if (this == other)
      return true;
    if (other.size() != size())
      return false;
    Node<E> walkA = header.getNext();
    Node<E> walkB = other.header.getNext();

    while (walkA != null) {
      if (!walkA.getElement().equals(walkB.getElement()))
        return false;
      walkA = walkA.getNext();
      walkB = walkB.getNext();
    }
    return true;
  }

  public DoublyLinkedList<E> clone() throws CloneNotSupportedException {
    DoublyLinkedList<E> other = (DoublyLinkedList<E>) super.clone();
    other.header = null;
    other.trailer = null;
    other.header.setNext(trailer);
    trailer.setPrevious(header);
    other.size = 0;

    Node<E> walk = header.getNext();
    while (walk != null) {
      other.addLast(walk.getElement());
      walk = walk.getNext();
    }
    return other;
  }

}
