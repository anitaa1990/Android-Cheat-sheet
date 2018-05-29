package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {


    public static List<Integer> rotateArray(List<Integer> arr, int rotations) {
        int length = arr.size();
        rotations = rotations % length;
        if(rotations < 0) {
            rotations = rotations+length;
        }

        /*
         * Step 1: copy all the values included in the rotation.
         * For eg: if rotation = 2, the copy last 2 values into temp array
         * */
        List<Integer> tempList = new ArrayList<>();
        for(int i=(length-rotations); i<length; i++) {
            tempList.add(arr.get(i));
        }


        /*
         * Step 2: shift all values not included in the rotation to the end of the array.
         * For eg: if rotation = 7, then shift length-rotation i.e 10-7 = 3 values to the end of the array
         * */
        for(int i=length-1; i>= rotations; i--) {
            arr.set(i, arr.get(i-rotations));
        }

        for(int i=0; i<rotations; i++) {
            arr.set(i, tempList.get(i));
        }

        return arr;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, 4, 5};
        System.out.println(rotateArray(Arrays.asList(arr1), 2));
    }
}
