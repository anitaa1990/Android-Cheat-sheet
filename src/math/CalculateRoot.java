package math;

public class CalculateRoot {


    /*
     *
     * Given a double number, write a function to calculate its square root.
     * Eg: Square root of 16 is 4 (4 x 4 = 16)
     *
     * Runtime Complexity:
     * Logarithmic, O(logn)
     *
     * Memory Complexity:
     * Constant, O(1)
     *
     * Set low = 0 and high = 1 + n / 2
     *   while True:
	 *              mid = (low + high) / 2
	 *               square = mid * mid
     *               If square is equal to 'n' then
     *                       return mid (mid is the square root)
     *               Else If square is less than n:
     *                       low = mid (square root lies in upper half i.e. between mid and high)
     *               Else If square is greater than n then
     *               high = mid (square root lies in lower half i.e. between low and mid)
     *
     * */

    private static final double EPSILON = 0.00001;

    protected static double squareRootIterative(double num) {
        double low = 0;


        // square root can never be more than
        // half of number except if number is <= 1
        // so square root of any number always lie
        // between 0 and 1 + (num / 2)
        double high = 1 + num / 2;

        while (low < high) {

            double mid = (low + high) / 2;
            double sqr = mid * mid;

            // we can't do a == b for doubles because
            // of rounding errors, so we use error threshold
            // EPSILON. Two doubles a and b are equal if
            //  abs(a-b) <= EPSILON

            double diff = Math.abs(num - sqr);

            if (diff <= EPSILON) {
                return mid;
            }

            if (sqr < num) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int x = 100;
        double res1 = squareRootIterative(x);
        System.out.println("Square Root: " + res1);
    }
}
