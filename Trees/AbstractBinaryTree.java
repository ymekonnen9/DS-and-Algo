package Trees;

import java.util.ArrayList;
import java.util.List;

public class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

  public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
    Position<E> pos = parent(p);
    if (pos == null) {
      return null;
    } else if (p == left(pos)) {
      return right(pos);
    } else {
      return left(pos);
    }
  }

  public int numChildren(Position<E> p) {
    int count = 0;
    if (left(p) != null) {
      count++;
    } else if (right(p) != null) {
      count++;
    }
    return count;
  }

  public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
    List<Position<E>> snapshot = new ArrayList<>(2);
    if (left(p) != null) {
      snapshot.add(left(p));
    } else if (right(p) != null) {
      snapshot.add(right(p));
    }
    return snapshot;
  }
}
