package linkedlist;

public class DeleteNodeWithKey {


    /*
     * Given head of a linked list and a key, delete node with this given key from the linked list.
     *
     * */

    /*
     * Step 1: find the key in the linked list. Have two pointers: current and previous as we iterate the linked list.
     * Step 2: If the key is found in the linked list, then current pointer would be pointing to the node
     *         containing key to be deleted and previous should be pointing to the node before the key node.
     * Step 3: Update current and previous pointers, as we iterate through the linked list.
     *
     * Runtime Complexity:
     *  Linear, O(n)
     *
     *  Memory Complexity:
     *   Constant, O(1)
     * */


    public static class LinkedList {

        private Node head;
        public Node deleteNode(Node head, int key) {
            Node current = head;
            Node previous = null;
            while (current != null) {
                if(current.data == key) {

                    if(current == head) {
                        head = head.next;
                        current = head;

                    } else {
                        previous.next = current.next;
                        current = current.next;
                    }

                } else {
                    previous = current;
                    current = current.next;
                }
            }

            return head;
        }

        public void printNode(Node node) {
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

        linkedList.printNode(linkedList.head);
        linkedList.head = linkedList.deleteNode(linkedList.head, 2);
        System.out.println("");
        linkedList.printNode(linkedList.head);

    }
}
