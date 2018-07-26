package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DeleteZeroSumSubTrees {


    /*
     * Given root of a binary tree, delete any subtrees whose nodes sum up to zero
     * Runtime Complexity:
     * Linear, O(n)
     *
     * Memory Complexity:
     * O(h)
     *
     * Do a post order traversal of the binary tree.
     * Traverse the left subtree by recursively calling the post-order function.
     * Traverse the right subtree by recursively calling the post-order function.
     * Process the data part of root element (or current element).
     *
     * For every node, if it's left or right subtree reports zero sum, delete that subtree.
     * Moreover, if the root node returns zero then we will delete the entire tree.
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


    public static int deleteZeroSumSubtreeRec(Node root) {

        if (root == null) {
            return 0;
        }

        int sumLeft = deleteZeroSumSubtreeRec(root.left);
        int sumRight = deleteZeroSumSubtreeRec(root.right);

        if (sumLeft == 0) {
            root.left = null;
        }
        if (sumRight == 0) {
            root.right = null;
        }
        return root.data + sumLeft + sumRight;
    }



    protected void deleteZeroSumSubtree() {
        if (root1 == null) {
            return;
        }

        if (0 == deleteZeroSumSubtreeRec(root1)) {
            root1 = null;
        }
    }



    public static Node createTestTree() {
        Node head = new Node(7);
        Node curr_head = head;

        Node left = new Node(5);
        Node right = new Node(6);//
        curr_head.left = left;
        curr_head.right = right;

        curr_head = head.left;
        left = new Node(-3);
        right = new Node(-2);
        curr_head.left = left;
        curr_head.right = right;

        return head;
    }


    protected void levelOrderTraversal(Node root) {

        if (root == null) {
            return;
        }

        List<Queue<Node>> queues = new ArrayList<>();
        queues.add(new ArrayDeque<>());
        queues.add(new ArrayDeque<>());

        Queue<Node> currentQueue = queues.get(0);
        Queue<Node> nextQueue = queues.get(1);

        currentQueue.add(root);
        int levelNumber = 0;

        while (!currentQueue.isEmpty()) {
            Node temp = currentQueue.poll();
            System.out.print(temp.data + ",");

            if (temp.left != null) {
                nextQueue.add(temp.left);
            }

            if (temp.right != null) {
                nextQueue.add(temp.right);
            }

            if (currentQueue.isEmpty()) {
                System.out.println();
                ++levelNumber;
                currentQueue = queues.get(levelNumber % 2);
                nextQueue = queues.get((levelNumber + 1) % 2);
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {

        DeleteZeroSumSubTrees tree = new DeleteZeroSumSubTrees();

        tree.root1 = createTestTree();
        tree.levelOrderTraversal(tree.root1);
        System.out.println();

        tree.deleteZeroSumSubtree();
        tree.levelOrderTraversal(tree.root1);
    }

}
