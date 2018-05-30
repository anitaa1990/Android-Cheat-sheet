package dynamicprogramming;

import java.util.Arrays;

public class GameScoring {

    // Scoring options are 1, 2, 4
    public static int scoring_options_rec(int n, int[] result) {
        if(n < 0){
            return 0;
        }

        if(result[n] > 0) {
            return result[n];
        }

        //Memoize
        result[n] = scoring_options_rec(n-3, result) +
                scoring_options_rec(n-5, result) +
                scoring_options_rec(n-10, result);

        return result[n];
    }

    public static int scoring_options(int n) {
//        if(n <= 0) {
//            return 0;
//        }
//
//        int[] result = new int[n+1];
//        result[0] = 1;
//
//        scoring_options_rec(n, result);
//
//        return result[n];

        int table[] = new int[n + 1], i;

        // Initialize all table values as 0
        Arrays.fill(table, 0);

        // Base case (If given value is 0)
        table[0] = 1;

        // One by one consider given 3
        // moves and update the table[]
        // values after the index greater
        // than or equal to the value of
        // the picked move
        for (i = 1; i <= n; i++)
            table[i] += table[i - 1];
        for (i = 2; i <= n; i++)
            table[i] += table[i - 2];
        for (i = 5; i <= n; i++)
            table[i] += table[i - 5];
//
        return table[n];
    }


    public static void main(String[] args) {
        System.out.println(scoring_options(7));
    }
}
