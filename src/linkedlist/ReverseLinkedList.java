package linkedlist;


public class ReverseLinkedList {

    /*
     * Runtime Complexity:
     * Linear, O(n).
     * As we can reverse the linked list in a single pass.
     *
     * Memory Complexity:
     * Constant, O(1).
     * As no extra memory is required for the iterative solution.
     * */

    private static class LinkedList {

        private LinkedList.Node head;
        public Node reverse(Node node) {
            Node previous = null;
            Node current = node;
            Node next = null;

            while (current != null) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            node = previous;
            return node;
        }


        public void printList(Node node) {
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }

        public static class Node {

            private int data;
            private Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
    }


    public static void main(String [] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.head = new LinkedList.Node(1);
        linkedList.head.next =  new LinkedList.Node(2);
        linkedList.head.next.next =  new LinkedList.Node(3);
        linkedList.head.next.next.next = new LinkedList.Node(4);

        linkedList.printList(linkedList.head);
        linkedList.head = linkedList.reverse(linkedList.head);
        System.out.println("");
        linkedList.printList(linkedList.head);
    }
}
