package dynamicprogramming;

public class MaxSumSubsequenceOfNonadjacentElements {


    /*
     * Find an efficient algorithm to find maximum sum of a subsequence in an array such that no consecutive elements are part of this subsequence.
     * Input: {1, 6, 10, 14, -5, -1, 2, -1, 3}
     * Output: 25 i.e {4, -1, -2, 1, 5}
     *
     * Below solution has:
     * Runtime Complexity - Linear, O(n).
     * Memory Complexity - Linear, O(n).
     *
     * */

    public static int getLargestSumFromArray(int[] arr) {
        int[] result = new int[arr.length];

        result[0] = arr[0];
        for(int i=1; i<arr.length; i++) {
            result[i] = Math.max(arr[i], result[i-1]);

            if(i-2 >= 0) {
                result[i] = Math.max(result[i], arr[i]+result[i-2]);
            }
        }
        return result[arr.length-1];
    }


    public static void main(String[] args) {
        int[] arr = {1, 6, 10, 14, -5, -1, 2, -1, 3};
        System.out.println(getLargestSumFromArray(arr));
    }
}
