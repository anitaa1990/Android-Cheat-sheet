package strings;


public class NextHighestPermutation {

    /*
     * Find next highest permutation of a given string.
     * Input: "abbc"
     * Output: "abcb"
     * Follow same logic as finding the next Highest integer from a given integer
     * */
    public static String permutateString(String s) {
        char[] c = s.toCharArray();

        int a = 0;
        int n = c.length;
        for(int i=n-1; i>0; i--) {
            if(c[i] > c[i-1]) {
                a = i;
                break;
            }
        }

        if(a == 0) return "No permutations";

        int num = c[a-1];
        int min = a;
        for(int i=a+1; i<n; i++) {
            if(c[i] > num && c[i] < c[min]) {
                min = i;
            }
        }

        char temp = c[min];
        c[min] = c[a-1];
        c[a-1] = temp;

        return new String(c);
    }



    public static void main(String[] args) {
        String input = "abbc";
        System.out.println(permutateString(input));
    }
}
