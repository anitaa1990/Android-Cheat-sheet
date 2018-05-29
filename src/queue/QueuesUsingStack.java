package queue;

import java.util.Stack;

public class QueuesUsingStack {


    /*
     * Implement a queue using stack.
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
     * enqueue(): Constant, O(1).
     * dequeue(): Linear, O(n).
     * Memory Complexity - Linear, O(n).
     * */

    public static void main(String[] args) throws Exception {
        QueueUsingStackWithFasterEnqueue queueUsingStackWithFasterEnqueue = new QueueUsingStackWithFasterEnqueue();
        queueUsingStackWithFasterEnqueue.enqueue(3);
        queueUsingStackWithFasterEnqueue.enqueue(6);
        queueUsingStackWithFasterEnqueue.enqueue(10);
        queueUsingStackWithFasterEnqueue.dequeue();
        System.out.println(queueUsingStackWithFasterEnqueue.stack1 + "###" + queueUsingStackWithFasterEnqueue.stack2);


        queueUsingStackWithFasterEnqueue.enqueue(8);
        queueUsingStackWithFasterEnqueue.enqueue(4);
        queueUsingStackWithFasterEnqueue.dequeue();
        System.out.println(queueUsingStackWithFasterEnqueue.stack1 + "###" + queueUsingStackWithFasterEnqueue.stack2);


        /*  Faster Dequeue  */
        QueueUsingStackWithFasterDequeue queueUsingStackWithFasterDequeue = new QueueUsingStackWithFasterDequeue();
        queueUsingStackWithFasterDequeue.enqueue(3);  //q1 = 3
        queueUsingStackWithFasterDequeue.enqueue(6);  //q1 = 6,3
        queueUsingStackWithFasterDequeue.enqueue(10); //q1 = 10,6,3
        System.out.println(queueUsingStackWithFasterDequeue.dequeue()); //q1 = 10,6     3 is removed
        System.out.println(queueUsingStackWithFasterDequeue.stack1 + "###" + queueUsingStackWithFasterDequeue.stack2);


        queueUsingStackWithFasterDequeue.enqueue(8);     //q1 = 8,10,6
        queueUsingStackWithFasterDequeue.enqueue(4);     //q1 = 4, 8,10,6
        System.out.println(queueUsingStackWithFasterDequeue.dequeue());          //q1 = 4,8,10      6 is removed
        System.out.println(queueUsingStackWithFasterDequeue.stack1 + "###" + queueUsingStackWithFasterDequeue.stack2);

    }
}


    /*
     * enqueue(): Always push on stack1
     * dequeue():
     *      If queue size is 0, throw exception.
     *      If stack2 has element(s), pop the topmost and return.
     *      Otherwise If stack1 is non empty, pop all elements from stack1 and push them in stack2.
     *      At the end pop stack2's top most element and return.
     * */

class QueueUsingStackWithFasterEnqueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();


    public void enqueue(int data) {
        stack1.push(data);
    }

    public boolean isEmpty() {
        return stack1.size() + stack2.size() == 0;
    }

    public int dequeue() throws Exception {
        if(isEmpty()) {
            throw new Exception("Queue is empty!");
        }

        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}



    /*
     * enqueue():
     *      Pop each element from stack1 and push it to stack2.
     *      Push item being enqueued to stack1.
     *      Pop each element back from stack2 and push it to stack1.
     * dequeue():
     *      If queue size is 0, throw exception.
     *      Pop from stack1 and return.
     * */
    class QueueUsingStackWithFasterDequeue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();


        public boolean isEmpty() {
            return stack1.size() + stack2.size() == 0;
        }

        public void enqueue(int data) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            stack1.push(data);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        public int dequeue() throws Exception {
            if(isEmpty()) {
                throw new Exception("Stack is empty!");
            }

            return stack1.pop();
        }
    }