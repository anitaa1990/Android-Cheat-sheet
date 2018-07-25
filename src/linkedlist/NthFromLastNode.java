package linkedlist;


public class NthFromLastNode {

    /*
     * Given a singly linked list, return nth from last node. Return null if 'n' is out-of-bounds.
     * Eg: Input:  67, 9, 72, 94, 13, 59, 55, 72, 66, 22
     *     Output: Result for n=5 is 59
     *             Result for n=6 is 13
     *             Result for n=4 is 55
     *             Result for n=10 is 67
     * */

    /*
     * Runtime Complexity:
     * Linear, O(n)
     *
     * Memory Complexity:
     * Constant, O(1)
     *
     *    Use two pointers to find the nth from the last node.
     *    one pointing to the head and the other pointing to the nth node.
     *    Move both pointers forward until the second pointer reaches the tail.
     *    Now the first pointer will be pointing to the nth node from last.
     *    And if tail is reached before making both pointers n nodes apart, that means
     *    n is out of bounds.
     * */

   public static class LinkedList {
        Node head;

        /* Function to get the nth node from end of list */
        void printNthFromLast(int n) {
            Node main_ptr = head;
            Node ref_ptr = head;

            int count = 0;
            if (head != null) {
                while (count < n) {
                    if (ref_ptr == null) {
                        System.out.println(n + " is greater than the no " +
                                " of nodes in the list");
                        return;
                    }
                    ref_ptr = ref_ptr.next;
                    count++;
                }
                while (ref_ptr != null) {
                    main_ptr = main_ptr.next;
                    ref_ptr = ref_ptr.next;
                }
                System.out.println("Node no. " + n + " from last is " +
                        main_ptr.data);
            }
        }

        /* Inserts a new Node at front of the list. */
        public void push(int new_data) {
        /*
         * 1 & 2: Allocate the Node & Put in the data
         * */
            Node new_node = new Node(new_data);

        /*
         * 3. Make next of new Node as head
         * */
            new_node.next = head;

        /*
         * 4. Move the head to point to new Node
         * */
            head = new_node;
        }


       public class Node {
            int data;
            Node next;

            Node(int d) {
                data = d;
                next = null;
            }
        }
    }


    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(35);

        llist.printNthFromLast(4);
    }
}
