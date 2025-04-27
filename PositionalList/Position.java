package PositionalList;

public interface Position<E> {
  E getElement() throws IllegalStateException;
}
