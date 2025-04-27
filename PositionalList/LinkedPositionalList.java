package PositionalList;

public class LinkedPositionalList<E> implements PositionalList<E> {

  private static class Node<E> implements Position<E> {
    private E element;
    private Node<E> previous;
    private Node<E> next;

    public Node(E element, Node<E> previous, Node<E> next) {
      this.element = element;
      this.previous = previous;
      this.next = next;
    }

    public E getElement() throws IllegalStateException {
      if (next == null)
        throw new IllegalStateException("There is no next position");
      return element;
    }

    public Node<E> getPrevious() {
      return previous;
    }

    public Node<E> getNext() {
      return next;
    }

    public void setNext(Node<E> n) {
      this.next = n;
    }

    public void setPrevious(Node<E> p) {
      this.previous = p;
    }
  }

  private Node<E> header;
  private Node<E> trailer;
  private int size = 0;

  public LinkedPositionalList() {
    header = new Node<E>(null, null, null);
    trailer = new Node<E>(null, header, null);
    header.setNext(trailer);
  }

}
