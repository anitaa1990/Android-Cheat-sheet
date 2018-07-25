package backtracks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class KSumSubsets {


    /*
     * Given an array of N positive integers, find all the subsets of the given array
     * that sum up to the number K.
     *
     * Input: 1, 3, 5, 21, 19, 7, 2, 5
     * Output: {3,7}, {5,5}, {3,5,2}, {1,7,2}, {3,2,5}
     *
     * Runtime Complexity:
     * Exponential, O(2n) - where 'n' is number of integers in the given set.
     *
     * Memory Complexity:
     * Constant, O(1)
     *
     * Rule: For a set of n elements there are 2n subsets.
     * For example, a set with 3 elements will have 8 subsets.
     *
     * n = size of given integer set
     * subsets_count = 2^n
     * for i = 0 to subsets_count
     *      form a subset using the value of 'i' as following:
     *              bits in number 'i' represent index of elements to choose from original set,
     *              if a specific bit is 1 choose that number from original set and add it to current subset,
     * e.g. if i = 6 i.e 110 in binary means that 2nd and 3rd elements in original array need to be picked.
     * if subset elements sum up to K (required sum), add current subset to list of all subsets
       *
     * */


    private static int getBit(int num, int bit) {
        int temp = (1 << bit);
        temp = temp & num;
        if (temp == 0) {
            return 0;
        }
        return 1;
    }

    private static void getKSumSubsets(List<Integer> v,
                                       Integer targetSum,
                                       List<HashSet<Integer>> sets) {

        int subsetsCount = (int) (Math.pow((double) 2, (double) v.size()));

        for (int i = 0; i < subsetsCount; ++i) {
            HashSet<Integer> set = new HashSet<>();
            Integer sum = 0;

            for (int j = 0; j < v.size(); ++j) {
                if (getBit(i, j) == 1) {
                    sum += v.get(j);
                    if (sum > targetSum) {
                        break;
                    }
                    set.add(v.get(j));
                }
            }
            if (sum == targetSum) {
                sets.add(set);
            }
        }
    }


    private static void verifyResult(List<HashSet<Integer>> subsets) {
        for (int i = 0; i < subsets.size(); ++i) {
            int sum = 0;
            System.out.print("{");
            for (Integer it : subsets.get(i)) {
                System.out.print(it + ", ");
                sum += it;
            }
            System.out.println("}");
            assert (sum == 125);
        }
        assert (subsets.size() == 4);
    }


    public static void main(String[] args) {
        Integer[] arr = {8, 13, 3, 22, 17, 39, 87, 45, 36};
        List<Integer> v = new ArrayList<>();
        for (Integer i : arr) {
            v.add(i);
        }

        List<HashSet<Integer>> subsets = new ArrayList<>();
        getKSumSubsets(v, 125, subsets);
        verifyResult(subsets);
    }
}
