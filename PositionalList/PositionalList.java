package PositionalList;

public interface PositionalList<E> {
  int size();

  boolean isEmpty();

  Position<E> first();

  Position<E> last();

  Position<E> after(Position<E> a) throws IllegalArgumentException;

  Position<E> before(Position<E> p) throws IllegalArgumentException;

  Position<E> addFirst(E e);

  Position<E> addLast(E e);

  Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;

  Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;

  Position<E> set(Position<E> p, E e) throws IllegalArgumentException;

  Position<E> remove(Position<E> p) throws IllegalArgumentException;

}
