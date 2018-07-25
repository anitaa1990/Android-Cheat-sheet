package backtracks;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

    /*
     * Given a chess board of size N x N, determine how many ways N queens can be placed on this board
     * so that no two queens attack each other.
     *
     *
     * A queen can move horizontally, vertically and diagonally on a chess board.
     * One queen can be attacked by another queen if it is present in the same row, column, or diagonal
     * of that queen.
     *
     * Step 1: Place a queen in the first column of the first row
     * Step 2: Now place a queen in first such column of 2nd row where placement is permissible i.e.
     * current queen is not being attacked by any queen already on board. If no such column is found,
     * backtrack to the previous row and try to place the queen in next column of that row.
     * Step 3: Continue this until we reach the last row of the board.
     * Step 4: When a queen is placed in the last row, that is a solution.
     * After finding a solution, backtrack to the previous row to find the next solution.
     * Try to find another column in the previous row where placement is permissible.
     *
     *
     * Runtime Complexity:
     * Factorial, O(n!).
     *
     * Memory Complexity:
     * Exponential
     * */

    private static boolean isValidMove(int proposed_row,
                                       int proposed_col,
                                       List<Integer> solution) {

        for (int i = 0; i < proposed_row; ++i) {
            int old_row = i;
            int old_col = solution.get(i);

            int diagonal_offset = proposed_row - old_row;
            if (old_col == proposed_col ||
                    old_col == proposed_col - diagonal_offset ||
                    old_col == proposed_col + diagonal_offset) {
                return false;
            }
        }

        return true;
    }

    protected static void solveNQueensRec(int n,
                                          List<Integer> solution,
                                          int row,
                                          List<List<Integer>> results) {

        if (row == n) {
            results.add(new ArrayList<>(solution));
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (isValidMove(row, i, solution)) {
                solution.set(row, i);
                solveNQueensRec(n, solution, row + 1, results);
            }
        }
    }

    private static void solveNQueens(int n,
                                     List<List<Integer>> results) {

        List<Integer> solution = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            solution.add(-1);
        }
        solveNQueensRec(n, solution, 0, results);
    }

    public static void main(String[] args) {
        List<List<Integer>> results = new ArrayList<>();

        solveNQueens(8, results);
        System.out.println("Total Solutions Count: " + results.size());
        for (List<Integer> result : results) {
            for (Integer r : result) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
        System.out.println("Total Solutions Count = " + results.size());
    }

}
