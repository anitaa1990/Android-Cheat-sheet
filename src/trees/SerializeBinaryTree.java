package trees;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;

public class SerializeBinaryTree {



    /*
     * Serialize binary tree to a file and then deserialize back to tree
     * such that original and deserialized trees are identical
     *
     * Runtime Complexity:
     * Linear, O(n)
     *
     * Memory Complexity:
     * Logarithmic, O(logn)
     *
     * One approach is to perform a depth-first traversal and serialize individual nodes to the stream.
     * Use pre-order traversal here.
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
    private static final int MARKER = Integer.MIN_VALUE;

    protected void serialize(Node node, ObjectOutputStream stream)
            throws java.io.IOException {
        if (node == null) {
            stream.writeInt(MARKER);
            return;
        }

        stream.writeInt(node.data);
        serialize(node.left, stream);
        serialize(node.right, stream);
    }



    protected Node deserialize(ObjectInputStream stream) throws java.io.IOException {
        int val = stream.readInt();
        if (val == MARKER) {
            return null;
        }

        Node node = new Node(val);
        node.left = deserialize(stream);
        node.right = deserialize(stream);
        return node;
    }


    protected void inOrderDisplay(Node root) {
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
        try{

            SerializeBinaryTree serializeBinaryTree = new SerializeBinaryTree();
            serializeBinaryTree.root1 = new Node(1);
            serializeBinaryTree.root1.left = new Node(2);
            serializeBinaryTree.root1.right = new Node(3);
            serializeBinaryTree.root1.left.left = new Node(4);
            serializeBinaryTree.root1.left.right = new Node(5);
            serializeBinaryTree.root1.right.left = new Node(6);
            serializeBinaryTree.root1.right.right = new Node(7);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream stream = new ObjectOutputStream(byteArrayOutputStream);
            serializeBinaryTree.serialize(serializeBinaryTree.root1, stream);
            stream.close();

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream  objectInputStream = new ObjectInputStream(byteArrayInputStream);

            Node deserialize = serializeBinaryTree.deserialize(objectInputStream);

            System.out.println("\nResult");
            serializeBinaryTree.inOrderDisplay(deserialize);

            System.out.println(serializeBinaryTree.isIdentical(serializeBinaryTree.root1, deserialize));

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
