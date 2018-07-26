package trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeToLinkedList {


    /*
     * Convert a binary tree to a doubly linked list such that the order of the doubly linked list is the same as an in-order traversal of the binary tree.
     * After conversion the left pointer of the node should be pointing to the previous node in the doubly linked list and the right pointer should be
     * pointing to the next node in the doubly linked list.
     *
     * Binary Node: 100, 50, 200, 25, 75, 125, 350
     * Its in-order traversal will be 25, 30, 50, 60, 75, 100, 125, 200, 350. So the output doubly linked list should look like so:
     * 25, 30, 50, 60, 75, 100, 125, 200, 350
     *
     * Runtime Complexity:
     * Linear, O(n)
     * Runtime complexity is based on the number of nodes in the tree.
     *
     * Memory Complexity:
     * Linear, O(h)
     *
     * Start with the root node and solve left and right sub-trees recursively
     * At each step, once left and right sub-trees have been processed:
     *      - fuse output of left subtree with root to make the intermediate result
     *      - fuse intermediate result (built in the previous step) with output from the right sub-tree to make the final result of the current recursive call
     *
     * */

    private static class Node {
        private int data;
        private Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }

        public int getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }


    private Node root1;

    protected static Node concatenateLists(Node head1,
                                           Node head2) {

        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        // use left for previous.
        // use right for next.
        Node tail1 = head1.left;
        Node tail2 = head2.left;

        tail1.right = head2;
        head2.left = tail1;

        head1.left = tail2;
        tail2.right = head1;
        return head1;
    }


    protected static Node convertToLinkedList(Node root) {

        if (root == null) {
            return null;
        }

        Node list1 = convertToLinkedList(root.left);
        Node list2 = convertToLinkedList(root.right);

        root.left = root.right = root;
        Node result = concatenateLists(list1, root);
        result = concatenateLists(result, list2);

        return result;
    }
    

    static List<Integer> getList(Node head) {
        List<Integer> r = new ArrayList<Integer>();
        if (head == null) {
            return r;
        }

        Node temp = head;
        do {
            r.add(temp.data);
            temp = temp.right;
        } while (temp != head);

        return r;
    }
    

    public static void main(String[] args) {

        BinaryTreeToLinkedList binaryTreeToLinkedList = new BinaryTreeToLinkedList();
        binaryTreeToLinkedList.root1 = new Node(100);
        binaryTreeToLinkedList.root1.left = new Node(50);
        binaryTreeToLinkedList.root1.right = new Node(200);
        binaryTreeToLinkedList.root1.left.left = new Node(25);
        binaryTreeToLinkedList.root1.left.right = new Node(75);
        binaryTreeToLinkedList.root1.right.left = new Node(125);
        binaryTreeToLinkedList.root1.right.right = new Node(350);

        Node head = convertToLinkedList(binaryTreeToLinkedList.root1);
        List<Integer> result = getList(head);
        System.out.println(result);
    }
}
