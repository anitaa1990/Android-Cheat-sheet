package linkedlist;


public class InsertSortLinkedList {


    /*
     * Given head pointer of a linked list, sort the linked list (in ascending order) using insertion sort
     * and return new head pointer of the sorted linked list.
     * Eg: Input:  29 -> 23 -> 82 -> 11,
     *     Output: 11 -> 23 -> 29 -> 82.
     * */

    /*
     * Insertion Sort is very simple. Two linked lists will be maintained:
     * Original list (given to us as input).
     * Sorted list (initially empty).
     *
     * Algorithm:
     * While Original list is not empty:
     * Remove an element 'a' from the Original list.
     * Insert 'a' at correct sorted position in the Sorted list.
     * In order to insert a node in Sorted linked list we may need to scan the whole sorted list depending upon the node being inserted.
     * */

    public static LinkedList.Node sortedInsert(LinkedList.Node head,
                                               LinkedList.Node node) {

        if (node == null) {
            return head;
        }

        if (head == null || node.data <= head.data) {
            node.next = head;
            return node;
        }

        LinkedList.Node curr = head;
        while (curr.next != null && (curr.next.data < node.data)) {
            curr = curr.next;
        }

        node.next = curr.next;
        curr.next = node;

        return head;
    }


    public static LinkedList.Node insertionSort(LinkedList.Node head) {

        LinkedList.Node sorted = null;
        LinkedList.Node curr = head;

        while (curr != null) {
            LinkedList.Node temp = curr.next;
            sorted = sortedInsert(sorted, curr);
            curr = temp;
        }

        return sorted;
    }


    private static class LinkedList {

        private Node head;
        private Node tail;

        public LinkedList(Integer value) {
            head = new Node(value);
            tail = head;
        }

        public void add(Node node) {
            tail.setNext(node);
            tail = node;
        }

        public Node head() {
            return head;
        }

        public void printNode(Node node) {
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
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

        LinkedList linkedList = new LinkedList(3);
        linkedList.add(new LinkedList.Node(1));
        linkedList.add(new LinkedList.Node(5));
        linkedList.add(new LinkedList.Node(4));
        linkedList.add(new LinkedList.Node(9));
        linkedList.add(new LinkedList.Node(0));

        System.out.println("Original: ");
        linkedList.printNode(linkedList.head);
        linkedList.head = insertionSort(linkedList.head);

        System.out.println("Sorted: ");
        linkedList.printNode(linkedList.head);
    }
}
