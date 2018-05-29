package arrays;

public class LowHighIndex {


    /*
     * Given a sorted array of integers, return the low and high index of the given key.
     * Return -1 if not found. The array length can be in millions with lots of duplicates.
     * */


    /*
     * Linear search might be inefficient if the arr length exceeds a millions elements
     * so we can use a modified version of binary search
     * */

    /*
     * Since we are using binary search the runtime complexity is Logarithmic, O(logn).
     * Memory Complexity = O(1)
     * */
    public static void findLowestHighestIndex(int[] arr, int key) {
        int lowestIndex = arr.length-1;
        int highestIndex = 0;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == key) {
                if(i < lowestIndex) {
                    lowestIndex = i;

                }
                if(i > highestIndex) {
                    highestIndex = i;
                }
            }
        }
        System.out.println(lowestIndex + " " + highestIndex);
    }

    


    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 20};
        findLowestHighestIndex(arr, 5);
    }

}
