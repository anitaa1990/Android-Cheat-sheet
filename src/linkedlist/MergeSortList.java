package linkedlist;



public class MergeSortList {

    /*
     * Given head pointer of a linked sort, sort linked list (in ascending order) using merge sort
     * and return new head pointer of sorted linked list.
     * Input: List1: 29 -> 23 -> 82 -> 11
     * Output:  11 -> 23 -> 29 -> 82
     *
     * */

    /*
     * Runtime Complexity:
     * Linearithmic i.e. O(n * log n)
     *
     * Memory complexity:
     * Logarithmic, O(log n)
     *
     *
     * The concept of merge sort is very straightforward.
     * In the dividing step, split the input linked list into two halves and keep doing it until there is a linked list of size 1 or 0.
     * Linked lists of size 1 and 0 are always sorted. In the combining step, merge sorted lists and keep doing this until
     * there is a completely sorted list. Recurrence relation for this merge sort algorithm will be:
     *
     * T(n) = 2T(n/2) + nT(n)=2T(n/2)+n
     * At each step, divide the problem into two sub-problems and size of each sub-problem is n/2 and total cost of combining step
     * (merging sorted lists) is n.
     * If we solve this recurrence relation, the result will be O(n * log n) which is the time complexity of merge sort
     * */


    // this method splits linked list in two halves by iterating over whole list
    // It returns head pointers of first and 2nd halves of linked lists in first_second
    // Head of 1st half is just the head node of linked list
    private static void splitInHalf(LinkedList.Node head,
                                    Pair<LinkedList.Node, LinkedList.Node> firstSecondPair) {

        if (head == null) {
            return;
        }

        // Only one element in the list.
        if (head.next == null) {

            firstSecondPair.first = head;
            firstSecondPair.second = null;
        } else {

            // Let's use the classic technique of moving two pointers:
            // 'fast' and 'slow'. 'fast' will move two steps in each
            // iteration where 'slow' will be pointing to middle element
            // at the end of loop.

            LinkedList.Node slow, fast;
            slow = head;
            fast = head.next;

            while (fast != null) {

                fast = fast.next;

                if (fast != null) {

                    fast = fast.next;
                    slow = slow.next;
                }
            }

            firstSecondPair.first = head;
            firstSecondPair.second = slow.next;

            // Terminate first linked list.
            slow.next = null;
        }
    }

    private static LinkedList.Node mergeSortedLists(LinkedList.Node first,
                                                    LinkedList.Node second) {

        if (first == null) {
            return second;
        } else if (second == null) {
            return first;
        }

        LinkedList.Node new_head;
        if (first.data <= second.data) {
            new_head = first;
            first = first.next;
        } else {
            new_head = second;
            second = second.next;
        }

        LinkedList.Node new_current = new_head;
        while (first != null && second != null) {
            LinkedList.Node temp = null;
            if (first.data <= second.data) {
                temp = first;
                first = first.next;
            } else {
                temp = second;
                second = second.next;
            }

            new_current.next = temp;
            new_current = temp;
        }

        if (first != null) {
            new_current.next = first;
        } else if (second != null) {
            new_current.next = second;
        }

        return new_head;
    }

    public static LinkedList.Node mergeSort(LinkedList.Node head) {

        // No need to sort a single element.
        if (head == null || head.next == null) {
            return head;
        }

        Pair<LinkedList.Node, LinkedList.Node> first_second = new Pair<LinkedList.Node, LinkedList.Node>(null, null);

        // Let's split the list in half, sort the sublists
        // and then merge the sorted lists.
        splitInHalf(head, first_second);

        first_second.first = mergeSort(first_second.first);
        first_second.second = mergeSort(first_second.second);

        return mergeSortedLists(first_second.first, first_second.second);
    }


    public static class Pair<K, V> {

        private K first;
        private V second;

        public static <K, V> Pair<K, V> createPair(K element0, V element1) {
            return new Pair<K, V>(element0, element1);
        }

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        public K getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }

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
        linkedList.push(8);
        linkedList.push(15);
        linkedList.push(1);
        linkedList.push(19);
        linkedList.push(2);
        linkedList.push(1);


        System.out.println("Original: ");
        linkedList.printNode(linkedList.head);
        System.out.println();
        System.out.println("Sorted: ");
        LinkedList.Node mergedList = mergeSort(linkedList.head);
        linkedList.printNode(mergedList);
    }
}
