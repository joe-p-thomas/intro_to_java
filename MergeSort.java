// Merge Sort

abstract class MergeSort {

  public static void main(String[] args) {
    int[] sorted;

    System.out.print("[2,3,4,1,5,7,6,9,8]: ");
    sorted = MergeSort.mergeSort(new int[] {2,3,4,1,5,7,6,9,8});
    System.out.print("[");
    for (int num : sorted) {
      System.out.print(Integer.toString(num) + " ");
    }
    System.out.println("]");

    System.out.print("[]: ");
    sorted = MergeSort.mergeSort(new int[0]);
    System.out.print("[");
    for (int num : sorted) {
      System.out.print(Integer.toString(num) + " ");
    }
    System.out.println("]");

    System.out.print("[2]: ");
    sorted = MergeSort.mergeSort(new int[] {2});
    System.out.print("[");
    for (int num : sorted) {
      System.out.print(Integer.toString(num) + " ");
    }
    System.out.println("]");

    System.out.print("[2,3,4,4,4,23,-122,1]: ");
    sorted = MergeSort.mergeSort(new int[] {2,3,4,4,4,23,-122,1});
    System.out.print("[");
    for (int num : sorted) {
      System.out.print(Integer.toString(num) + " ");
    }
    System.out.println("]");
  }

  public static int[] mergeSort(int[] arr) {
    if (arr.length <= 1) {
      return arr;
    } else {
      int mid = arr.length / 2;
      int[] left = new int[mid];
      int[] right = new int[arr.length - mid];

      int i, j;
      for (i = 0; i < mid; i++ ) {
        left[i] = arr[i];
      }

      for (i = 0, j = mid; j < arr.length; i++, j++) {
        right[i] = arr[j];
      }

      left = mergeSort(left);
      right = mergeSort(right);
      return mergeHelper(left, right);
    }
  }

  public static int[] mergeHelper(int[] arr1, int[] arr2) {
    int[] newArr = new int[arr1.length + arr2.length];
    int leftIdx, rightIdx, idx;
    leftIdx = rightIdx = idx = 0;

    while (leftIdx < arr1.length && rightIdx < arr2.length) {
      if (arr1[leftIdx] < arr2[rightIdx]) {
        newArr[idx] = arr1[leftIdx];
        leftIdx++;
      } else {
        newArr[idx] = arr2[rightIdx];
        rightIdx++;
      }
      idx++;
    }

    while (leftIdx < arr1.length) {
      newArr[idx] = arr1[leftIdx];
      leftIdx++;
      idx++;
    }

    while (rightIdx < arr2.length) {
      newArr[idx] = arr2[rightIdx];
      rightIdx++;
      idx++;
    }

    return newArr;
  }
}
