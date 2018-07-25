package dynamicprogramming;


public class CoinChangingProblem {

    /*
     * Given coin denominations and the total amount, find out the number​ of ways to make the change.
     * Denominations: 1, 2, 5
     * Amount: 7
     * Total Methods: 6
     *
     * Runtime Complexity:
     * O(m n) where m is number of denominations and n is amount.
     *
     * Memory Complexity:
     * Linear, O(n) where n is the amount.
     *
     * Dynamic programming is a problem solving approach which is used when naive approach results in
     * exponential time complexity. To apply dynamic programming approach, the problem to be solved must
     * have optimal substructure i.e. optimal solution of the problem at hand could be achieved by
     * leveraging the optimal solutions of its subproblems and overlapping sub-problems i.e. using
     * pre-computed values for solved sub-problems so that we don't have to solve them again.
     * The coin changing problem has both optimal substructure i.e it can be easily divided to simpler
     * problems and they can be solved to find final solution and it also satisfies the property of
     * overlapping sub problems i.e. previously solved sub problem results can be used multiple times.
     *
     *
     * */
    protected static int solveCoinChangeDp(int[] denominations,
                                           int amount) {


        int[] solution = new int[amount + 1];
        solution[0] = 1;

        for (int den : denominations) {
            for (int i = den; i < (amount + 1); ++i) {
                solution[i] += solution[i - den];
            }
        }
        return solution[solution.length - 1];
    }


    public static void main(String[] args) {
        int[] denominations = new int[]{1, 5, 10};
        System.out.println("Combinations (DP): " + solveCoinChangeDp(denominations, 356));
    }
}
