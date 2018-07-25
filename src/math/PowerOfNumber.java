package math;

import java.math.BigDecimal;

public class PowerOfNumber {


    /*
     * Given a double 'x' and an integer 'n'. Write a function to calculate 'x' raised to the power 'n'.
     * Eg: power (2, 5) = 32
     * power (3, 4) = 81
     * power (1.5, 3) = 3.375
     * power (2, -2) = 0.25
     *
     * Runtime Complexity:
     * Logarithmic, O(logn)
     *
     * Memory Complexity:
     * Logarithmic, O(log n)
     *
     * A simple algorithm of this problem is to multiply 'x' by 'n' times.
     *
     * */

    private static double powerRec(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        double temp = powerRec(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }

    protected static double power(double x, int n) {
        boolean is_negative = false;
        if (n < 0) {
            is_negative = true;
            n *= -1;
        }

        double result = powerRec(x, n);

        if (is_negative) {
            return 1 / result;
        }

        return result;
    }


    protected static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }


    protected static double round(double value) {
        return round(value, 6);
    }


    public static void main(String[] args) {
        int n = 6;
        int k = 6;

        double r1 = round(power(round(n), k));
        double r2 = round(Math.pow(round(n), k));
        double diff = r1 - r2;
        if (diff < 0) {
            diff = diff * -1;
        }
        if (diff > 0.0000000001) {
            String msg = String.format("r1 = %f, r2 = %f, difference = %f", r1, r2, diff);
            System.out.println("Failed for (" + n + ", " + k + ") " + msg);
        }
        System.out.println(diff > 0.0000000001);
    }
}
