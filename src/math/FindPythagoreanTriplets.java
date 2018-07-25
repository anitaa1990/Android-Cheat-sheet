package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FindPythagoreanTriplets {


    /*
     * Given an integer array find all Pythagorean triplets (a^2 + b^2 = c^2).
     * Input: 4, 16, 1, 2, 3, 5, 6, 8, 25, 10
     *
     * the Pythagorean triplets are (3, 4, 5) and (6, 8, 10) as
     * 32 + 42 = 52 and 62 + 82 = 102
     *
     * Runtime Complexity:
     * Quadratic, O(n2)
     *
     * Memory Complexity:
     * Constant, O(1).
     *
     *
     * */


    protected static List<int[]> findPythagoreanTriplets(int[] arr) {
        int n = arr.length;
        List<int[]> triplets = new ArrayList<int[]>();
        Arrays.sort(arr);

        for (int i = 0; i < n; ++i) {
            if (arr[i] == 0) continue;

            int c2 = arr[i] * arr[i];

            int j = 0;
            int k = n - 1;

            while (j < k) {
                if (j == i || arr[j] == 0) {
                    j += 1;
                    continue;
                }

                if (k == i || arr[k] == 0) {
                    k -= 1;
                    continue;
                }

                int a2 = arr[j] * arr[j];
                int b2 = arr[k] * arr[k];

                if (a2 + b2 == c2) {
                    triplets.add(
                            new int[]{arr[i], arr[j], arr[k]});
                    break;
                } else if (a2 + b2 + (-c2) > 0) {
                    k -= 1;
                } else {
                    j += 1;
                }
            }
        }
        return triplets;
    }


    public static void main(String[] argv) {

        int[] l2 = {13, 4, 25, 6, 8, 110, 99, 32, 15, 18, 19};
        List<int[]> t2 = findPythagoreanTriplets(l2);

        System.out.println("***********");
        for (int[] a : t2) {
            for (int x : a) {
                System.out.print(x + ", ");
            }
            System.out.println();
        }
    }
}
