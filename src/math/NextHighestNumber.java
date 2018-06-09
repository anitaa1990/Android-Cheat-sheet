package math;


public class NextHighestNumber {

    /*
     * Given a number, find the next higher number which has the exact same set of digits as the original number
     * Input: 1234
     * Output: 1243
     *
     * Step 1) Iterate the array from the right side, find the digit which is greater than the digit on the left side. - (a)
     * Step 2) If it is zero, then we can assume that there are no permutations available
     * Step 3) Iterate through the array from the left side, find the next digit after (a) which is greater than arr[(a)-1] and is less than arr[(a)]
     * Step 4) Swap these values
     *
     * */
    public static Integer findNextHighestNumber(int num) {

        char[] c = String.valueOf(num).toCharArray();

        int a = 0;
        int length = c.length;

        for (int i = length - 1; i > 0; i--) {
            if (c[i] > c[i - 1]) {
                a = i;
                break;
            }
        }

        if (a == 0) return num;

        int number = c[a - 1];
        int min = a;

        for (int i = a + 1; i < length; i++) {
            if (c[i] > number && c[i] < c[min]) {
                min = i;
            }
        }

        char temp = c[a - 1];
        c[a - 1] = c[min];
        c[min] = temp;

        return Integer.valueOf(new String(c));
    }


    public static void main(String[] args) {
        int n = 1234;
        System.out.println(findNextHighestNumber(n));
    }
}
