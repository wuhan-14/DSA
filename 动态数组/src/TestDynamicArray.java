import java.util.*;

public class TestDynamicArray {
  public static void main(String[] args) {
    DynamicArray dynamicarray = new DynamicArray();
    dynamicarray.addLast(1);
    dynamicarray.addLast(2);
    dynamicarray.addLast(3);
    dynamicarray.addLast(4);
    dynamicarray.add(2, 5);

    for (int i = 0; i < 5; i++) {
      System.out.print(dynamicarray.get(i) + " ");
    }
    System.out.println();

    dynamicarray.foreach(
        (element) -> {
          System.out.print(element + " ");
        });
    System.out.println();

    for (Integer element : dynamicarray) {
      System.out.print(element + " ");
    }
    System.out.println();

    dynamicarray.stream()
        .forEach(
            (element) -> {
              System.out.print(element + " ");
            });
    System.out.println();
    int removed = dynamicarray.remove(2);
    System.out.println(removed);

    dynamicarray.stream()
        .forEach(
            (element) -> {
              System.out.print(element + " ");
            });

    // assertEquals(5, removed);
    // assertIterableEquals(List.of(1, 2, 3, 4), dynamicarray);

  }
}
