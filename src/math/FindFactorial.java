package math;

public class FindFactorial {

    public static int computeFactorial(int n) {
        int fact =1;

        for(int i=1; i<=n; i++) {
            fact = fact*i;
        }
        return fact;
    }


    public static void main(String[] args) {
        int n = 5;
        System.out.println(computeFactorial(n));
    }
}
