package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {


    /*
     * Given root of a binary tree, display node values at each level. Node values for all levels should be displayed on separate lines.
     *
     *  Binary Node: 100, 50, 200, 25, 75, 125, 350
     *  Level order traversal for this tree should look like:
     *  100
     *  50, 200
     *  25, 75, 350
     *
     *  Runtime Complexity:
     *  Linear, O(n)
     *
     *  Memory Complexity:
     *  Linear, O(n)
     *
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
        
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        levelOrderTraversal.root1 = new Node(100);
        levelOrderTraversal.root1.left = new Node(50);
        levelOrderTraversal.root1.right = new Node(200);
        levelOrderTraversal.root1.left.left = new Node(25);
        levelOrderTraversal.root1.left.right = new Node(75);
        levelOrderTraversal.root1.right.left = new Node(125);
        levelOrderTraversal.root1.right.right = new Node(350);
        
        levelOrderTraversal(levelOrderTraversal.root1);
        System.out.println();
    }
}
