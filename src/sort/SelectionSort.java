package sort;

import java.util.Arrays;

public class SelectionSort {

      /*
       * 1. Selection sort is the simplest sorting algorithm. It finds the smallest element in the array and swaps it with the first position in the array. Then the second smallest and swaps it with the second position etc.
       * 2. Worst Case Time Complexity : O(n2)
       * 3. Best Case Time Complexity : O(n2)
       * 4. Average Time Complexity : O(n2)
       * 5. Space Complexity : O(1)
       * This makes it inefficient to operate on larger datasets
       * */
      public static int[] selectionSort(int[] arr) {
          if(arr.length == 1) return arr;

          for(int i=0; i< arr.length; i++) {
              int index = i;

              for(int j=i+1; j< arr.length; j++) {
                  if(arr[j] < arr[index]) {
                      index = j;
                  }
              }
              int smallestNumber = arr[index];
              arr[index] = arr[i];
              arr[i] = smallestNumber;
          }

          return arr;
      }


    public static void main(String[] args) {
        int[] arr = {55, 23, 26, 2, 25};
        System.out.print(Arrays.toString(selectionSort(arr)));
    }
}
