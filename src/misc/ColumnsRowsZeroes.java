package misc;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ColumnsRowsZeroes {


    /*
     * Given a two dimensional array, if any element in it is zero make its whole row and column zero.
     *
     *
     * There are two zeros in the input matrix i.e. at position (2,2) and (3,4).
     * Output of this should be a matrix in which 2nd and 3rd row becomes zero and 2nd and fourth columns
     * become zeros.
     *
     *
     * */


    private static void makeZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        Set<Integer> zero_rows = new HashSet<>();
        Set<Integer> zero_cols = new HashSet<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j] == 0) {
                    if (!zero_rows.contains(i)) {
                        zero_rows.add(i);
                    }

                    if (!zero_cols.contains(j)) {
                        zero_cols.add(j);
                    }
                }
            }
        }

        for (int r : zero_rows) {
            for (int c = 0; c < cols; ++c) {
                matrix[r][c] = 0;
            }
        }

        for (int c : zero_cols) {
            for (int r = 0; r < rows; ++r) {
                matrix[r][c] = 0;
            }
        }
    }

    private static int[][] createRandomMatrix(int rows, int cols) {
        int[][] v = new int[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                int t = new Random().nextInt() % 100;
                v[i][j] = t + 1;
                if (Math.abs(t) % 100 <= 5) {
                    v[i][j] = 0;
                }
            }
        }
        return v;
    }


    private static void printMatrix(int[][] m) {
        System.out.println();
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m[i].length; ++j) {
                System.out.print(m[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    private static boolean isRowOrColZero(int[][] matrix, int r, int c) {
        int rows = matrix.length;
        int cols = 0;
        if (rows > 0) {
            cols = matrix[0].length;
        }

        for (int i = 0; i < cols; ++i) {
            if (matrix[r][i] == 0) {
                return true;
            }
        }

        for (int i = 0; i < rows; ++i) {
            if (matrix[i][c] == 0) {
                return true;
            }
        }

        return false;
    }


    private static void verify(int[][] matrix) {
        int[][] mat_copy = new int[matrix.length][];
        for (int i = 0; i < matrix.length; ++i) {
            mat_copy[i] = matrix[i].clone();
        }

        makeZeroes(matrix);

        int rows = matrix.length;
        int cols = 0;
        if (rows > 0) {
            cols = matrix[0].length;
        }

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (isRowOrColZero(mat_copy, i, j)) {
                    assert (matrix[i][j] == 0);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 45, 0, 81},
                {6, 7, 2, 82, 8},
                {20, 22, 49, 5, 5},
                {0, 23, 50, 4, 92}
        };

        verify(matrix);

        matrix = createRandomMatrix(5, 5);
        printMatrix(matrix);
        verify(matrix);
        printMatrix(matrix);

        for (int i = 0; i < 250; i += 10) {
            for (int j = 0; j < 250; j += 10) {
                matrix = createRandomMatrix(i, j);
                verify(matrix);
            }
        }
    }

}
