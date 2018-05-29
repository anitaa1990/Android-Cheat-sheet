package arrays;

import java.util.HashSet;
import java.util.Set;

public class SumOfTwoValues {

    /*
     * Given an array of integers and a value, determine if there are any two integers in the array which sum
     * equal to the given value.
     *
     * Runtime Complexity - Linear, O(n).
     * Memory Complexity - Linear, O(n).
     *
     *  Step 1: Iterate through the array
     *  Step 2: At each element, check if the set contains the difference between the value and the current element.
     *          eg: if value = 10 & current element arr[0] = 5, check if 10-5 is present in the set.
     *  Step 3: If not, add the current element to the set
     * */
    public static void findSumOfTwoValues(int []arr, int value) {

        Set<Integer> map = new HashSet<>();
        for(int i=0; i<arr.length; i++) {

            if(map.contains(value-arr[i])) {
                System.out.println(value-arr[i]+ " "+ arr[i]);
                break;

            } else map.add(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 9, 19};
        findSumOfTwoValues(arr, 14);
    }
}
