package misc;

import java.util.Arrays;

public class SumOfThreeValues {


    /*
     * Given an array of integers and a value, determine if there are any three integers in the array
     * that sum equal to the given value.
     *
     * Input: 3, 7, 1, 2, 8, 4, 5      Target sum: 20
     * Output: 5 + 7 + 8 = 20
     *
     * Runtime Complexity:
     * O(n2logn).
     *
     * Memory Complexity:
     * Constant, O(1).
     *
     * First sort the input array in O(nlogn) time.
     * Then iterate over each pair (a, b) in the array in a nested loop and calculate the remaining sum
     * (sum - (a + b)).
     * Find the remaining sum in the array using binary search.
     * If found, then solution is found, with the three numbers being a,b and (sum - (a+b)).
     *
     * */


    public static Boolean findSumOfThreeValues(int arr[],
                                               int requiredSum) {

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {

            for (int j = i + 1; j < arr.length - 1; j++) {

                int remaining_sum = requiredSum - arr[i] - arr[j];
                int k = Arrays.binarySearch(arr, remaining_sum);

                if (k > 0 && k != i && k != j) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = {-25, -10, -7, -3, 2, 4, 8, 10};
        System.out.println("-8: " + findSumOfThreeValues(arr, -8));
        System.out.println("-25: " + findSumOfThreeValues(arr, -25));
        System.out.println("0: " + findSumOfThreeValues(arr, 0));
        System.out.println("-42: " + findSumOfThreeValues(arr, -42));
        System.out.println("22: " + findSumOfThreeValues(arr, 22));
        System.out.println("-7: " + findSumOfThreeValues(arr, -7));
        System.out.println("-3: " + findSumOfThreeValues(arr, -3));
        System.out.println("2: " + findSumOfThreeValues(arr, 2));
        System.out.println("4: " + findSumOfThreeValues(arr, 4));
        System.out.println("8: " + findSumOfThreeValues(arr, 8));
        System.out.println("7: " + findSumOfThreeValues(arr, 7));
        System.out.println("1: " + findSumOfThreeValues(arr, 1));
    }
}
