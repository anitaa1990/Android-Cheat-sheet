package linkedlist;

public class CheckIfContainsCycle {


    public static boolean isCyclic(LinkedList linkedList) {
        LinkedList.Node fast = linkedList.head();
        LinkedList.Node slow = linkedList.head();

        while (fast != null && fast.next() != null) {
            fast = fast.next().next();
            slow = slow.next();

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    private static class LinkedList {

        private LinkedList.Node head;
        private LinkedList.Node tail;

        public LinkedList() {
            head = new LinkedList.Node("head");
            tail = head;
        }

        public void add(LinkedList.Node node) {
            tail.setNext(node);
            tail = node;
        }

        public void appendIntoTail(Node node) {
            Node current = head;
            while (current.next() != null) {
                current = current.next();
            }
            current.setNext(node);
        }

        public LinkedList.Node head() {
            return head;
        }

        public static class Node {
            private LinkedList.Node next;
            private String data;

            public Node(String data) {
                this.data = data;
            }

            public LinkedList.Node next() {
                return next;
            }

            public void setNext(LinkedList.Node next) {
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


    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.appendIntoTail(new LinkedList.Node("101"));
        LinkedList.Node cycle = new LinkedList.Node("201");
        linkedList.appendIntoTail(cycle);
        linkedList.appendIntoTail(new LinkedList.Node("301"));
        linkedList.appendIntoTail(new LinkedList.Node("401"));
        linkedList.appendIntoTail(cycle);

        System.out.println(isCyclic(linkedList));
    }
}
