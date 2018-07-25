package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordChaining {


    /*
     * Figure out whether the given words can form a circular chain.
     * Assume that single word can never form a chain.
     *
     * Two words can be chained together if the first word's last letter is equal to the second word's
     * first letter.
     * Input: { eve, eat, ripe, tear }
     * Output:
     *
     * */


    protected static class Vertex {
        private char value;
        private boolean visited;
        private List<Vertex> adj_vertices;
        private List<Vertex> in_vertices;

        public Vertex(char value, boolean visited) {
            this.value = value;
            this.visited = visited;
            this.adj_vertices = new ArrayList<Vertex>();
            this.in_vertices = new ArrayList<Vertex>();
        }

        char getValue() {
            return value;
        }

        void setValue(char value) {
            this.value = value;
        }

        boolean isVisited() {
            return visited;
        }

        void setVisited(boolean visited) {
            this.visited = visited;
        }

        List<Vertex> getAdj_vertices() {
            return this.adj_vertices;
        }

        List<Vertex> getIn_vertices() {
            return this.in_vertices;
        }
    }

    protected static class Graph {
        private List<Vertex> g;

        public Graph(List<Vertex> g) {
            super();
            this.g = g;
        }

        public List<Vertex> getG() {
            return g;
        }

        void setG(List<Vertex> g) {
            this.g = g;
        }


        // This method creates a graph from a list of words. A node of
        // the graph contains a character representing the start or end
        // character of a word.
        void createGraph(List<String> words_list) {
            for (int i = 0; i < words_list.size(); i++) {
                String word = words_list.get(i);
                char start_char = word.charAt(0);
                char end_char = word.charAt(word.length() - 1);

                Vertex start = vertexExists(start_char);
                if (start == null) {
                    start = new Vertex(start_char, false);
                    g.add(start);
                }

                Vertex end = vertexExists(end_char);
                if (end == null) {
                    end = new Vertex(end_char, false);
                    g.add(end);
                }

                // Add an edge from start vertex to end vertex
                addEdge(start, end);
            }
        }

        // This method returns the vertex with a given value if it
        // already exists in the graph, returns NULL otherwise
        Vertex vertexExists(char value) {
            for (int i = 0; i < g.size(); i++) {
                if (g.get(i).getValue() == value) {
                    return g.get(i);
                }
            }
            return null;
        }

        // This method returns TRUE if all nodes of the graph have
        // been visited
        boolean allVisited() {
            for (int i = 0; i < getG().size(); i++) {
                if (getG().get(i).isVisited() == false) {
                    return false;
                }
            }
            return true;
        }

        // This method adds an edge from start vertex to end vertex by
        // adding the end vertex in the adjacency list of start vertex
        // It also adds the start vertex to the in_vertices of end vertex
        void addEdge(Vertex start, Vertex end) {
            start.getAdj_vertices().add(end);
            end.getIn_vertices().add(start);
        }

        // This method returns TRUE if out degree of each vertex is equal
        // to its in degree, returns FALSE otherwise
        boolean outEqualsIn() {
            for (int i = 0; i < getG().size(); i++) {
                int out = getG().get(i).getAdj_vertices().size();
                int in = getG().get(i).getIn_vertices().size();
                if (out != in) {
                    return false;
                }
            }
            return true;
        }

        // This method returns TRUE if the graph has a cycle containing
        // all the nodes, returns FALSE otherwise
        boolean checkCycleRec(Vertex node,
                              Vertex starting_node) {

            node.setVisited(true);

            // Base case
            // return TRUE if all nodes have been visited and there
            // exists an edge from the last node being visited to
            // the starting node
            List<Vertex> adj = node.getAdj_vertices();
            if (allVisited()) {
                for (int i = 0; i < adj.size(); i++) {
                    if (adj.get(i) == starting_node) {
                        return true;
                    }
                }
            }

            // Recursive case
            for (int i = 0; i < adj.size(); i++) {
                if (adj.get(i).isVisited() == false) {
                    node = adj.get(i);
                    if (checkCycleRec(node, starting_node)) {
                        return true;
                    }
                }
            }
            return false;
        }

        protected boolean checkCycle(int list_size) {
            if (list_size < 2) {
                return false;
            }

            if (g.size() > 0) {
                if (outEqualsIn()) {
                    return checkCycleRec(getG().get(0),
                            getG().get(0));
                }
            }
            return false;
        }
    }


    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("eve", "eat", "ripe", "tear"));
        Graph g = new Graph(new ArrayList<>());
        g.createGraph(list);
        System.out.println(list);

        boolean result = g.checkCycle(list.size());
        String output = result ? "All strings should form chain" : "All strings should not form chain";
        System.out.println("Result: " + output);
    }
}
