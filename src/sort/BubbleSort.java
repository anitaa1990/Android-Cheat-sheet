package sort;

import java.util.Arrays;

public class BubbleSort {


    /*
     * 1. Bubble sort is the simplest sorting algorithm that compares two adjacent elements in an array and swaps the largest of the two values to  the end.
     * 2. The worst case time complexity of bubble sort is O(n2): this is because for each iteration n-1 comparisons will be done.
     * 3. The best case  time complexity will be O(n): this is when the list is already sorted
     * 4. The space time complexity will be O(1): since only one memory space is required for the temp variable.
     * */
    public static int[] bubbleSort(int[] arr) {
        if(arr.length == 1) return arr;

        for(int i=0; i<arr.length; i++) {

            for(int j=i; j<arr.length; j++) {
                if(arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {55, 23, 26, 2, 25};
        System.out.print(Arrays.toString(bubbleSort(arr)));
    }
}
