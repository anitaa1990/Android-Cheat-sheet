package trees;


public class ConnectSiblings {


    /*
     * Given a binary tree, connect its siblings at each level
     * Runtime Complexity:
     * Linear, O(n)
     *
     * Memory Complexity:
     * Constant O(1)
     *
     * A binary tree is a data structure made up of nodes, where each node contains, besides data, up to two children:
     * "left" reference and "right" reference. Nodes with the same parent node are called siblings.
     * We need to connect all siblings at each level.
     * In level order traversal of a tree, all nodes are processed by depth; first the root, then the children of the
     * root and so on. It is equivalent to a breadth-first-search from the root.
     * Each node in the above binary tree has one more pointer i.e. next (aka sibling) along with the left and
     * right pointers. 'next' is used to connect one node to the other.
     *
     * Given the starting node at level 'x' (where nodes at level 'x' are connected):
     * 1. Traverse the nodes at level 'x' from left to right while connecting the siblings at level 'x+1'.
     *      Now that siblings at level 'x+1' are connected, use the head node (left-most) of level 'x+1' and
     *      apply the same approach on 'x+2'.
     * 2.Keep running these steps till you run out of levels.
     *
     * */

    protected static class Node {
        int data;
        Node left, right, nextRight;

        Node(int item) {
            data = item;
            left = right = nextRight = null;
        }
    }


    private Node root;

    // Sets the next of root and calls connectRecur()
    // for other nodes
    void connect(Node p) {

        // Set the next for root
        p.nextRight = null;

        // Set the next right for rest of the nodes (other
        // than root)
        connectRecur(p);
    }


    protected void connectRecur(Node p) {
        if (p == null) return;

        if (p.left != null) p.left.nextRight = p.right;

        // Set the next pointer for p's right child
        // p->next will be NULL if p is the right most child
        // at its level
        if (p.right != null)
            p.right.nextRight = (p.nextRight != null) ? p.nextRight.left : null;


        connectRecur(p.left);
        connectRecur(p.right);
    }


    public static void main(String args[]) {
        ConnectSiblings tree = new ConnectSiblings();

        /* Constructed binary tree is
             10
            /  \
          8     2
         /
        3
        */
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);


        tree.connect(tree.root);

        System.out.println("Following are populated next pointers in the tree" + "(-1 is printed if there is no next)");

        int a = tree.root.nextRight != null ? tree.root.nextRight.data : -1;
        System.out.println("next of " + tree.root.data + " is " + a);

        int b = tree.root.left.nextRight != null ? tree.root.left.nextRight.data : -1;
        System.out.println("next of " + tree.root.left.data + " is " + b);

        int c = tree.root.right.nextRight != null ? tree.root.right.nextRight.data : -1;
        System.out.println("next of " + tree.root.right.data + " is " + c);

        int d = tree.root.left.left.nextRight != null ? tree.root.left.left.nextRight.data : -1;
        System.out.println("next of " + tree.root.left.left.data + " is " + d);
    }
}
