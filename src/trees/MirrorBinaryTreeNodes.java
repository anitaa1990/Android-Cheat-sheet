package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MirrorBinaryTreeNodes {

    /*
     * Given the root node of a binary tree, swap the 'left' and 'right' children for each node.
     *
     * Runtime Complexity:
     * Linear, O(n)
     * Every sub-tree needs to be mirrored so we visit every node once and mirror the sub-tree starting there.
     * Hence run time complexity is O(n).
     *
     * Memory Complexity:
     * Linear, O(n) in the worst case.
     *
     * Do a post order traversal of the binary tree.
     * For every node, swap it's left child with right child.
     *
     *  */

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
    protected void mirrorBinaryTree(Node root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            mirrorBinaryTree(root.left);
        }

        if (root.right != null) {
            mirrorBinaryTree(root.right);
        }


        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }


    protected static void levelOrderTraversal(Node root) {

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
    

    public static void main(String[] argv) {
        MirrorBinaryTreeNodes tree = new MirrorBinaryTreeNodes();
        tree.root1 = new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(3);
        tree.root1.left.left = new Node(4);
        tree.root1.left.right = new Node(5);
        tree.root1.right.left = new Node(6);
        tree.root1.right.right = new Node(7);        

        tree.levelOrderTraversal(tree.root1);
        tree.mirrorBinaryTree(tree.root1);
        tree.levelOrderTraversal(tree.root1);
    }
}
