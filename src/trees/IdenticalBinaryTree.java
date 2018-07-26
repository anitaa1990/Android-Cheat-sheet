package trees;

public class IdenticalBinaryTree {


    /*
     * Given roots of two binary trees, determine if these trees are identical or not.
     * Identical trees have the same layout and data at each node.
     *
     * Runtime Complexity:
     * Linear, O(n).
     *
     * Memory Complexity:
     * O(h)
     *
     * The recursive solution has O(h) memory complexity as it will consume memory on the stack up to the height
     * of binary tree h. It will be O(log n) for a balanced tree and in the worst case can be O(n).
     *
     * Two trees 'A' and 'B' are identical if:
     *      data on their roots is same or both roots are null
     *      left sub-tree of 'A' is identical to the left sub-tree of 'B'
     *      right sub-tree of 'A' is identical to the right sub-tree of 'B'
     * To solve this problem do a depth first traversal on both trees simultaneously and keep comparing the data
     * at each level.
      *
     * */

    private Node root1, root2;

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

    protected boolean isIdentical(Node root1,
                                  Node root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 != null && root2 != null) {
            return ((root1.data == root2.data) &&
                    isIdentical(root1.left, root2.left) &&
                    isIdentical(root1.right, root2.right));
        }

        return false;
    }


    public static void main(String[] args) {
        IdenticalBinaryTree tree = new IdenticalBinaryTree();

        tree.root1 = new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(3);
        tree.root1.left.left = new Node(4);
        tree.root1.left.right = new Node(5);

        tree.root2 = new Node(1);
        tree.root2.left = new Node(2);
        tree.root2.right = new Node(3);
        tree.root2.left.left = new Node(4);
        tree.root2.left.right = new Node(5);

        if (tree.isIdentical(tree.root1, tree.root2))
            System.out.println("Both trees are identical");
        else
            System.out.println("Trees are not identical");

    }
}
