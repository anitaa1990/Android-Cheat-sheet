package linkedlist;

public class RotateLinkedList {

    /*
     * Given head node of a singly linked list and an integer 'n', rotate linked list by 'n'.
     * Input: 1, 2, 3, 4, 5
     * After rotating by 2, output: 4, 5, 1, 2, 3
     *
     * Runtime Complexity:
     * Linear, O(m).
     * where 'm' is the length of linked list.
     *
     * Memory Complexity:
     * Constant, O(1).
     *
     * Find length of the linked list.
     * If n is negative or n is larger than length of the linked list, adjust this for number of rotations needed at the tail of linked list.
     * Adjusted number is always an integer N where 0 <= N < n.
     * If the adjusted number of rotations is 0, then just return the head pointer which means that no rotations were needed.
     * Find nth node from last node of linked list. As we already have length of linked list, it is simpler. It is basically getting to the node 'x' at length 'n - N'. Next pointer of node previous to this node i.e. 'x' should be updated to point to NULL.
     * Start from 'x' and move to the last node of the linked list. Update next pointer of last node to point to the head node.
     * Make 'x' as the new head node. Hence 'x' is the head of linked list after performing n rotations.
     * */
    private static int findLength(LinkedList.Node head) {
        int len = 0;

        while (head != null) {
            ++len;
            head = head.next;
        }

        return len;
    }

    private static int adjustRotationsNeeded(int n, int len) {
        // If n is positive then number of rotations performed is from right side
        // and if n is negative then number of rotations performed from left side
        // Let's optimize the number of rotations.
        // Handle case if 'n' is a negative number.
        n = n % len;

        if (n < 0) {
            n = n + len;
        }

        return n;
    }

    public static LinkedList.Node rotateList(LinkedList.Node head, int n) {
        if (head == null || n == 0) {
            return head;
        }

        int len = findLength(head);

        // If n (number of rotations required) is bigger than
        // length of linked list or if n is negative then
        // we need to adjust total number of rotations needed
        n = adjustRotationsNeeded(n, len);

        if (n == 0) {
            return head;
        }

        // Find the start of rotated list.
        // If we have 1,2,3,4,5 where n = 2,
        // 4 is the start of rotated list.
        int rotations_count = len - n - 1;
        LinkedList.Node temp = head;

        while (rotations_count > 0) {
            rotations_count--;
            temp = temp.next;
        }

        // After the above loop temp will be pointing
        // to one node prior to rotation point
        LinkedList.Node new_head = temp.next;

        // Set new end of list.
        temp.next = null;

        // Iterate to the end of list and
        // link that to original head.
        temp = new_head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;

        return new_head;
    }

    protected static class LinkedList {

        private Node head;

        public Node head() {
            return head;
        }

        public void printNode(Node node) {
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }

        /* Inserts a new Node at end of the list. */
        public void push(int new_data) {
            Node newNode = new Node(new_data);
            if (head == null) {
                head = new Node(new_data);
                return;
            }

            newNode.next = null;
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }

        public static class Node {
            private Node next;
            private Integer data;

            public Node(Integer data) {
                this.data = data;
            }

            public Node next() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public Integer data() {
                return data;
            }

            public void setData(Integer data) {
                this.data = data;
            }
        }
    }


    public static void main(String[] args) {

        LinkedList linkedList1 = new LinkedList();
        linkedList1.push(1);
        linkedList1.push(2);
        linkedList1.push(3);
        linkedList1.push(4);
        linkedList1.push(5);

        System.out.println("List 1: ");
        linkedList1.printNode(linkedList1.head);
        System.out.println();

        LinkedList.Node mergedList = rotateList(linkedList1.head, 2);
        linkedList1.printNode(mergedList);
    }
}
