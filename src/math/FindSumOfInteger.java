package math;

public class FindSumOfInteger {


    public static int findSumOfDigits(int num) {
        return num == 0 ? 0 : (num%10) + findSumOfDigits(num/10) ;
    }



    public static void main(String[] args) {
        int n = 4321;
        System.out.println(findSumOfDigits(n));
    }
}
