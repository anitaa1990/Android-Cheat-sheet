package trees;

import java.util.ArrayList;
import java.util.List;

public class InOrderSuccessor {

    /*
     * Inorder successor of a node in binary Search Tree (BST) is the next node in inorder traversal.
     * Write a method to find inorder successor of a given value "d" in a BST.
     * Binary Node: 100, 50, 200, 25, 75, 125, 350
     *
     * Inorder successor of 25 is 50
     * Inorder successor of 50 is 75
     * Inorder successor of 75 is 100
     * Inorder successor of 100 is 125
     * Inorder successor of 125 is 200
     * Inorder successor of 200 is 350
     * Inorder successor of 350 is NULL since it is the last node
     *
     * Runtime Complexity:
     * Logarithmic, O(logn)
     *
     * Memory Complexity:
     * Constant, O(1).
     *
     * Find the value d in BST. If d has a right child then the left most child in right child's subtree
     * will be the in-order successor of d. This would also be the child with the minimum value in that subtree.
     * Find the value d in BST. If d has no right child then:
     * in-order successor is NULL if d is right most node in the BST i.e. last node in the in-order traversal
     * in-order successor is the node with minimum value higher than d in the parent chain of d
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

    private static Node findMin(Node root) {
        if (root == null) return null;

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    protected static Node inOrderSuccessorBst(Node root,
                                              int d) {

        if (root == null) {
            return null;
        }

        Node successor = null;

        while (root != null) {

            if (root.data < d) {
                root = root.right;
            } else if (root.data > d) {
                successor = root;
                root = root.left;
            } else {
                if (root.right != null) {
                    successor = findMin(root.right);
                }
                break;
            }
        }
        return successor;
    }


    protected List<Integer> values = new ArrayList<>();
    protected List<Integer> storeKeyValues(Node root) {
        treeTravel(root);
        return values;
    }

    private void treeTravel(Node node) {
        if (node != null) {
            treeTravel(node.left);
            values.add(node.data);
            treeTravel(node.right);
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> orig_data = new ArrayList<>();
        orig_data.add(25);
        orig_data.add(125);
        orig_data.add(200);
        orig_data.add(350);
        orig_data.add(50);
        orig_data.add(75);
        orig_data.add(100);

        InOrderSuccessor inOrderSuccessor = new InOrderSuccessor();
        inOrderSuccessor.root1 = new Node(100);
        inOrderSuccessor.root1.left = new Node(50);
        inOrderSuccessor.root1.right = new Node(200);
        inOrderSuccessor.root1.left.left = new Node(25);
        inOrderSuccessor.root1.left.right = new Node(75);
        inOrderSuccessor.root1.right.left = new Node(125);
        inOrderSuccessor.root1.right.right = new Node(350);


        List<Integer> bstToList = inOrderSuccessor.storeKeyValues(inOrderSuccessor.root1);

        for (Integer d : orig_data) {
            Node successor = inOrderSuccessorBst(inOrderSuccessor.root1, d);

            int i = bstToList.indexOf(d);
            Integer expected_val = null;

            if (i < bstToList.size() - 1) {
                expected_val = bstToList.get(i + 1);
            }

            if (successor != null) {
                if (expected_val.intValue() != successor.data) {
                    System.out.println("*******" + d + " ==== " + expected_val + ", " + successor.data + "*****");
                }
            }

            if (successor != null) {
                System.out.print("(" + d + ", " + successor.data + ") ");

            } else {
                System.out.print("(" + d + ", null) ");
            }
        }
    }
}
