package linkedlist;


public class SwapNthNodeWithHead {


    /*
     * Given the head of a singly linked list and 'N', swap the head with Nth node. Return the head of the new linked list.
     * Input: 1, 2, 3, 4, 5,
     * Output: Swapping 3rd Node with Head
     * Input: 3, 2, 1, 4, 5,
     * Output: Swapping 5th Node with Head
     *
     * */

    /*
     * Runtime Complexity:
     * Linear, O(n).
     *
     * Memory Complexity:
     * Constant, O(1).
     *
     * To swap the Nth node with head, find the (N-1)th node as we need node '(N-1)->next' to become the new head.
     * Then iterate the list till current points to the Nth node.
     * 'prev' follows current and will be pointing to (N-1)th node.
     *  Return current as the new head of the linked list.
     * */
    public static LinkedList.Node swapNthNode(LinkedList.Node head, int n) {
        LinkedList.Node prev = null;
        LinkedList.Node current = head;

        if (head == null) {
            return head;
        }

        if (n == 1) {
            // No need to swap head with head.
            return head;
        }

        for (int count = 1;
             current != null && count < n;
             ++count) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return head;
        }

        // current is pointing to nth node.
        // Let's swap nth node with head.

        prev.next = head;
        LinkedList.Node temp = head.next;
        head.next = current.next;
        current.next = temp;

        return current;
    }

    public static class LinkedList {

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
        LinkedList linkedList = new LinkedList();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(4);
        linkedList.push(5);

        linkedList.printNode(linkedList.head);
        System.out.println();
        linkedList.head = swapNthNode(linkedList.head, 3);
        linkedList.printNode(linkedList.head);
    }
}
