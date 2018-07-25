package linkedlist;


public class ReversekElements {

    /*
    * Given a singly linked list and an integer 'k', reverse every 'k' elements. If k <= 1, then input list is unchanged.
    * If k >= n (n is the length of linked list), then reverse the whole linked list.
    *
    * Input: 1, 2, 3, 4, 5, 6
    * When k = 3,
    * Output: 3, 2, 1, 6, 5, 4
    *
    * Runtime Complexity:
    * Linear, O(n).
    *
    * Memory Complexity:
    * Constant, O(1).
    *
    *
    * */

    public static LinkedList.Node reverseKNodes(LinkedList.Node head,
                                                int k) {

        // if k is 0 or 1, then list is not changed
        if (k <= 1 || head == null) {
            return head;
        }

        LinkedList.Node reversed = null;
        LinkedList.Node prev_tail = null;

        while (head != null && k > 0) {
            LinkedList.Node current_head = null;
            LinkedList.Node current_tail = head;

            int n = k;
            while (head != null && n > 0) {
                LinkedList.Node temp = head.next;
                head.next = current_head;
                current_head = head;

                head = temp;
                n--;
            }

            if (reversed == null) {
                reversed = current_head;
            }

            if (prev_tail != null) {
                prev_tail.next = current_head;
            }
            prev_tail = current_tail;
        }

        return reversed;
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
        linkedList1.push(6);

        System.out.println("List 1: ");
        linkedList1.printNode(linkedList1.head);
        System.out.println();

        LinkedList.Node mergedList = reverseKNodes(linkedList1.head, 3);
        linkedList1.printNode(mergedList);
    }
}
