package linkedlist;

public class ReverseEvenNodes {

    /*
     * Given a singly linked list, reverse nodes at even indices:
     * Input: 7, 14, 21, 28, 9
     * Output: 7, 28, 21, 14, 9
     *
     * Runtime Complexity:
     * Linear, O(n)
     *
     * Memory Complexity:
     * Constant, O(1).
     *
     *
     * Create two lists comprising of nodes at odd and even indices.
     * While extracting even nodes, push them at the head of list_even since we need them in reverse order while merging.
     * Now that the two lists are in the correct order, it's just a matter of merging their nodes alternately.
     * */

    public static LinkedList.Node mergeAlternating(LinkedList.Node list1,
                                                   LinkedList.Node list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        LinkedList.Node head = list1;

        while (list1.next != null &&
                list2 != null) {
            LinkedList.Node temp = list2;
            list2 = list2.next;

            temp.next = list1.next;
            list1.next = temp;
            list1 = temp.next;
        }

        if (list1.next == null) {
            list1.next = list2;
        }

        return head;
    }

    public static LinkedList.Node reverseEvenNodes(LinkedList.Node head) {

        // Let's extract even nodes from the existing
        // list and create a new list consisting of
        // even nodes. We will push the even nodes at
        // head since we want them to be in reverse order.

        LinkedList.Node curr = head;
        LinkedList.Node list_even = null;

        while (curr != null &&
                curr.next != null) {
            LinkedList.Node even = curr.next;
            curr.next = even.next;

            // Push at the head of new list.
            even.next = list_even;
            list_even = even;

            curr = curr.next;
        }

        // Now, merge the two lists
        // Original: 1,2,3,4,5
        // Modified original: 1,3,5
        // List_even: 4,2
        // Merged: 1,4,3,2,5

        return mergeAlternating(head, list_even);
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

        LinkedList linkedList1 = new LinkedList();
        linkedList1.push(7);
        linkedList1.push(14);
        linkedList1.push(21);
        linkedList1.push(28);
        linkedList1.push(9);

        System.out.println("List 1: ");
        linkedList1.printNode(linkedList1.head);
        System.out.println();

        LinkedList.Node mergedList = reverseEvenNodes(linkedList1.head);
        linkedList1.printNode(mergedList);
    }
}
