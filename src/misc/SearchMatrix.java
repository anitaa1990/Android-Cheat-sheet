package misc;

public class SearchMatrix {

    /*
     * Search (find position of) a given key in 2D matrix. All rows and columns are sorted.
     *
     * Runtime Complexity:
     * Linear, O(m+n) where 'm' is number of rows and 'n' is number of columns.
     *
     * Memory Complexity:
     * Constant, O(1).
     *
     *
     * */
    protected static class Pair<K, V> {

        private K first;
        private V second;

        public static <K, V> Pair<K, V> createPair(K element0, V element1) {
            return new Pair<K, V>(element0, element1);
        }

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        public K getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }

    }


    protected static Pair searchInMatrix(int matrix[][],
                                         int value) {

        int M = matrix.length; //rows
        int N = matrix[0].length; // columns

        // Let's start searching from top right.
        // Alternatively, searching from bottom left
        // i.e. matrix[M-1][0] can also work.

        int i = 0, j = N - 1;

        while (i < M && j >= 0) {
            if (matrix[i][j] == value) {
                return new Pair(i, j);
            } else if (value < matrix[i][j]) {
                // search left
                --j;
            } else {
                // search down.
                ++i;
            }
        }

        return new Pair(-1, -1);
    }


    protected static void verifySearch(int[][] matrix) {

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {

                System.out.println("Verifying at " + i + ", " + j);
                Pair val_loc = searchInMatrix(matrix, matrix[i][j]);
                assert ((int) val_loc.first == i);
                assert ((int) val_loc.second == j);
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 5, 45, 80, 81},
                {6, 7, 48, 82, 83},
                {20, 22, 49, 85, 86},
                {21, 23, 50, 90, 92}
        };

        verifySearch(matrix);
    }
}
