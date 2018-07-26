package trees;

public class NthHighestBST {


    /*
     * Find nth highest node in a Binary Search Tree(BST)
     *
     * Runtime Complexity:
     * Linear, O(n)
     *
     * Memory Complexity:
     * O(h)
     *
     *  In-order traversal of BST is always sorted in ascending order.
     *  To find the nth highest node, we will need to scan the tree in descending order that can achieve by doing reverse inorder traversal.
     *  The inorder traversal is normally LVR i.e. Left - Visit - Right. Reverse inorder traversal will be RVL i.e. Right - Visit - Left.
     *  While doing so, we keep a count of nodes seen so far. Once the count reaches n, that is the node to return.
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
    protected int currentCount = 0;

    protected Node findNthHighestInBst(Node node, int n) {
        if (node == null) {
            return null;
        }

        Node result = findNthHighestInBst(node.right, n);

        if (result != null) {
            return result;
        }

        currentCount++;
        if (n == currentCount) {
            return node;
        }

        result = findNthHighestInBst(node.left, n);

        if (result != null) {
            return result;
        }

        return null;
    }


    public static void main(String[] argv) {

        NthHighestBST nthHighestBST = new NthHighestBST();
        nthHighestBST.root1 = new Node(100);
        nthHighestBST.root1.left = new Node(50);
        nthHighestBST.root1.right = new Node(200);
        nthHighestBST.root1.left.left = new Node(25);
        nthHighestBST.root1.left.right = new Node(75);
        nthHighestBST.root1.right.left = new Node(125);
        nthHighestBST.root1.right.right = new Node(350);


        int n = 2;
        nthHighestBST.currentCount = 0;
        Node nth_highest_node = nthHighestBST.findNthHighestInBst(nthHighestBST.root1, n);
        System.out.println(String.format(" - %d highest node is %d", n, nth_highest_node.data));

        n = 1;
        nthHighestBST.currentCount = 0;
        nth_highest_node = nthHighestBST.findNthHighestInBst(nthHighestBST.root1, n);
        System.out.println(String.format(" - %d highest node is %d", n, nth_highest_node.data));

        n = 5;
        nthHighestBST.currentCount = 0;
        nth_highest_node = nthHighestBST.findNthHighestInBst(nthHighestBST.root1, n);
        System.out.println(String.format(" - %d highest node is %d", n, nth_highest_node.data));

        n = 30;
        nthHighestBST.currentCount = 0;
        nth_highest_node = nthHighestBST.findNthHighestInBst(nthHighestBST.root1, n);
        System.out.println(String.format(" - %d highest node is %d", n, nth_highest_node));
    }
}
