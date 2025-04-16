package DoublyLinkedList;

public class DoublyLinkedList<E> {
  private static class Node<E> {

    private E element;
    private Node<E> prev;
    private Node<E> next;

    public Node(E element, Node<E> pr, Node<E> n) {
      this.element = element;
      this.prev = pr;
      this.next = n;
    }

    public E getElement() {
      return element;
    }

    public Node<E> getPrevious() {
      return prev;
    }

    public Node<E> getNext() {
      return next;
    }

    public void setPrevious(Node<E> pre) {
      prev = pre;
    }

    public void setNext(Node<E> ne) {
      next = ne;
    }
  }

  private Node<E> header;
  private Node<E> trailer;
  private int size;

  public DoublyLinkedList() {
    header = new Node<>(null, null, null);
    trailer = new Node<>(null, header, null);
    header.setNext(trailer);
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public E First() {
    if (isEmpty()) {
      return null;
    } else {
      return header.getNext().getElement();
    }
  }

  public E Last() {
    if (isEmpty()) {
      return null;
    } else {
      return trailer.getPrevious().getElement();
    }
  }

  public void addFirst(E ele) {
    addInBetween(ele, header, header.getNext());
  }

  public void addLast(E ele) {
    addInBetween(ele, trailer.getPrevious(), trailer);
  }

  public void addInBetween(E ele, Node<E> predecessor, Node<E> successor) {
    Node<E> newNode = new Node<E>(ele, predecessor, successor);
    predecessor.setNext(newNode);
    successor.setPrevious(newNode);
    size++;
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

  public E remove(Node<E> node) {
    Node<E> predecessor = node.getPrevious();
    Node<E> successor = node.getNext();
    predecessor.setNext(successor);
    successor.setNext(predecessor);
    size--;
    return node.getElement();
  }

  public boolean equals(Object o) {
    DoublyLinkedList<E> other = (DoublyLinkedList<E>) o;
    if (this == other)
      return true;
    if (size() != other.size()) {
      return false;
    }
    Node<E> walkA = header.getNext();
    Node<E> walkB = other.header.getNext();
    for (int i = 0; i < size; i++) {
      if (!walkA.getElement().equals(walkB.getElement())) {
        return false;
      }
      walkA = walkA.getNext();
      walkB = walkB.getNext();
    }
    return true;
  }

}
