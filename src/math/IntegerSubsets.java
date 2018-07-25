package math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IntegerSubsets {

    /*
     * Find all subsets of a given set of integers
     * Input: {2, 3, 4}
     * Output: {}, {2}, {3}, {4}, {2,3}, {2,4}, {3,4}, {2,3,4}
     *
     * Runtime Complexity:
     * Exponential, O(2n) - where 'n' is number of integers in the given set.
     *
     * Memory Complexity:
     * Exponential, O(2n)
     *
     * n = size of given integer set
     * subsets_count = 2^n
     *  for i = 0 to subsets_count
     *      form a subset using the value of 'i' as following:
     *          bits in number 'i' represent index of elements to choose from original set,
     *          if a specific bit is 1 choose that number from original set and add it to current subset,
     *  e.g. if i = 6 i.e 110 in binary means that 1st and 2nd elements in original array need to be picked.
     *  add current subset to list of all subsets
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

    private static void getAllSubsets(List<Integer> v,
                                      List<HashSet<Integer>> sets) {

        int subsets_count = (int) (Math.pow((double) 2, (double) v.size()));
        for (int i = 0; i < subsets_count; ++i) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < v.size(); ++j) {
                if (getBit(i, j) == 1) {
                    int x = v.get(j);
                    set.add(x);
                }
            }
            sets.add(set);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{8, 13, 3, 22, 17, 39, 87, 45, 36};
        List<Integer> v = new ArrayList<>();
        for (Integer i : arr) {
            v.add(i);
        }

        List<HashSet<Integer>> subsets = new ArrayList<>();
        getAllSubsets(v, subsets);

        for (int i = 0; i < subsets.size(); ++i) {
            System.out.print("{");
            for (Integer it : subsets.get(i)) {
                System.out.print(it + ", ");
            }
            System.out.println("}");
        }
    }
}
