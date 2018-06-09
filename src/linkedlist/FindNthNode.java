package linkedlist;

public class FindNthNode {


    public static LinkedList.Node findNthNode(LinkedList linkedList, int n) {
        LinkedList.Node fast = linkedList.head();
        LinkedList.Node slow = linkedList.head();

        int length = 1;
        while (fast.next() != null) {
            fast = fast.next();
            length++;

            if(length > n) {
                slow = slow.next();
            }
        }
        return slow;
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


    public static void main(String [] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.add( new LinkedList.Node("1"));
        linkedList.add( new LinkedList.Node("2"));
        linkedList.add( new LinkedList.Node("3"));
        linkedList.add( new LinkedList.Node("4"));

        System.out.println(findNthNode(linkedList, 2).data());
    }
}
