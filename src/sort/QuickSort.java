package sort;

import java.util.Arrays;

public class QuickSort {


    /*
     * Given an integer array, sort it in ascending order using quicksort.
     *
     * Runtime Complexity - Linearithmic, O(nlogn).
     * Memory Complexity - Logarithmic, O(logn).
     * Note: Recursive solution has O(logn) memory complexity as it will consume memory on the stack.
     *
     *
     * Step 1: Select a pivot element from the array, usually the first element
     * Step 2: Compare the pivot element with the current element. If the current element is less than the pivot,
     *         shift the current element to the left side and if it is greater than the pivot, shift it to the right
     *         side of the pivot.
     * Step 3: Recursively sort the sublists on the right and left sides of the pivot
     * */

    public static int[] quickSort(int[] arr, int low, int high) {
        if(high > low) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex-1);
            quickSort(arr, partitionIndex+1, high);
        }
        return arr;
    }

    private static int partition(int[]arr, int low, int high) {
        int pivot = arr[low];
        int i=low;
        int j = high;

        while (i < j) {
            while (i<= high && arr[i] <= pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }

            if(i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else break;
        }

        arr[low] = arr[j];
        arr[j] = pivot;

        return j;
    }


    public static void main(String[] args) {
        int[] arr = {55, 23, 26, 2, 25};
        System.out.print(Arrays.toString(quickSort(arr, 0, arr.length-1)));
    }
}
