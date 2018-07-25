package dynamicprogramming;

public class GameScoring {

    /*
     * Imagine a game (like cricket) where a player can score 1,2 or 4 runs.
     * Given a score "n", find the total number of ways score "n" can be reached.
     *
     * Runtime Complexity:
     * Linear, O(n)
     *
     * Memory Complexity:
     * Linear, O(n).
     *
     * Use the memoization technique:
     * Memoization is an optimization technique used to make programs faster and improve their performance
     * by storing the results of expensive function calls and returning the cached result when the same
     * inputs occur again. It saves the computed results for possible later reuse, rather than recomputing
     * them.
     *
     * The scoring options are 1, 2, 4. To find the number of ways a player can score 'n' runs,
     * the recurrence relation is as follows:
     * S(n) = S(n-1) + S(n-2) + S(n-4)S(n)=S(n−1)+S(n−2)+S(n−4)
     *
     *
     * */

    private static int scoringOptionsRec(int n, int[] result) {
        if(n < 0) return 0;

        if(result[n] > 0) return result[n];

        //Memoize
        result[n] = scoringOptionsRec(n-1, result) +
                scoringOptionsRec(n-2, result) +
                scoringOptionsRec(n-4, result);

        return result[n];
    }

    protected static int scoringOptions(int n) {
        if(n <= 0) return 0;

        int[] result = new int[n+1];
        result[0] = 1;

        scoringOptionsRec(n, result);
        return result[n];
    }


    public static void main(String[] args) {
        System.out.println( "Scoring Options(4): "+ scoringOptions(4)); //6
        System.out.println( "Scoring Options(5): "+ scoringOptions(5)); //10
    }
}
