import java.util.function.Consumer;
import java.util.*;

public class SinglyLinkedListSentinel implements Iterable<Integer> {
  private Node head = new Node(666, null);

  private static class Node {
    int value;
    Node next;

    public Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }
  }

  public void addFirst(int value) {
    insert(0, value);
  }

  public void loop1(Consumer<Integer> consumer) {
    Node p = head.next;
    while (p != null) {
      consumer.accept(p.value);
      p = p.next;
    }
  }

  public void loop2(Consumer<Integer> consumer) {
    for (Node p = head.next; p != null; p = p.next) {
      consumer.accept(p.value);
    }
  }

  @Override
  public Iterator<Integer> iterator() {
    return new Iterator<Integer>() {
      Node p = head.next;

      @Override
      public boolean hasNext() {
        return p != null;
      }

      @Override
      public Integer next() {
        int v = p.value;
        p = p.next;
        return v;
      }
    };
  }

  private Node findLast() {
    Node p;
    for (p = head; p.next != null; p = p.next) {}

    return p;
  }

  public void addLast(int value) {
    Node last = findLast();
    last.next = new Node(value, null);
  }

  private Node findNode(int index) {
    int i = -1;
    for (Node p = head; p != null; p = p.next, i++) {
      if (i == index) {
        return p;
      }
    }
    return null;
  }

  public int get(int index) throws IllegalArgumentException {
    Node p = findNode(index);
    if (p == null) {
      throw illegalIndex(index);
    }
    return p.value;
  }

  private IllegalArgumentException illegalIndex(int index) {
    return new IllegalArgumentException(String.format("index[%d]不合法%n", index));
  }

  public void insert(int index, int value) throws IllegalArgumentException {
    Node prev = findNode(index - 1);
    if (prev == null) {
      throw illegalIndex(index);
    }
    prev.next = new Node(value, prev.next);
  }

  public void removeFirst() throws IllegalArgumentException {
    remove(0);
  }

  public void remove(int index) {
    Node prev = findNode(index - 1);
    if (prev == null || prev.next == null) {
      throw illegalIndex(index);
    }
    prev.next = prev.next.next;
  }
}
