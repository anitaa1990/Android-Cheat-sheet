package arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedArrays
{


    /*
     * We are given two sorted array. We need to merge these two arrays such that the initial numbers (after complete sorting) are in the first array and the remaining numbers are in the second array. Extra space allowed in O(1).
     * Expected Time Complexity: O(m+n), where m is the number of elements in ar1[] and n is the number of elements in ar2[].
     * Input: ar1[] = {10},ar2[] = {2, 3}
     * Output: ar1[] = {2},ar2[] = {3, 10}
     *
    * Extra space allowed in O(1)
    * 1) Iterate through every element of ar2[] starting from last
         element. Do following for every element ar2[i]
        a) Store last element of ar1[i]: last = ar1[i]
        b) Loop from last element of ar1[] while element ar1[j] is
       smaller than ar2[i].
          ar1[j+1] = ar1[j] // Move element one position ahead
          j--
        c) If any element of ar1[] was moved or (j != m-1)
          ar1[j+1] = ar2[i]
          ar2[i] = last
     * */

    static int arr1[] = new int[]{1, 5, 9, 10, 15, 20};
    static int arr2[] = new int[]{2, 3, 8, 13};

    static void merge(int m, int n)
    {
        // Iterate through all elements of ar2[] starting from
        // the last element
        for (int i = n - 1; i >= 0; i--)
        {
            /* Find the smallest element greater than ar2[i]. Move all
               elements one position ahead till the smallest greater
               element is not found */
            int j, last = arr1[m - 1];
            for (j = m - 2; j >= 0 && arr1[j] > arr2[i]; j--)
                arr1[j + 1] = arr1[j];

            // If there was a greater element
            if (j != m - 2 || last > arr2[i])
            {
                arr1[j + 1] = arr2[i];
                arr2[i] = last;
            }
        }
    }

    // Driver method to test the above function
    public static void main(String[] args)
    {
        merge(arr1.length, arr2.length);
        System.out.print("After Merging nFirst Array: ");
        System.out.println(Arrays.toString(arr1));
        System.out.print("Second Array:  ");
        System.out.println(Arrays.toString(arr2));
    }
}
