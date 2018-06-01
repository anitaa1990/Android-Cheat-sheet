package search;


public class TernarySearch {

    /*
     * Ternary Search using recursion
     * Time complexity - Olog(n)
     * Memory Complexity - O(logn) - as it will consume memory on the stack
     * */
    public static int ternarySearch(int n, int[] arr, int lowerIndex, int upperIndex) {
        if(n < arr[lowerIndex] || n > arr[upperIndex]) return -1;

        int median = (upperIndex - lowerIndex) / 3;
        int med1 = lowerIndex + median;
        int med2 = upperIndex - median;

        if(arr[med1] == n) return med1;
        if(arr[med2] == n) return med2;

        if(arr[med1] < n) return ternarySearch(n, arr, med1+1, upperIndex);
        if(arr[med2] > n) return ternarySearch(n, arr, lowerIndex, med2-1);

        return -1;
    }



    public static void main(String[] args) {
        int[] arr = {1,11,23,34,45,56,67,78,89,90};
        int n = 90;
        System.out.println(ternarySearch(n, arr, 0, arr.length-1));
    }
}
