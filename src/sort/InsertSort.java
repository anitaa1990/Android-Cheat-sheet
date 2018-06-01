package sort;


import java.util.Arrays;

public class InsertSort {


    /*
     * Insertion sort compares the current element with the element on the left.
     * If it is found to be smaller it is swapped with the element on the left.
     * Worst Case Time Complexity : O(n2)
     * Best Case Time Complexity : O(n)
     * Average Time Complexity : O(n2)
     * Space Complexity : O(1)
     * This makes it inefficient to operate on larger datasets
     * */
    public static int[] insertionSort(int[] arr) {
        if(arr.length == 1) return arr;

        for(int i=1; i<arr.length; i++) {

            for(int j=i; j>0; j--) {
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }

        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {55, 23, 26, 2, 25};
        System.out.print(Arrays.toString(insertionSort(arr)));
    }
}
