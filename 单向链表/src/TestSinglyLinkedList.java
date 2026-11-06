import java.util.*;

public class TestSinglyLinkedList {
  public static void main(String[] args) {
    SinglyLinkedList list = new SinglyLinkedList();
    list.addFirst(1);
    list.addLast(2);
    list.addFirst(3);
    list.insert(2, 4);
    list.addFirst(5);
    list.addFirst(6);
    list.addLast(7);
    list.insert(5, 8);
    list.removeFirst();
    list.remove(3);
    list.remove(5);

    list.loop1(val -> System.out.print(val + " "));
    System.out.println();
    list.loop1(val -> System.out.print(val + " "));
    System.out.println();
    for (Integer value : list) {
      System.out.print(value + " ");
    }
    System.out.println();
    list.loop3(
        value -> System.out.print("before:" + value + " "),
        value -> System.out.print("after:" + value + " "));
    System.out.println(list.get(0));
    System.out.println(list.get(4));
  }
}
