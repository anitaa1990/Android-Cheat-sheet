package math;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {


    /*
     * Given a set of n elements find their kth permutation.
     * Input: {1, 2, 3}  k = 6
     * 1st - 123     2nd - 132    3rd - 213   4th - 231   5th - 312   6th - 321
     * Hence Output: 321
     *
     * Runtime Complexity:
     * Linear, O(n).
     *
     * Memory Complexity:
     * Linear, O(n)
     *
     *  Step 1: If input vector is empty return result vector
     *  Step 2: block_size = (n-1)! ['n' is the size of vector]
     *  Step 3: Figure out which block k will lie in and select the first element of that block
     *          (this can be done by doing (k-1)/block_size )
     *  Step 4: Append selected element to result vector and remove it from original input vector
     *  Step 5: Deduce from k the blocks that are skipped i.e k = k - selected*block_size and goto step 1
     *
     * */

    private static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    protected static void findKthPermutation(List<Character> v,
                                             int k,
                                             StringBuilder result) {

        if (v.isEmpty()) {
            return;
        }

        int n = v.size();
        // count is number of permutations starting with first digit
        int count = factorial(n - 1);
        int selected = (k - 1) / count;

        result.append(v.get(selected));
        v.remove(selected);

        k = k - (count * selected);
        findKthPermutation(v, k, result);
    }


    private static String getPermutation(int n, int k) {
        List<Character> v = new ArrayList<>();
        char c = '1';
        for (int i = 1; i <= n; ++i) {
            v.add(c);
            c++;
        }

        StringBuilder result = new StringBuilder();
        findKthPermutation(v, k, result);
        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(getPermutation(4, 2));
    }
}
