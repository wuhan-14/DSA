import java.util.*;

public class TestDoublyCircularLinkedListSentinel {
  public static void main(String[] args) {
    DoublyCircularLinkedListSentinel list = new DoublyCircularLinkedListSentinel();
    list.addFirst(1);
    list.addLast(2);
    list.addFirst(3);
    list.addFirst(5);
    list.addFirst(6);
    list.addLast(7);
    list.removeFirst();
    list.removeByValue(3);
    list.removeByValue(5);

    for (Integer value : list) {
      System.out.print(value + " ");
    }
    System.out.println();
  }
}
