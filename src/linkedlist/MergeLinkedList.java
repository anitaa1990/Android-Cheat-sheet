package linkedlist;

public class MergeLinkedList {

    /*
     * Given two sorted linked lists, merge them such that resulting linked list is also sorted.
     * Input: List1: 4, 8, 15, 19        List2: 7, 9, 10, 16
     * Output:  4, 7, 8, 9, 10, 15, 16, 19
     *
     * */

    /*
     * Runtime Complexity:
     * Linear, O(m + n) where m and n are lengths of both linked lists.
     *
     * Memory complexity:
     * Constant, O(1)
     *
     *
     * */
    public static LinkedList.Node mergeSorted(LinkedList.Node head1,
                                              LinkedList.Node head2) {

        // if both lists are empty then merged list is also empty
        // if one of the lists is empty then other is the merged list
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }


        LinkedList.Node mergedHead = null;
        if (head1.data <= head2.data) {
            mergedHead = head1;
            head1 = head1.next;
        } else {
            mergedHead = head2;
            head2 = head2.next;
        }

        LinkedList.Node mergedTail = mergedHead;

        while (head1 != null && head2 != null) {
            LinkedList.Node temp = null;
            if (head1.data <= head2.data) {
                temp = head1;
                head1 = head1.next;
            } else {
                temp = head2;
                head2 = head2.next;
            }

            mergedTail.next = temp;
            mergedTail = temp;
        }

        if (head1 != null) {
            mergedTail.next = head1;
        } else if (head2 != null) {
            mergedTail.next = head2;
        }

        return mergedHead;
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
        linkedList1.push(4);
        linkedList1.push(8);
        linkedList1.push(15);
        linkedList1.push(19);


        LinkedList linkedList2 = new LinkedList();
        linkedList2.push(7);
        linkedList2.push(9);
        linkedList2.push(10);
        linkedList2.push(16);

        System.out.println("List 1: ");
        linkedList1.printNode(linkedList1.head);
        System.out.println();
        System.out.println("List 2: ");

        linkedList2.printNode(linkedList2.head);
        System.out.println();

        LinkedList.Node mergedList = mergeSorted(linkedList1.head, linkedList2.head);
        linkedList2.printNode(mergedList);
    }
}
