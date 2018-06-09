package math;

import java.util.HashSet;
import java.util.Set;

public class FindPrimeFactors {

    public static Set<Integer> findPrimeFactors(int num) {
        Set<Integer> primeFactors = new HashSet<>();

        long temp = num;
        for(int i=2; i<=temp; i++) {
            if(temp %i == 0) {
                primeFactors.add(i);
                temp /= i;
                i--;
            }
        }

        return primeFactors;
    }


    public static void main(String[] args) {
        int n = 15;
        System.out.println(findPrimeFactors(n));
    }
}
