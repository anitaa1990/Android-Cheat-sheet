package queue;

import java.util.ArrayDeque;

public class Dequeue {

    /*
     * Find Maximum in Sliding Window
     * Given a large array of integers and a window of size 'w',
     * find the current maximum in the window as the window slides through the entire array.
     * */


    /*
     * Eg: {-4, 2, -5, 3, 6}
     * Step 1: Iterate the first w elements of array;
     * Step 2: While the dequeue's last element is < current element. remove the dequeue's last element
     * Step 3: Add the current index to dequeue's tail
     * Step 4: Iterate from w till the array length
     * Step 5: While the dequeue's last element is < current element. remove the dequeue's last element
     * Step 6: Check if the dequeue's first element is <= i-window. If so, remove dequeue's first element
     * Step 7: Add the current index to dequeue's tail
     * Step 8: print the array value of dequeue's head
     * Time Complexity - Linear, O(n).
     * Memory Complexity - O(w) - where 'w' is the window size.
     * */


    /*
     * Why are we using ArrayDeque:
     * An ArrayDeque allows us to add or remove an element from both sides.
     * Better than LinkedList
     * ArrayDeque - performance is better. ArrayDeque is O(1) for add and remove on the front/end
     * (i.e. when used as a queue or stack) because it's a circular array and
     * so all objects are ordered next to each other in the array
     * linked list is expensive: because it uses memory to hold objects and to contain ‘links’ that point
     * to other objects (which slows down iteration)
     * */


    public static void findMaximumSlidingWindow(int[] arr,
                                                int windowSize) {
        if (arr.length < windowSize) return;

        ArrayDeque<Integer> list = new ArrayDeque();
        for (int i = 0; i < windowSize; i++) {

            while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
                list.removeLast();
            }
            list.addLast(i);
        }

        System.out.print(arr[list.peekFirst()] + " ");


        for (int i = windowSize; i < arr.length; i++) {

            while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
                list.removeLast();
            }

            if (!list.isEmpty() && list.peekFirst() <= i - windowSize) {
                list.removeFirst();
            }

            list.addLast(i);
            System.out.print(arr[list.peekFirst()] + " ");
        }
    }


    public static void main(String[] args) {
        int[] arr = {12, 1, 78, 90, 57, 89, 56};
        findMaximumSlidingWindow(arr, 3);
    }
}
