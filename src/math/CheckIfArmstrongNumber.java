package math;

public class CheckIfArmstrongNumber {

    public static boolean checkIfArmstrongNumber(int num) {
        int a = 0;
        int c = 0;
        int temp = num;

        while (num > 0) {
            a = num%10;
            num = num/10;
            c = c + (a*a*a);
        }
        return (c == temp);
    }


    public static void main(String[] args) {
        int n = 1234;
        System.out.println(checkIfArmstrongNumber(n));
    }
}
