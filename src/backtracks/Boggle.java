package backtracks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Boggle {

    /*
     * Given an NxN grid of characters and a dictionary, find all words which can be made from the characters
     * in grid and present in the given dictionary. A word can start and end at any character in the grid.
     * Next character must be adjacent to previous character in any of the directions i.e. up, down, left,
     * right and diagonal. Character at each position in grid can be used only once while making a word.
     * Sample:
     *      char[][] grid = new char[][] {
     *          {'c', 'a', 't'},
     *          {'r', 'r', 'e'},
     *          {'t', 'o', 'n'}
     *      };
     *
     *
     *  Runtime Complexity:
     *  Exponential, O(Nn).
     *  where 'N' is the dimension of the grid.
     *
     *  Memory Complexity:
     *  Quadratic, O(N2).
     *  where 'N' is the dimension of the grid. Recursive solution will consume memory on the stack as well.
     *
     *  As every character from the grid can appear only once in a word, so we need to maintain a boolean matrix to indicate if the
     *  corresponding character in grid is used to make this word.
     *
     * */

    char[][] grid;
    boolean[][] state;
    Set<String> dictionary;

    private List<Pair> findAllNumbers(int x, int y) {
        List<Pair> numbers = new ArrayList<>();

        int start_x = Math.max(0, x - 1);
        int start_y = Math.max(0, y - 1);
        int end_x = Math.min(grid.length - 1, x + 1);
        int end_y = Math.min(grid.length - 1, y + 1);

        for (int i = start_x; i <= end_x; ++i) {
            for (int j = start_y; j <= end_y; ++j) {
                if (state[i][j]) {
                    continue;
                }
                numbers.add(new Pair(i, j));
            }
        }
        return numbers;
    }

    void findWordsRec(int i, int j,
                      StringBuilder current,
                      HashSet<String> words) {

        if (current.length() > 0 && dictionary.contains(current.toString())) {
            words.add(current.toString());
        }


        List<Pair> nbrs = findAllNumbers(i, j);
        for (Pair pr : nbrs) {

            current.append(grid[(int) pr.first][(int) pr.second]);
            state[(int) pr.first][(int) pr.second] = true;

            findWordsRec((int) pr.first, (int) pr.second, current, words);
            current.setLength(current.length() - 1);

            state[(int) pr.first][(int) pr.second] = false;
        }
    }

    private Boggle(char[][] g,
                   HashSet<String> d) {
        grid = g;
        dictionary = d;
        state = new boolean[g.length][g.length];
        for (int i = 0; i < g.length; ++i) {
            for (int j = 0; j < g.length; ++j) {
                state[i][j] = false;
            }
        }
    }


    public HashSet<String> findAllWords() {
        HashSet<String> words = new HashSet<>();
        StringBuilder current_word = new StringBuilder();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid.length; ++j) {
                findWordsRec(i, j, current_word, words);
            }
        }

        return words;
    }


    protected static class Pair<K, V> {

        private K first;
        private V second;

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


    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'c', 'a', 't'},
                {'r', 'r', 'e'},
                {'t', 'o', 'n'}
        };

        HashSet<String> dictionary = new HashSet<String>();
        dictionary.add("art");
        dictionary.add("cat");
        dictionary.add("cater");
        dictionary.add("cartoon");
        dictionary.add("toon");
        dictionary.add("moon");
        dictionary.add("not");
        dictionary.add("apple");
        dictionary.add("ton");

        Boggle b = new Boggle(grid, dictionary);
        HashSet<String> words = b.findAllWords();
        for (String s : words) {
            System.out.println(s);
        }
    }
}
