package search;


public class BinarySearch {


    /*
     * Binary Search using recursion
     * Time complexity - Olog(n)
     * Memory Complexity - O(logn) - as it will consume memory on the stack
     * */
    private static int recursiveBinarySearch(int[]arr, int n, int low, int high) {
        if(low > high) {
            return - 1;
        }

        int middle = low + ((high-low)/2);
        if(arr[middle] == n) return middle;

        else if(n > arr[middle]) {
            return recursiveBinarySearch(arr, n, middle+1, high);

        } else return recursiveBinarySearch(arr, n, low, middle-1);
    }



    /*
     * Binary Search using iteration
     * Time complexity - Olog(n)
     * Memory Complexity - Constant, O(1)
     * */
    private static int iterativeBinarySearch(int[]arr, int n, int low, int high) {
        while (low <= high) {
            int middle = low + ((high-low)/2);
            if(arr[middle] == n) return middle;

            if(n > arr[middle]) {
                low = middle+1;
            } else {
                high = middle-1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1,11,23,34,45,56,67,78,89,90};
        int n = 90;
        System.out.println(recursiveBinarySearch(arr, n, 0, arr.length-1));
        System.out.println(iterativeBinarySearch(arr, n, 0, arr.length-1));
    }
}
