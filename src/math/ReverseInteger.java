package math;


public class ReverseInteger {

    /*
     * Given a integer
     * Input - 4321
     * Output - 1234
     * */

    public static int reverseInteger(int n) {
        int reverse = 0;
        while(n != 0) {
            reverse = reverse * 10;
            reverse = reverse + (n%10);
            n = n/10;
        }
        return reverse;
    }


    public static void main(String[] args) {
        int n = 4321;
        System.out.println(reverseInteger(n));
    }
}
