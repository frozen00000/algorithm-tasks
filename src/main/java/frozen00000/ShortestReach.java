package frozen00000;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem
 */
public class ShortestReach {

    private static class Node {

        private int id;
        private Set<Node> linkedNodes = new HashSet<>();

        Node(int id) {
            this.id = id;
        }

        void link(Node node) {
            linkedNodes.add(node);
            node.linkedNodes.add(this);
        }

        void shortestReach(int[] ranges) {
            Queue<Node> current = new LinkedList<>();
            current.addAll(linkedNodes);
            int level = 6;
            int count = linkedNodes.size();
            while (!current.isEmpty()) {
                Node node = current.poll();
                count--;
                if (ranges[node.id] < 0) {
                    ranges[node.id] = level;
                    for (Node c : node.linkedNodes) {
                        if (ranges[c.id] < 0) {
                            current.add(c);
                        }
                    }
                }
                if (count == 0) {
                    count = current.size();
                    level += 6;
                }
            }
        }

    }

    public static class Graph {

        private Map<Integer, Node> nodes;
        private int size;

        public Graph(int size) {
            nodes = new HashMap<>(size);
            this.size = size;
        }

        public void addEdge(int first, int second) {
            Node a = nodes.computeIfAbsent(first, Node::new);
            Node b = nodes.computeIfAbsent(second, Node::new);
            a.link(b);
        }

        public int[] shortestReach(int startId) { // 0 indexed
            Node node = nodes.get(startId);
            int[] ranges = new int[size];
            Arrays.fill(ranges, -1);
            if (node != null) {
                node.shortestReach(ranges);
            }
            return ranges;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    if (i != distances.length - 1) {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }

        scanner.close();
    }


}
