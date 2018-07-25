package math;

import java.util.ArrayList;
import java.util.List;

public class SumCombinations {


    /*
     * Given a positive integer, print all possible sum combinations using positive integers
     * Input: 5
     * Output: { 1, 4 }, { 2, 3 }, { 1, 1, 3 }, { 1, 2, 2 }, { 1, 1, 1, 2 }, { 1, 1, 1, 1, 1 }
     *
     * Runtime Complexity:
     * Exponential
     *
     * Memory Complexity:
     * Linear, O(n).
     *
     * recursively go through all possible sum combinations.
     * Whenever the running sum equals the target, print that combination.
     *
     * */

    private static void printList(List<Integer> v) {
        for (int i : v) {
            System.out.print(i + ",");
        }
        System.out.println("");
    }


    protected static void printAllSumRec(int target,
                                         int current_sum,
                                         int start,
                                         List<Integer> output) {

        if (target == current_sum) {
            printList(output);
        }

        for (int i = start; i < target; ++i) {
            int temp_sum = current_sum + i;
            if (temp_sum <= target) {
                output.add(i);
                printAllSumRec(target, temp_sum, i, output);
                output.remove(output.size() - 1);
            } else {
                return;
            }
        }
    }


    public static void main(String[] args) {
        int n = 4;

        List<Integer> output = new ArrayList<>();
        printAllSumRec(n, 0, 1, output);
    }
}
