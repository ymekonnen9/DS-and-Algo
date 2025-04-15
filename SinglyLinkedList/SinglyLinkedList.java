package SinglyLinkedList;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {

  private static class Node<E> {
    private E element;
    private Node<E> next;

    public Node(E ele, Node<E> n) {
      this.element = ele;
      this.next = n;
    }

    public E getElement() {
      return element;
    };

    public Node<E> getNext() {
      return next;
    };

    public void setNext(Node<E> newNext) {
      this.next = newNext;
    };
  }

  private Node<E> head = null;
  private Node<E> tail = null;
  private int size = 0;

  public SinglyLinkedList() {
  };

  public int size() {
    return size;
  };

  public boolean isEmpty() {
    return size == 0;
  };

  public E first() {
    if (isEmpty())
      return null;
    return head.getElement();
  }

  public E last() {
    if (isEmpty())
      return null;
    return tail.getElement();
  }

  public void addFirst(E ele) {
    Node<E> newHead = new Node<>(ele, null);
    if (isEmpty()) {
      tail = newHead;
    }
    newHead.next = head;
    head = newHead;
    size++;
  }

  public void addLast(E ele) {
    Node<E> newLastNode = new Node(ele, null);

    if (isEmpty()) {
      tail = newLastNode;
      head = newLastNode;
    }

    tail.next = newLastNode;
    tail = newLastNode;
    size++;
  }

  public E removeFirst() throws NoSuchElementException {
    Node<E> temp = head;
    if (isEmpty())
      throw new NoSuchElementException();
    head = head.getNext();
    return temp.getElement();
  }

  public boolean equals(Object o) {
    if (o == null)
      return false;
    if (head.getClass() != o.getClass()) {
      return false;
    }
    SinglyLinkedList<E> other = (SinglyLinkedList) o;
    if (size() != other.size()) {
      return false;
    }
    Node<E> walkA = head;
    Node<E> walkB = other.head;
    while (walkA != null) {
      if (!walkA.getElement().equals(walkB.getElement())) {
        return false;
      }
      walkA = walkA.getNext();
      walkB = walkB.getNext();
    }
    return true;
  }

}
