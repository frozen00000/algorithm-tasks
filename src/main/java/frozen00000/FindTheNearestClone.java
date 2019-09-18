package frozen00000;

import lombok.SneakyThrows;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 *
 */
public class FindTheNearestClone {

    static class Node {
        long color;
        int rank = 0;
        List<Node> links = new ArrayList<>();
        Node from;
    }

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // setup
        Node[] nodes = new Node[graphNodes];
        Deque<Node> queue = new ArrayDeque<>();
        int targetColorCount = 0;
        for (int i = 0; i < graphNodes; i++) {
            Node node = new Node();
            node.color = ids[i];
            if (node.color == val)  {
                targetColorCount++;
                node.rank = 1;
                node.from = node;
                queue.add(node);
            }
            nodes[i] = node;
        }
        if (targetColorCount < 2) {
            return -1;
        }
        for (int i = 0; i < graphFrom.length; i++) {
            Node a = nodes[graphFrom[i] - 1];
            Node b = nodes[graphTo[i] - 1];
            a.links.add(b);
            b.links.add(a);
        }
        // bfs
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            for (Node l : n.links) {
                if (l.color == val && l.from != n && n.from != l) {
                    return l.rank + n.rank - 1;
                } else if (l.rank < 1) {
                    l.rank = n.rank + 1;
                    l.from = n;
                    l.color = val;
                    queue.add(l);
                }
            }
        }
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] from = new int[m];
        int[] to = new int[m];
        for (int i = 0; i < m; i++) {
            from[i] = scanner.nextInt();
            to[i] = scanner.nextInt();
        }
        long[] ids = new long[n];
        for (int i = 0; i < n; i++) {
            ids[i] = scanner.nextInt();
        }
        int result = findShortest(n, from, to, ids, scanner.nextInt());
        System.out.println(result);
        scanner.close();
    }

}
