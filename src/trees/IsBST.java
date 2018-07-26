package trees;

public class IsBST {

    /*
     * Given a Binary Tree figure out whether it's a Binary Search Tree.
     * A binary search tree holds the property that each node's key value is smaller than the key value of all
     * nodes in the right subtree and greater than the key values of all nodes in the left subtree i.e. L < N < R.
     *
     *  BST: 100, 50, 200, 25, 75, 125, 350
     *
     *  Runtime Complexity:
     *  Linear, O(n)
     *
     *  Memory Complexity:
     *  O(h)
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

    private static boolean isBstRec(Node root,
                                    int minValue,
                                    int maxValue) {

        if (root == null) {
            return true;
        }

        if (root.data < minValue ||
                root.data > maxValue) {
            return false;
        }

        return
                isBstRec(root.left, minValue, root.data) &&
                        isBstRec(root.right, root.data, maxValue);
    }

    public static boolean isBst(Node root) {
        return isBstRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    

    public static void main(String[] argv) {

        IsBST isBST = new IsBST();
        isBST.root1 = new Node(100);
        isBST.root1.left = new Node(50);
        isBST.root1.right = new Node(200);
        isBST.root1.left.left = new Node(25);
        isBST.root1.left.right = new Node(75);
        isBST.root1.right.left = new Node(125);
        isBST.root1.right.right = new Node(350);

        System.out.println();
        System.out.println("Is it BST: " + Boolean.toString(isBst(isBST.root1)));
    }
}
