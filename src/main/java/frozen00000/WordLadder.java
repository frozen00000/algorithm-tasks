package frozen00000;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 *
 */
public class WordLadder {

    static class Node {
        String word;
        int counter;

        Node(String word, int counter) {
            this.word = word;
            this.counter = counter;
        }
    }

    static int wordLadder(String beginWord, String endWord, List<String> dictionary) {
        Set<String> dict = new HashSet<>(dictionary);
        if (!dict.contains(endWord)) {
            return 0;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(beginWord, 1));
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            String word = currentNode.word;
            System.err.println(currentNode.counter + " " + word);
            if (endWord.equals(word)) {
                return currentNode.counter;
            }
            for (int i = 0; i < word.length(); i++) {
                char[] array = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    if (array[i] == c) {
                        continue;
                    }
                    array[i] = c;
                    String w = new String(array);
                    if (dict.contains(w)) {
                        queue.add(new Node(w, currentNode.counter + 1));
                        dict.remove(w);

                    }
                }
            }
        }
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String beginWord = scanner.next();
        String endWord = scanner.next();
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        List<String> dictionary = new ArrayList<>(q);
        for (int i = 0; i < q; i++) {
            dictionary.add(scanner.nextLine());
        }
        int result = wordLadder(beginWord, endWord, dictionary);
        System.out.println(result);
        scanner.close();
    }

}
