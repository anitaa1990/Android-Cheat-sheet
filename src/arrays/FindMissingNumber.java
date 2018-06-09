package arrays;

public class FindMissingNumber {

    /*
     * Find missing numbers from an array
     * */
    public static int findMissingNumbers(int[] arr, int count) {

        int i, total;
        total  = (count+1)*(count+2)/2;
        for ( i = 0; i< count; i++) {
            total -= arr[i];
        }
        return total;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 4,6, 3, 7, 8};
        System.out.println(findMissingNumbers(arr, arr.length));
    }
}
