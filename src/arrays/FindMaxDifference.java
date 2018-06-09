package arrays;


public class FindMaxDifference {

    /*
     * Find the maximum difference between the values in an array such that the largest values always comes after the
     * smallest value
     * Input: {2, 3, 10, 6, 4, 8, 1}
     * Output: 8
     *  Step 1) Set min value as arr[0] -> a
     *  Step 2) set max difference as arr[1] - arr[0]; -> b
     *  Step 3) Iterate and check if the value is > minValue.
     *  Step 4) If it is greater, then get the difference between the two values & check if the difference > max difference (b). If the difference is > set this diff as max difference
     *  Step 5) If it is less than minValue, set this value as minValue
     * */
    public static int findMaxDistance(int[] arr) {

        if(arr.length == 1) return arr[0];

        int maxDiff = arr[1] - arr[0];
        int minValue = arr[0];

        for(int value : arr) {
            if(value < minValue) {
                minValue = value;
            } else {
                int diff = value - minValue;
                if(diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }

        return maxDiff;
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 6, 4, 8, 1};
        System.out.println(findMaxDistance(arr));
    }
}
