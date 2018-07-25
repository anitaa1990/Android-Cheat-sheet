package graphs;

import java.util.*;

public class CloneDirectedGraph {


    /*
     * Given root node of a directed graph, clone this graph by creating its deep copy such that
     * cloned graph has same vertices and edges as original graph.
     *
     *
     * If input graph is G = (V, E) where V is set of vertices and E is set of edges,
     * then output graph (cloned graph) G' = (V', E') such that V = V' and E = E'.
     *
     * Runtime Complexity:
     * Linear, O(n)
     *
     * Memory Complexity:
     * Logarithmic, O(n). 'n' is number of vertices in graph.
     *
     * Use depth first traversal and create a copy of each node while traversing the graph.
     * To avoid getting stuck in cycles, use a hashtable to store each completed node and will not revisit
     * nodes that exist in the hashtable.
     * Hashtable key will be a node in the original graph, and its value will be the corresponding node
     * in cloned graph.
     *
     * */

    // if there is an edge from x to y
    // that means there must be an edge from y to x
    // and there is no edge from a node to itself
    // hence there can maximim of (nodes * nodes - nodes) / 2 edges in this graph
    static ArrayList<Node> createTestGraphUndirected(int nodes_count, int edges_count) {
        ArrayList<Node> vertices = new ArrayList<Node>();
        for (int i = 0; i < nodes_count; ++i) {
            vertices.add(new Node(i));
        }

        List<Pair<Integer, Integer>> all_edges = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < vertices.size(); ++i) {
            for (int j = i + 1; j < vertices.size(); ++j) {
                all_edges.add(new Pair<>(i, j));
            }
        }

        Collections.shuffle(all_edges);

        for (int i = 0; i < edges_count && i < all_edges.size(); ++i) {
            Pair<Integer, Integer> edge = all_edges.get(i);
            vertices.get(edge.first).neighbors.add(vertices.get(edge.second));
            vertices.get(edge.second).neighbors.add(vertices.get(edge.first));
        }

        return vertices;
    }

    static void printGraph(List<Node> vertices) {
        for (Node n : vertices) {
            System.out.print(n.data + ": {");
            for (Node t : n.neighbors) {
                System.out.print(t.data + " ");
            }
            System.out.println();
        }
    }

    static void printGraph(Node root,
                           HashSet<Node> visited_nodes) {

        if (root == null || visited_nodes.contains(root)) {
            return;
        }

        visited_nodes.add(root);

        System.out.print(root.data + ": {");
        for (Node n : root.neighbors) {
            System.out.print(n.data + " ");
        }
        System.out.println("}");

        for (Node n : root.neighbors) {
            printGraph(n, visited_nodes);
        }
    }

    static void printGraph(Node root) {
        HashSet<Node> visited_nodes = new HashSet<Node>();
        printGraph(root, visited_nodes);
    }

    static boolean areGraphsEqualRec(Node root1,
                                     Node root2,
                                     HashSet<Node> visited) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.data != root2.data) {
            return false;
        }

        if (root1.neighbors.size() != root2.neighbors.size()) {
            return false;
        }

        for (Node nbr1 : root1.neighbors) {
            boolean found = false;
            for (Node nbr2 : root2.neighbors) {
                if (nbr1.data == nbr2.data) {
                    if (!visited.contains(nbr1)) {
                        visited.add(nbr1);
                        areGraphsEqualRec(nbr1, nbr2, visited);
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }

        return true;
    }


    protected static class Node {
        public int data;
        public List<Node> neighbors = new ArrayList<Node>();

        public Node(int d) {
            data = d;
        }
    }

    protected static class Graph {
        private static Node cloneRec(Node root,
                                     HashMap<Node, Node> nodes_completed) {
            if (root == null) {
                return null;
            }

            Node pNew = new Node(root.data);
            nodes_completed.put(root, pNew);

            for (Node p : root.neighbors) {
                Node x = nodes_completed.get(p);
                if (x == null) {
                    pNew.neighbors.add(cloneRec(p, nodes_completed));
                } else {
                    pNew.neighbors.add(x);
                }
            }
            return pNew;
        }

        public static Node clone(Node root) {
            HashMap<Node, Node> nodes_completed = new HashMap<Node, Node>();
            return cloneRec(root, nodes_completed);
        }
    }

    protected static class Pair<K, V> {

        private K first;
        private V second;

        public static <K, V> Pair<K, V> createPair(K element0, V element1) {
            return new Pair<K, V>(element0, element1);
        }

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        public K getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }

    }


    public static void main(String[] args) {
        ArrayList<Node> vertices = createTestGraphUndirected(7, 18);
        printGraph(vertices.get(0));

        Node cp = Graph.clone(vertices.get(0));
        System.out.println();
        System.out.println("After copy: ");
        printGraph(cp);

        HashSet<Node> set = new HashSet<>();
        System.out.println(areGraphsEqualRec(vertices.get(0), cp, set));
    }
}
