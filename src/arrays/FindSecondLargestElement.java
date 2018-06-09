package arrays;


public class FindSecondLargestElement {

    /*
     * Find second largest element in an array:
     * Input: {2, 3, 10, 6, 4, 8, 1}
     * Output: 8
     * */
    public static int findSecondHighestNo(int[] arr) {
        if(arr.length < 2) return -1;

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int value : arr) {
            if(value > first) {
                second = first;
                first = value;

            } else if(value > second && value != first) {
                second = value;
            }
        }
        return second;
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 6, 4, 8, 1};
        System.out.println(findSecondHighestNo(arr));
    }
}
