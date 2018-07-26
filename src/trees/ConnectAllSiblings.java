package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ConnectAllSiblings {


    /*
     * Given the root to a binary tree where each node has an additional pointer called sibling (or next),
     * connect the sibling pointer to next node in the same level. Last node in each level should point
     * to the first node of next level in the tree.
     *
     * Runtime Complexity:
     * Linear, O(n)
     *
     * Memory Complexity:
     * Constant O(1)
     *
     * Step 1: Initially set both current and last as 'root'
     * Step 2: while current node is not null
     *      If current node has a left child, append this left node to the last and make it last node.
     *      If current node has a right child, append this right node to the last and make it last node.
     *      update current node to current's next node
     * */

    protected static class Node {
        int data;
        Node left, right, next;

        Node(int item) {
            data = item;
            left = right = next = null;
        }
    }


    private Node root;

    public static void populateSiblingPointers(Node root) {
        if (root == null)
            return;

        Node current = root;
        Node last = root;

        while (current != null) {
            if (current.left != null) {
                last.next = current.left;
                last = current.left;
            }

            if (current.right != null) {
                last.next = current.right;
                last = current.right;
            }

            last.next = null;
            current = current.next;
        }
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

        ConnectAllSiblings tree = new ConnectAllSiblings();
        tree.root = new Node(100);
        tree.root.left = new Node(50);
        tree.root.right = new Node(200);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(75);
        tree.root.right.right = new Node(300);
        tree.root.right.right.right = new Node(350);

        Node root = tree.root;

        tree.levelOrderTraversal(root);
        populateSiblingPointers(root);

        System.out.println("Root -> next: " + root.next.data); //25
//        System.out.println("Root->right->left->next: " + root.right.left.next.data); //400
        System.out.println("Root->right->right->next: " + root.right.right.next.data); //10
//        System.out.println("Root->right->right->left->next: " + root.right.right.left.next); //None
    }

}
