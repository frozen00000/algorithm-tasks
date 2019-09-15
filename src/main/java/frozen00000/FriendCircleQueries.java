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
public class FriendCircleQueries {

    static class Node {
        Node parent = this;
        int rank = 1;
    }

    static class Solution {

        private Map<Integer, Node> nodes;

        int[] maxCircle(int[][] queries) {
            nodes = new HashMap<>(queries.length);
			for (int[] query : queries) {
				addNode(query[0]);
				addNode(query[1]);
			}
            int[] result = new int[queries.length];
            int max = 0;
            for (int i = 0; i < queries.length; i++) {
                max = Math.max(union(queries[i][0], queries[i][1]), max);
                result[i] = max;
            }
            return result;
        }

        void addNode(int value) {
            nodes.computeIfAbsent(value, k -> new Node());
        }

        int union(int value1, int value2) {
			Node rootNode1 = getRoot(nodes.get(value1));
            Node rootNode2 = getRoot(nodes.get(value2));
            if (rootNode1 == rootNode2) {
                return  rootNode1.rank;
            }
            rootNode2.parent = rootNode1;
            rootNode1.rank += rootNode2.rank;
            return rootNode1.rank;
        }

        Node getRoot(Node node) {
            while (node.parent != node) {
                node = node.parent;
            }
            return node;
        }

    }

	static int[] maxCircle(int[][] queries) {
    	return new Solution().maxCircle(queries);
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        int[][] queries = new int[q][2];
        for (int i = 0; i < q; i++) {
            queries[i][0] = scanner.nextInt();
            queries[i][1] = scanner.nextInt();
        }
        Arrays.stream(maxCircle(queries)).forEach(System.out::println);
        scanner.close();
    }

}
