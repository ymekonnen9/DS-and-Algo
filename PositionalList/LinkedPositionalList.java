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

    public void setElement(E e) {
      this.element = e;
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

  private Node<E> validate(Position<E> p) throws IllegalArgumentException {
    if (!(p instanceof Node<E>))
      throw new IllegalArgumentException("P is not instance of a node");
    Node<E> node = (Node<E>) p;
    if (node.getNext() == null)
      throw new IllegalArgumentException("p doesn't exist at that positionlist");
    return node;
  }

  private Position<E> position(Node<E> node) {
    if (node == header || node == trailer)
      return null;
    return node;
  }

  public Position<E> first() {
    return position(header.getNext());
  }

  public Position<E> last() {
    return position(trailer.getPrevious());
  }

  public Position<E> before(Position<E> p) {
    Node<E> node = validate(p);
    return position(node.getPrevious());
  }

  public Position<E> after(Position<E> p) {
    Node<E> node = validate(p);
    return position(node.getNext());
  }

  private Position<E> addBetween(Node<E> predecessor, Node<E> successor, E e) {
    Node<E> newNode = new Node<E>(e, predecessor, successor);
    predecessor.setNext(newNode);
    successor.setPrevious(newNode);
    size++;
    return newNode;
  }

  public Position<E> addFirst(E e) {
    return addBetween(header, header.getNext(), e);
  }

  public Position<E> addLast(E e) {
    return addBetween(trailer.getPrevious(), trailer, e);
  }

  public Position<E> addBefore(Position<E> p, E e) {
    Node<E> node = validate(p);
    return addBetween(node.getPrevious(), node, e);
  }

  public Position<E> addAfter(Position<E> p, E e) {
    Node<E> node = validate(p);
    return addBetween(node, node.getNext(), e);
  }

  public E set(Position<E> p, E e) throws IllegalArgumentException {
    Node<E> node = validate(p);
    E answer = node.getElement();
    node.setElement(e);
    return answer;
  }

  public E remove(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    Node<E> predecessor = node.getPrevious();
    Node<E> successor = node.getNext();
    predecessor.setNext(successor);
    successor.setPrevious(predecessor);
    size--;
    E e = node.getElement();
    node.setElement(null);
    node.setNext(null);
    node.setPrevious(null);
    return e;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

}
