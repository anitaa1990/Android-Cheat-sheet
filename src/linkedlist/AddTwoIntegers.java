package linkedlist;

public class AddTwoIntegers {


    /*
     * Given head pointers of two linked lists where each linked list represents an integer number
     * (each node is a digit), add them and return the resulting linked list.
     * Input: List1: 1,2,3  List: 1,2
     * Output: 2, 4, 3
     *
     * Runtime Complexity:
     * Linear, O(n)
     *
     * Memory Complexity:
     * Constant, O(1)
     *
     * Add the integers 9901 and 237. The result of this addition would be 10138.
     * */

    static LinkedList.Node addIntegers(LinkedList.Node integer1,
                                       LinkedList.Node integer2) {

        LinkedList.Node result = null;
        LinkedList.Node last = null;
        int carry = 0;

        while (
                integer1 != null ||
                        integer2 != null ||
                        carry > 0) {

            int first = (integer1 == null ? 0 : integer1.data);
            int second = (integer2 == null ? 0 : integer2.data);
            int sum = first + second + carry;
            LinkedList.Node pNew = new LinkedList.Node(sum % 10);
            carry = sum / 10;
            if (result == null) {
                result = pNew;
            } else {
                last.next = pNew;
            }

            last = pNew;
            if (integer1 != null) {
                integer1 = integer1.next;
            }
            if (integer2 != null) {
                integer2 = integer2.next;
            }
        }
        return result;
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


        LinkedList linkedList2 = new LinkedList();
        linkedList2.push(1);
        linkedList2.push(2);

        System.out.println("List 1: ");
        linkedList1.printNode(linkedList1.head);
        System.out.println();

        System.out.println("List 2: ");
        linkedList2.printNode(linkedList2.head);
        System.out.println();

        LinkedList.Node mergedList = addIntegers(linkedList1.head, linkedList2.head);
        linkedList1.printNode(mergedList);
    }
}
