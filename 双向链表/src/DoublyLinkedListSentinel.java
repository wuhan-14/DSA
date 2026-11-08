import java.util.function.Consumer;
import java.util.*;

public class DoublyLinkedListSentinel implements Iterable<Integer> {
  private static class Node {
    Node prev;
    int value;
    Node next;

    public Node(Node prev, int value, Node next) {
      this.prev = prev;
      this.value = value;
      this.next = next;
    }
  }

  private Node head;
  private Node tail;

  public DoublyLinkedListSentinel() {
    head = new Node(null, 666, null);
    tail = new Node(null, 888, null);
    head.next = tail;
    tail.prev = head;
  }

  private Node findNode(int index) {
    int i = -1;
    for (Node p = head; p != tail; p = p.next, i++) {
      if (i == index) {
        return p;
      }
    }
    return null;
  }

  public void addFirst(int value) {
    insert(0, value);
  }

  public void loop1(Consumer<Integer> consumer) {
    Node p = head.next;
    while (p != tail) {
      consumer.accept(p.value);
      p = p.next;
    }
  }

  public void loop2(Consumer<Integer> consumer) {
    for (Node p = head.next; p != tail; p = p.next) {
      consumer.accept(p.value);
    }
  }

  @Override
  public Iterator<Integer> iterator() {
    return new Iterator<Integer>() {
      Node p = head.next;

      @Override
      public boolean hasNext() {
        return p != tail;
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
    if (tail.prev == head) {
      throw illegalIndex(0);
    }
    return tail.prev;
  }

  public void addLast(int value) {
    Node last = tail.prev;
    Node added = new Node(last, value, tail);
    last.next = added;
    tail.prev = added;
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
    Node next = prev.next;
    Node inserted = new Node(prev, value, next);
    prev.next = inserted;
    next.prev = inserted;
  }

  public void removeFirst() throws IllegalArgumentException {
    remove(0);
  }

  public void removeLast() {
    Node removed = tail.prev;
    if (removed == head) {
      throw illegalIndex(0);
    }
    Node prev = removed.prev;
    prev.next = tail;
    tail.prev = prev;
  }

  public void remove(int index) {
    Node prev = findNode(index - 1);
    if (prev == null) {
      throw illegalIndex(index);
    }
    Node removed = prev.next;
    if (removed == tail) {
      throw illegalIndex(index);
    }
    Node next = removed.next;
    prev.next = next;
    next.prev = prev;
  }
}
