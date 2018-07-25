package backtracks;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {


    /*
     * Print all parentheses combinations for a given value n such that they are balanced.
     * Input: 3
     * Output: {{{}}}
     *         {{}{}}
     *         {{}}{}
     *         {}{{}}
     *         {}{}{}
     *
     * Runtime Complexity:
     * Exponential
     *
     * Memory Complexity:
     * Linear, O(n)
     *
     *
     * The solution is to maintain counts of left and right parentheses.
     * left parentheses count: 0
     * right parentheses count: 0
     *
     * if left parentheses count is less than n:
     *      add left parentheses and recurse further
     *
     * if right parentheses count is less than left parentheses count:
     *      add right parentheses and recurse further
     *
     * stop recursing when left and right counts are both equal to n
     *
     * */

    static void printList(List<Character> l) {
        for (Character c : l) {
            System.out.print(c);
        }
        System.out.println();
    }

    static void printAllParenthesesRec(int n,
                                       int left_count,
                                       int right_count,
                                       List<Character> output) {

        if (left_count >= n && right_count >=n) {
            printList(output);
        }

        if (left_count < n) {
            output.add('{');
            printAllParenthesesRec(
                    n, left_count + 1, right_count, output);
            output.remove(output.size() - 1);
        }

        if (right_count < left_count) {
            output.add('}');
            printAllParenthesesRec(
                    n, left_count, right_count + 1, output);
            output.remove(output.size() - 1);
        }
    }

    static void printAllParentheses(int n) {
        List<Character> output = new ArrayList<>();
        printAllParenthesesRec(n, 0, 0, output);
    }


    public static void main(String[] args) {
        printAllParentheses(3);
    }
}
