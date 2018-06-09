package math;

public class CheckIfBinary {


    public static boolean isBinary(int n) {
        while (n> 0) {
            if(n % 10 > 1) return false;
            n = n/10;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 1010;
        System.out.println(isBinary(n));
    }
}
