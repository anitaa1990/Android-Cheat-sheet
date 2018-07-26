package trees;

import java.util.Stack;

public class PrintTreePerimeter {


    /*
     * Given the root node of a binary tree, print nodes forming the boundary (perimeter).
     *
     *
     * Runtime Complexity:
     * Linear, O(n)
     *
     * Memory Complexity:
     * O(h)
     *
     * Print the root node.
     * Print the left boundary in top-down order.
     * Print the leaf nodes in left-right order.
     * Print the right boundary in bottom-up order.
     * Push node values in a stack here. Once the leaf node is hit, pop all elements of the stack
     * while printing them.
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

    protected static void printLeftPerimeter(Node root) {
        while (root != null) {

            int curr_val = root.data;

            if (root.left != null) {
                root = root.left;
                
            } else if (root.right != null) {
                root = root.right;
                
            } else {
                break;
            }
            
            System.out.print(curr_val + " ");
        }
    }
    

    public static void printRightPerimeter(Node root) {

        Stack<Integer> rightValues = new Stack<>();
        
        while (root != null) {

            int curr_val = root.data;

            if (root.right != null) {
                root = root.right;
                
            } else if (root.left != null) {
                root = root.left;
                
            } else {
                break; // leaf node.
            }

            rightValues.push(curr_val);
        }

        while (!rightValues.isEmpty()) {
            System.out.print(rightValues.pop() + " ");
        }
    }
    
    

    protected static void printLeafNodes(Node root) {
        if (root != null) {
            printLeafNodes(root.left);
            printLeafNodes(root.right);

            if (root.left == null &&
                    root.right == null) {
                System.out.print(root.data + " ");
            }
        }
    }
    

    protected static void displayTreePerimeter(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");

            printLeftPerimeter(root.left);

            if (root.left != null || root.right != null) {
                printLeafNodes(root);
            }

            printRightPerimeter(root.right);
        }
    }
    

    public static void main(String[] argv) {
        PrintTreePerimeter printTreePerimeter = new PrintTreePerimeter();
        printTreePerimeter.root1 = new Node(1);
        printTreePerimeter.root1.left = new Node(2);
        printTreePerimeter.root1.right = new Node(3);
        printTreePerimeter.root1.left.left = new Node(4);
        printTreePerimeter.root1.left.right = new Node(5);
        printTreePerimeter.root1.right.left = new Node(6);
        printTreePerimeter.root1.right.right = new Node(7);
        
        System.out.print("Perimeter:\n");
        displayTreePerimeter(printTreePerimeter.root1);
    }
}
