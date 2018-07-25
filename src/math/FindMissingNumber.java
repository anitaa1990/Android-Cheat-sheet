package math;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FindMissingNumber {

    /*
     * Given an array of positive numbers from 1 to n, such that all numbers from 1 to n are present except one. Find the missing number.
     *
     * Runtime Complexity:
     * Linear, O(n)
     *
     * Memory Complexity:
     * Constant, O(1)
     *
     * Step 1: Find sum 'sum_of_elements' of all the numbers in the array. This would require a linear scan, O(n).
     * Step 2: Then find sum 'expected_sum' of first 'n' numbers using arithmetic series sum formula i.e. ( n * (n + 1) ) / 2.
     * Step 3: Difference between these i.e. 'expected_sum - sum_of_elements' is the missing number in the array.
     *
     * */

    protected static int findMissing(List<Integer> input) {

        int sum_of_elements = 0;
        for (Integer x : input) {
            sum_of_elements += x;
        }

        // There is exactly 1 number missing
        int n = input.size() + 1;
        int actual_sum = (n * (n + 1)) / 2;
        return actual_sum - sum_of_elements;
    }


    public static void main(String[] args) {
        int n = 5;
        int missingElement = (new Random()).nextInt(n) + 1;

        List<Integer> v = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if (i != missingElement)
                v.add(i);
        }

        int actual_missing = findMissing(v);
        System.out.print("Expected Missing = ");
        System.out.print(missingElement);
        System.out.print(" Actual Missing = ");
        System.out.println(actual_missing);
        System.out.println("Missing Element == Actual Missing : " + (missingElement == actual_missing));
    }
}
