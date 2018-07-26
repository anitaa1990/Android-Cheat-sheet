package trees;

import java.util.Stack;

public class BinaryTreeIterator {


    /*
     * Implement a class that implements an InOrder Iterator on a Binary Tree
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

    private class InOrderTreeIterator {
        private Stack<Node> stk = new Stack();

        public InOrderTreeIterator(Node root) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
        }


        public boolean hasNext() {
            return !stk.isEmpty();
        }

        public Node getNext() {
            if (stk.isEmpty())
                return null;

            Node rVal = stk.pop();
            Node temp = rVal.right;
            while (temp != null) {
                stk.push(temp);
                temp = temp.left;
            }
            return rVal;
        }
    }

    public void inOrderUsingIterator(Node root) {
        InOrderTreeIterator iterator = new InOrderTreeIterator(root);
        while (iterator.hasNext()) {
            System.out.print(iterator.getNext().data + ", ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        BinaryTreeIterator tree = new BinaryTreeIterator();
        tree.root1 = new Node(100);
        tree.root1.left = new Node(50);
        tree.root1.right = new Node(200);
        tree.root1.left.left = new Node(25);
        tree.root1.left.right = new Node(75);
        tree.root1.right.left = new Node(125);
        tree.root1.right.right = new Node(350);

        tree.inOrderUsingIterator(tree.root1);
        System.out.println();
    }
}
