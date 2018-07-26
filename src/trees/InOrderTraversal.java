package trees;

import java.util.Stack;

public class InOrderTraversal {


        /*
         * Given a binary tree, write an iterative algorithm to traverse the tree inorder.
         *
         * Binary Node: 100, 50, 200, 25, 75, 125, 350
         * Inorder traversal of the above tree should visit the nodes in the following order:
         * 25, 50, 75, 100, 125, 200, 350
         *
         * Runtime Complexity:
         * Linear, O(n)
         *
         * Memory Complexity:
         * O(h)
         *
         * For an iterative inorder traversal, a stack is used to track the nodes:
         * Step 1: initialize the current_node as root.
         * Step 2: create an empty stack stk.
         * Step 3: Push the current_node in stk and set  current_node = current_node->left until current_node becomes NULL.
         * Step 4:     if stk is not empty and current_node == NULL then
         *                  Print the top element from stk
         *                  Pop the top element from stk and set current_node = element_popped->right
         *                  go to step 3
           Step 5: if current_node is null and stack is empty then algorithm terminates.
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


    protected void inOrderIterative(Node root) {
        if (root == null)
            return;

        Stack<Node> stk = new Stack<>();

        while (!stk.empty() || root != null) {
            if (root != null) {
                stk.push(root);
                root = root.left;
                continue;
            }

            System.out.print(stk.peek().data + " ");
            root = stk.pop().right;
        }
    }


    public static void main(String[] args) {
        InOrderTraversal inOrderTraversal = new InOrderTraversal();

        inOrderTraversal.root1 = new Node(100);
        inOrderTraversal.root1.left = new Node(50);
        inOrderTraversal.root1.right = new Node(200);
        inOrderTraversal.root1.left.left = new Node(25);
        inOrderTraversal.root1.left.right = new Node(75);
        inOrderTraversal.root1.right.left = new Node(125);
        inOrderTraversal.root1.right.right = new Node(350);

        inOrderTraversal.inOrderIterative(inOrderTraversal.root1);
        System.out.println();
    }
}
