package arrays;


import java.util.Arrays;

public class MoveZeroesToLeft {

    /*
     * Given an integer array, move all elements containing '0' to the left while maintaining the order of
     * other elements in the array.
     * */


    /*
     * Runtime Complexity = Linear, O(n).
     * Memory Complexity = Constant, O(1).
     *
     * Step 1: Keep two markers (readIndex and writeIndex) and point them to the end of the array
     * Step 2: If readIndex < 0, skip
     * Step 3: Iterate through the array in reverse, & if current element points to non zero,
     *         update the array current element to readindex element & increment writeIndex
     * */

    public static int[] moveZeroesToLeft(int[] arr) {

        int readIndex = arr.length-1;
        int writeIndex = arr.length-1;

        while (readIndex >= 0) {
            if(arr[readIndex] != 0) {
                arr[writeIndex] = arr[readIndex];
                writeIndex--;
            }
            readIndex--;
        }

        while (writeIndex >=0) {
            arr[writeIndex] = 0;
            writeIndex--;
        }

        return arr;
    }



    /*
     * Given an integer array, move all elements containing '0' to the right while maintaining the order of
     * other elements in the array.
     * */
    public static int[] moveZeroesToRight(int[] arr) {
        int readIndex = 0;
        int writeIndex = 0;

        while (readIndex <arr.length) {
            if(arr[readIndex] != 0) {
                arr[writeIndex] = arr[readIndex];
                writeIndex++;
            }
            readIndex++;
        }

        while (writeIndex < arr.length) {
            arr[writeIndex] = 0;
            writeIndex++;
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {1, 10, 20, 0, 59, 63, 0, 88, 0};
        System.out.println(Arrays.toString(moveZeroesToLeft(arr)));
        System.out.println(Arrays.toString(moveZeroesToRight(arr)));
    }
}
