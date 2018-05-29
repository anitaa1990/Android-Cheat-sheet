package stacks;

import java.util.ArrayDeque;
import java.util.Queue;

public class StacksUsingQueues {



    /*
     * Implement a stack using Queues.
     * */
    /*
     * A stack is a data structure in which objects are inserted and removed according to the LIFO(Last In First Out)
     * principle. An item is added at the top of the stack and removed from the top as well. push means to insert an item
     * at the top of the stack and pop means to remove an item from the top of the stack.
     *
     * A queue is a data structure in which objects are inserted and removed according to the FIFO(First In First Out)
     * principle. An item is added at the back of the queue and removed from the front. enqueue means to insert an item
     * at the back of the queue and dequeue means to remove an item from the front of the queue.
     *
     * Runtime Complexity
     * push(): Constant, O(1).
     * pop(): Linear, O(n).
     * Memory Complexity - Linear, O(n).
     * */


    public static void main(String[] args) throws Exception {
        StackUsingQueuesWithFasterPush stackUsingQueuesWithFasterPush = new StackUsingQueuesWithFasterPush();
        stackUsingQueuesWithFasterPush.push(3);  // q1 will have 3
        stackUsingQueuesWithFasterPush.push(5);  // q1 will have 3,5
        stackUsingQueuesWithFasterPush.push(9);  // q1 will have 3,5,9
        stackUsingQueuesWithFasterPush.pop();  // q1 will have 3,5
        System.out.println(stackUsingQueuesWithFasterPush.queue1 + "###" + stackUsingQueuesWithFasterPush.queue2);
        stackUsingQueuesWithFasterPush.push(10);  // q1 will have 3,5,10
        stackUsingQueuesWithFasterPush.push(16);  // q1 will have 3,5,10,16
        System.out.println(stackUsingQueuesWithFasterPush.pop());  // q1 will have 3,5,10, pop returns 16
        System.out.println(stackUsingQueuesWithFasterPush.queue1 + "###" + stackUsingQueuesWithFasterPush.queue2);


        StackUsingQueueWithFasterPop stackUsingQueueWithFasterPop = new StackUsingQueueWithFasterPop();
        stackUsingQueueWithFasterPop.push(3);  // q1 will have 3
        stackUsingQueueWithFasterPop.push(5);  // q1 will have 3,5
        stackUsingQueueWithFasterPop.push(9);  // q1 will have 3,5,9
        stackUsingQueueWithFasterPop.pop();  // q1 will have 3,5
        System.out.println(stackUsingQueueWithFasterPop.queue1 + "###" + stackUsingQueueWithFasterPop.queue2);
        stackUsingQueueWithFasterPop.push(10);  // q1 will have 3,5,10
        stackUsingQueueWithFasterPop.push(16);  // q1 will have 3,5,10,16
        System.out.println(stackUsingQueueWithFasterPop.pop());  // q1 will have 3,5,10, pop returns 16
        System.out.println(stackUsingQueueWithFasterPop.queue1 + "###" + stackUsingQueueWithFasterPop.queue2);
    }

}



/*
 * push():  Always enqueue on queue1
 * pop():
    If stack size is 0, throw exception.
    If queue1 has element(s), dequeue all elements from queue1 and enqueue on queue2 except the last element.
    The last element found above will be returned but before that swap queue1 and queue2 references.
 *
 * This solution will make the push operation faster.
 * */
class StackUsingQueuesWithFasterPush {

    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();
    public void push(int data) {
        queue1.add(data);
    }

    public boolean isEmpty() {
        return queue1.size() + queue2.size() == 0;
    }

    public int pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("Stack is empty");
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        int value = queue1.remove();
        swapQueues();

        return value;
    }


    public void swapQueues() {
        Queue<Integer> queue3 = queue1;
        queue1 = queue2;
        queue2 = queue3;
    }
}




/*
 * This solution will make the 'pop' operation faster.
 * push():
 * If queue1 is empty, then enqueue on queue1.
 * Otherwise
 *      enqueue on queue2 and dequeue all elements from queue1 and push them on queue2.
 *      Then swap the queue references.
 * pop():
 *       If stack size is 0, throw exception.
 *       Dequeue from queue1 and return.
 * */
class StackUsingQueueWithFasterPop {
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();

    public void push(int data) {
        if(queue1.isEmpty()) {
            queue1.add(data);

        } else {
            queue2.add(data);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }
            swapQueues();
        }
    }

    public boolean isEmpty() {
        return queue1.size() + queue2.size() == 0;
    }

    public int pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("Stack is empty!");
        }

        return queue1.remove();
    }

    public void swapQueues() {
        Queue<Integer> queue3 = queue1;
        queue1 = queue2;
        queue2 = queue3;
    }

}
