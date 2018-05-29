package dynamicprogramming;

import java.util.Arrays;

public class FibonacciSeries {


    /*
     * Find the nth fibonacci number.
     * Input: 10
     * Output: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
     *
     * Fibonacci series are the sum of the previous two numbers i.e. Fib(N): Fib(N-1) + Fib(N-2), for N >= 2
     * */

    public static int[] getFibonacciNumbers(int n) {
        int one = 0;
        int two = 1;

        int[] result = new int[n];
        result[0] = one;
        result[1] = two;
        for(int i=2; i<n; i++) {
            result[i] = two + one;
            one = two;
            two = result[i];
        }

        return result;
    }



    public static void main(String[] args) {
        int n = 10;
        System.out.println(Arrays.toString(getFibonacciNumbers(n)));
    }
}
