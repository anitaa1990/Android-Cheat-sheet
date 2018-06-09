package arrays;


import java.util.Arrays;

public class FindMaxProduct {

    /*
     *  Find the 3 numbers in an array that produce the max product
     *  Input: {10, 3, 5, 6, 20}
     *  Output: 1200
     * */
    public static int findMaxProduct(int arr[], int n) {
        if (n < 3) return -1;

        // Sort the array in ascending order
        Arrays.sort(arr);

        // Return the maximum of product of last three
        // elements and product of first two elements
        // and last element
        return Math.max(arr[0] * arr[1] * arr[n - 1],
                arr[n - 1] * arr[n - 2] * arr[n - 3]);
    }


    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 6, 20};
        System.out.println(findMaxProduct(arr, arr.length));
    }
}
