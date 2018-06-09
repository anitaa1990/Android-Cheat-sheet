package linkedlist;

public class FindMiddleNode {


    /*
     * Find middle node of linked list in Java in one pass
     * */
    public static LinkedList.Node findMiddleNode(LinkedList linkedList) {
        LinkedList.Node current = linkedList.head();
        LinkedList.Node middle = linkedList.head();

        int length = 0;
        while (current.next() != null) {
            length++;

            if(length%2 == 0) {
                middle = middle.next();
            }
            current = current.next();
        }

        if(length%2 == 1) {
            middle = middle.next();
        }

        return middle;
    }


    private static class LinkedList {

        private Node head;
        private Node tail;
        public LinkedList() {
            head = new Node("head");
            tail = head;
        }

        public void add(Node node) {
            tail.setNext(node);
            tail = node;
        }

        public Node head() {
            return head;
        }

        public static class Node {
            private Node next;
            private String data;
            public Node(String data) {
                this.data = data;
            }

            public Node next() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public String data() {
                return data;
            }

            public void setData(String data) {
                this.data = data;
            }
        }
    }


    public static void main(String [] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.add( new LinkedList.Node("1"));
        linkedList.add( new LinkedList.Node("2"));
        linkedList.add( new LinkedList.Node("3"));
        linkedList.add( new LinkedList.Node("4"));

        System.out.println(findMiddleNode(linkedList).data());
    }
}
