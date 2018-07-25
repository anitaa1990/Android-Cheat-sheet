package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSpanningTree {

    /*
     * Find the minimum spanning tree of a connected, undirected graph with weighted edges.
     *
     *
     *
     * Runtime Complexity:
     * Quadratic, O(n2)
     * Here, 'n' is the number of vertices.
     *
     * Memory Complexity:
     * Linear, O(n + e).
     * Here, 'n' is the number of vertices and 'e' is the number of edges.
     *
     * A spanning tree of a connected, undirected graph is a subgraph that is a tree and connects
     * all the vertices together. One graph can have many different spanning trees.
     * A graph with n vertices has a spanning tree with n-1 edges.
     *
     * A weight can be assigned to each edge of the graph.
     * The weight of a spanning tree is the sum of weights of all the edges of the spanning tree.
     * A minimum spanning tree(MST) for a weighted, connected and undirected graph is a spanning tree with
     * weight less than or equal to the weight of every other spanning tree.
     *
     * Find the minimum spanning tree of a graph using Prim's algorithm.
     * This algorithm builds the tree one vertex at a time, starting from any arbitrary vertex.
     * It adds the minimum weight edge from the tree being constructed to a vertex from the remaining
     * vertices at each step.
     * */

    protected static class Vertex {
        private int id;
        private boolean visited;

        public Vertex(int id, boolean visited) {
            super();
            this.id = id;
            this.visited = visited;
        }

        int getId() {
            return id;
        }

        void setId(int id) {
            this.id = id;
        }

        boolean isVisited() {
            return visited;
        }

        void setVisited(boolean visited) {
            this.visited = visited;
        }
    }

    protected static class Edge {
        private int weight;
        private boolean visited;
        private Vertex src;
        private Vertex dest;

        public Edge(int weight, boolean visited, Vertex src,
                    Vertex dest) {
            this.weight = weight;
            this.visited = visited;
            this.src = src;
            this.dest = dest;
        }

        int getWeight() {
            return weight;
        }

        void setWeight(int weight) {
            this.weight = weight;
        }

        boolean isVisited() {
            return visited;
        }

        void setVisited(boolean visited) {
            this.visited = visited;
        }

        Vertex getSrc() {
            return src;
        }

        void setSrc(Vertex src) {
            this.src = src;
        }

        Vertex getDest() {
            return dest;
        }

        void setDest(Vertex dest) {
            this.dest = dest;
        }
    }

    protected static class Graph {
        private List<Vertex> g;   //vertices
        private List<Edge> e;     //edges

        public Graph(List<Vertex> g, List<Edge> e) {
            super();
            this.g = g;
            this.e = e;
        }

        public List<Vertex> getG() {
            return g;
        }

        public void setG(List<Vertex> g) {
            this.g = g;
        }

        public List<Edge> getE() {
            return e;
        }

        public void setE(List<Edge> e) {
            this.e = e;
        }

        // This method returns the vertex with a given id if it
        // already exists in the graph, returns NULL otherwise
        Vertex vertexExists(int id) {
            for (int i = 0; i < g.size(); i++) {
                if (g.get(i).getId() == id) {
                    return g.get(i);
                }
            }
            return null;
        }

        // This method generates the graph with v vertices
        // and e edges
        void generateGraph(int vertices,
                           List<ArrayList<Integer>> edges) {
            // create vertices
            for (int i = 0; i < vertices; i++) {
                Vertex v = new Vertex(i + 1, false);
                g.add(v);
            }

            // create edges
            for (int i = 0; i < edges.size(); i++) {
                Vertex src = vertexExists(edges.get(i).get(1));
                Vertex dest = vertexExists(edges.get(i).get(2));
                Edge e = new Edge(edges.get(i).get(0), false, src,
                        dest);
                getE().add(e);
            }
        }

        // This method finds the MST of a graph using
        // Prim's Algorithm
        // returns the weight of the MST
        int findMinSpanningTree() {
            int vertex_count = 0;
            int weight = 0;

            // Add first vertex to the MST
            Vertex current = g.get(0);
            current.setVisited(true);
            vertex_count++;

            // Construct the remaining MST using the
            // smallest weight edge
            while (vertex_count < g.size()) {
                Edge smallest = null;
                for (int i = 0; i < e.size(); i++) {
                    if (e.get(i).isVisited() == false
                            && e.get(i).getDest().isVisited() == false) {
                        smallest = e.get(i);
                        break;
                    }
                }

                for (int i = 0; i < e.size(); i++) {
                    if (e.get(i).isVisited() == false) {
                        if (e.get(i).getSrc().isVisited() == true
                                && e.get(i).getDest().isVisited() == false
                                && (e.get(i).getWeight() < smallest
                                .getWeight())) {
                            smallest = e.get(i);
                        }
                    }
                }

                smallest.setVisited(true);
                smallest.getDest().setVisited(true);
                weight += smallest.getWeight();
                vertex_count++;
            }
            return weight;
        }

        void printMst(int w) {
            System.out.println("MST");
            for (int i = 0; i < e.size(); i++) {
                if (e.get(i).isVisited() == true) {
                    System.out.println(e.get(i).getSrc().getId() + "->"
                            + e.get(i).getDest().getId());
                }
            }
            System.out.println("weight: " + w);
            System.out.println();
        }
    };



    public static void testGraph1() {
        Graph g = new Graph(new ArrayList<>(), new ArrayList<>());
        int v = 5;

        // each edge contains the following: weight, src, dest
        ArrayList<Integer> e1 = new ArrayList<Integer>(Arrays.asList(1, 1, 2));
        ArrayList<Integer> e2 = new ArrayList<Integer>(Arrays.asList(1, 1, 3));
        ArrayList<Integer> e3 = new ArrayList<Integer>(Arrays.asList(2, 2, 3));
        ArrayList<Integer> e4 = new ArrayList<Integer>(Arrays.asList(3, 2, 4));
        ArrayList<Integer> e5 = new ArrayList<Integer>(Arrays.asList(3, 3, 5));
        ArrayList<Integer> e6 = new ArrayList<Integer>(Arrays.asList(2, 4, 5));

        List<ArrayList<Integer>> e = new ArrayList<>();
        e.add(e1);
        e.add(e2);
        e.add(e3);
        e.add(e4);
        e.add(e5);
        e.add(e6);

        g.generateGraph(v, e);
        System.out.println("Testing graph 1...");
        int w = g.findMinSpanningTree();
        g.printMst(w);
    }

    public static void testGraph2() {
        Graph g = new Graph(new ArrayList<>(), new ArrayList<>());
        int v = 7;

        // each edge contains the following: weight, src, dest
        ArrayList<Integer> e1 = new ArrayList<>(Arrays.asList(2, 1, 4));
        ArrayList<Integer> e2 = new ArrayList<>(Arrays.asList(1, 1, 3));
        ArrayList<Integer> e3 = new ArrayList<>(Arrays.asList(2, 1, 2));
        ArrayList<Integer> e4 = new ArrayList<>(Arrays.asList(1, 3, 4));
        ArrayList<Integer> e5 = new ArrayList<>(Arrays.asList(3, 2, 4));
        ArrayList<Integer> e6 = new ArrayList<>(Arrays.asList(2, 3, 5));
        ArrayList<Integer> e7 = new ArrayList<>(Arrays.asList(2, 4, 7));
        ArrayList<Integer> e8 = new ArrayList<>(Arrays.asList(1, 5, 6));
        ArrayList<Integer> e9 = new ArrayList<>(Arrays.asList(2, 5, 7));

        List<ArrayList<Integer>> e = new ArrayList<>();
        e.add(e1);
        e.add(e2);
        e.add(e3);
        e.add(e4);
        e.add(e5);
        e.add(e6);
        e.add(e7);
        e.add(e8);
        e.add(e9);

        g.generateGraph(v, e);
        System.out.println("Testing graph 2...");
        int w = g.findMinSpanningTree();
        g.printMst(w);
    }

    public static void main(String[] args) {
        testGraph1();
        testGraph2();
    }
}
