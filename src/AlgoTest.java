import java.util.*;

public class AlgoTest {

    public static void main(String[] args) {
//        int[] arr = {-2, -3, -3, -1, -2, -1, -5, -3};

//        //answer should be: 7
//        System.out.println(findMaxSubArray(arr.length, arr));
//
//        System.out.println(isBalanced("{()}[]"));

//        int[] arr2 = {1,2,3,4,5};
//        findMinMaxSum(arr2);

//        int[] arr3 = {4, 73, 67, 38, 33};
//        System.out.println(Arrays.toString(gradingStudents(arr3)));

//        System.out.println(calculateLCM(3, 2));
//        System.out.println(kangaroo(21, 6, 47, 3));

//        String s = "haveaniceday";
//        double value = Math.sqrt(s.length());

    }






    /* Kandane's Algorithm */
    public static int findMaxSubArray(int length, int[] arr) {

        int max_so_far = 0;
        int max_at_end = 0;

        for(int i=0; i<length; i++) {
            max_at_end = Math.max(0, max_at_end + arr[i]);
            max_so_far = Math.max(max_so_far, max_at_end);
        }
        return max_so_far;
    }


    /* Check if an expression is balanced */
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack();

        for(char c: s.toCharArray()) {
            if(c == '[' || c =='{' || c == '(') {
                stack.push(c);

            } else if(c == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;

            } else if(c == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;

            } else if(c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            }
        }
        return true;
    }


    public static void findMinMaxSum(int[] arr) {
        long sum = 0;
        long maxSum = 0;
        long minSum = Long.MAX_VALUE;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] < minSum) {
                minSum = arr[i];
            }
            if(arr[i] > maxSum) {
                maxSum = arr[i];
            }
            sum+= arr[i];
        }
        System.out.print((sum - maxSum) + " " + (sum - minSum));
    }


    //https://www.hackerrank.com/challenges/birthday-cake-candles
    static int birthdayCakeCandles(int n, int[] arr) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0; i<n; i++) {
            if(max < arr[i]) {
                max = arr[i];
                count = 1;
            }
            else if(max == arr[i]) {
                count++;
            }
        }
        return count;
    }

    /* https://www.hackerrank.com/challenges/grading/problem */
    static int[] gradingStudents(int[] grades) {
        List<Integer> arr = new ArrayList();
        for(int grade: grades) {
            int nextHighestMultiple = (5 *(grade/5))+5;
            int diff = nextHighestMultiple - grade;
            int newValue = (diff >= 3) || (grade <  38) ? grade : nextHighestMultiple;
            arr.add(newValue);
        }
        return toIntArray(arr);
    }




    private static int[] toIntArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        int i = 0;
        for (Integer e : list) {
            ret[i++] = e.intValue();
        }
        return ret;
    }



    /* https://www.hackerrank.com/challenges/apple-and-orange/problem */
    private static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int appleCount=0, orangeCount = 0;
        for(int apple: apples) {
            int distance = a + apple;
            if(distance >= s && distance <= t) {
                appleCount++;
            }
        }

        for(int orange: oranges) {
            int distance = b + orange;
            if(distance >= s && distance <= t) {
                orangeCount++;
            }
        }
        System.out.println(appleCount + "\n" + orangeCount);
    }


    private static int calculateGCM(int a, int b) {
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        while((max-min) != 0) {
            int diff = max-min;
            if(diff < min) {
                min = diff;
            } else  {
                max = diff;
            }
        }
        return max;
    }

    private static int calculateLCM(int a, int b) {
        //lcm(a, b) = a × b / gcd(a, b).
        int gcm = calculateGCM(a,b);
        int lcm = (a*b)/gcm;
        return lcm;
    }

    /* https://www.hackerrank.com/challenges/kangaroo/problem */
    static String kangaroo(int x1, int v1, int x2, int v2) {
        String result = "YES";
        double possibleMeetingValue = (double) (x2-x1)/(v1-v2);
        if( possibleMeetingValue<=0 || (possibleMeetingValue % 1 != 0 ) )
            result = "NO";

        return result;
    }
}
