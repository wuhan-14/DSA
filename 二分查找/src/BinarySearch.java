import java.util.*;

public class BinarySearch {
  public static void main(String[] args) {
    int[] num = {3, 4, 6, 15, 24, 38};
    System.out.println(binarySearchBasic1(num, 24));
    System.out.println(binarySearchBasic2(num, 6));
    System.out.println(binarySearchBasic1(num, 9));
    System.out.println(binarySearchBasic2(num, 18));
    int[] num2 = {1, 2, 4, 4, 4, 5, 6};
    System.out.println(binarySearchLeftBasic(num2, 4));
    System.out.println(binarySearchRightBasic(num2, 4));
    System.out.println(binarySearchLeftBasic2(num2, 4));
    System.out.println(binarySearchRightBasic2(num2, 5));

    int[] a = {2, 5, 8};
    int target = 4;
    int i = Arrays.binarySearch(a, target);
    System.out.println(i);
    if (i < 0) {
      int insertIndex = Math.abs(i + 1);
      int[] b = new int[a.length + 1];
      System.arraycopy(a, 0, b, 0, insertIndex);
      b[insertIndex] = target;
      System.arraycopy(a, insertIndex, b, insertIndex + 1, a.length - insertIndex);
      System.out.println(Arrays.toString(b));
    }
  }

  public static int binarySearchBasic1(int[] a, int target) {
    int i = 0, j = a.length - 1;
    while (i <= j) {
      int m = (i + j) >>> 1;
      if (target < a[m]) {
        j = m - 1;
      } else if (a[m] < target) {
        i = m + 1;
      } else {
        return m;
      }
    }
    return -1;
  }

  public static int binarySearchBasic2(int[] a, int target) {
    int i = 0, j = a.length;
    while (i < j) {
      int m = (i + j) >>> 1;
      if (target < a[m]) {
        j = m;
      } else if (a[m] < target) {
        i = m + 1;
      } else {
        return m;
      }
    }
    return -1;
  }

  public static int binarySearchLeftBasic(int[] a, int target) {
    int i = 0, j = a.length - 1;
    int candidate = -1;
    while (i <= j) {
      int m = (i + j) >>> 1;
      if (target < a[m]) {
        j = m - 1;
      } else if (a[m] < target) {
        i = m + 1;
      } else {
        candidate = m;
        j = m - 1;
      }
    }
    return candidate;
  }

  public static int binarySearchRightBasic(int[] a, int target) {
    int i = 0, j = a.length - 1;
    int candidate = -1;
    while (i <= j) {
      int m = (i + j) >>> 1;
      if (target < a[m]) {
        j = m - 1;
      } else if (a[m] < target) {
        i = m + 1;
      } else {
        candidate = m;
        i = m + 1;
      }
    }
    return candidate;
  }

  public static int binarySearchLeftBasic2(int[] a, int target) {
    int i = 0, j = a.length - 1;
    while (i <= j) {
      int m = (i + j) >>> 1;
      if (target <= a[m]) {
        j = m - 1;
      } else {
        i = m + 1;
      }
    }
    return i;
  }

  public static int binarySearchRightBasic2(int[] a, int target) {
    int i = 0, j = a.length - 1;
    while (i <= j) {
      int m = (i + j) >>> 1;
      if (target < a[m]) {
        j = m - 1;
      } else {
        i = m + 1;
      }
    }
    return i - 1;
  }
}
