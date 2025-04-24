package DoubleEndedQueue;

public interface Queue<E> {
  void enqeue(E e);

  E deqeue();

  E first();

  int size();

  boolean isEmpty();

}
