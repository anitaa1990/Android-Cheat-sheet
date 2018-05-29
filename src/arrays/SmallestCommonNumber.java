package arrays;

public class SmallestCommonNumber {


    /*
     * Given three integer arrays sorted in ascending order, f
     * ind the smallest number that is common in all three arrays.
     * */

    /*
     * Take advantage of the sorted array to reduce complexity.
     * Runtime Complexity: Linear, O(n).
     * Memory Complexity: Constant, O(1)
     * */
    public static int findSmallestCommonNumber(int[] arr1,
                                               int[] arr2,
                                               int[] arr3) {
        int i=0, j=0, k=0;
        while (i< arr1.length &&
               j< arr2.length &&
               k<arr3.length) {

            /*
             * Both values are equal
             * */
            if(arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                return arr1[i];
            }

            if(arr1[i] <= arr2[j] && arr1[i] <= arr3[k]) {
                i++;

            } else if(arr2[j] <= arr1[i] && arr2[j] <= arr3[k]) {
                j++;

            } else if(arr3[k] <= arr1[i] && arr3[k] <= arr2[j]) {
                k++;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] arr1 = {6, 7, 10, 25, 30, 63, 64};
        int[] arr2 = {-1, 4, 5, 6, 7, 8, 50};
        int[] arr3 = {1, 6, 10, 14};
        System.out.println(findSmallestCommonNumber(arr1, arr2, arr3));
    }
}
