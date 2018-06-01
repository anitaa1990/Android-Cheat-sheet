package sort;

import java.util.Arrays;

public class MergeSort {

    /*
     * Merge sort uses divide & conquer method by splitting the array into smaller parts until there is only one element.
     * The elements are then compared and sorted and merged.
     * Split the arr into half by finding the median.
     * Call mergeSort on the first half and mergeSort on the second half. Then merge the two halves.
     * The time complexity of merge sort is always O(n log n): in all 3 cases (worst, average and best) as merge sort
     * always divides the array in two halves and take linear time to merge two halves.
     * */
    public static int[] mergeSort(int[] arr, int lowerIndex, int upperIndex) {
        if(arr.length == 1) return arr;
        if(lowerIndex >= upperIndex) return arr;

        int median = (lowerIndex + upperIndex)/2;
        mergeSort(arr, lowerIndex, median);
        mergeSort(arr, median+1, upperIndex);
        merge(arr, lowerIndex, median, upperIndex);

        return arr;
    }

    public static int[] merge(int[]arr, int lowerIndex, int median, int upperIndex) {
        int[] tempArr = new int[arr.length];

        for(int i=0; i<= upperIndex; i++) {
            tempArr[i] = arr[i];
        }

        int i = lowerIndex;
        int j = median+1;
        int k = lowerIndex;

        while (i <= median && j<= upperIndex) {
            if(tempArr[i] < tempArr[j]) {
                arr[k] = tempArr[i];
                i++;

            } else {
                arr[k] = tempArr[j];
                j++;
            }
            k++;
        }

        while (i<= median) {
            arr[k] = tempArr[i];
            i++;
            k++;
        }

        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {55, 23, 26, 2, 25};
        System.out.print(Arrays.toString(mergeSort(arr, 0, arr.length-1)));
    }
}
