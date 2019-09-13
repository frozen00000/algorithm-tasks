package frozen00000;

import java.util.*;
import java.util.stream.Collectors;


/**
 *  https://www.hackerrank.com/challenges/crossword-puzzle?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking
 */
public class CrosswordPuzzle {

    static class CrosswordPuzzleSolver {

        private final char space;

        CrosswordPuzzleSolver(char space) {
            this.space = space;
        }

        String[] solve(char[][] data, String wordsLine) {
            return traverse(data, wordsLine)
                    .map(charMatrix -> Arrays.stream(charMatrix).map(String::new).toArray(String[]::new))
                    .orElse(new String[] {""});
        }

        Optional<char[][]> traverse(char[][] data, String wordsLine) {
            List<String> words = Arrays.asList(wordsLine.split(";"));
            if (words.size() == 0) {
                return Optional.of(data);
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (data[i][j] == '-') {
                        int maxj = j;
                        int maxi = i;
                        int mini = i;
                        int minj = j;
                        for (; hasNextChar(i, minj - 1, data); minj--) {}
                        for (; hasNextChar(i, maxj + 1, data); maxj++) {}
                        for (; hasNextChar(mini - 1, j, data); mini--) {}
                        for (; hasNextChar(maxi + 1, j, data); maxi++) {}
                        int verticalLength = maxi - mini + 1;
                        int horizontalLength = maxj - minj + 1;
                        if (horizontalLength > 1 || (verticalLength == 1 && horizontalLength == 1)) {
                            Optional<char[][]> result = traverse(data, mini, minj, horizontalLength, wordsLine, words, true);
                            if (result.isPresent()) {
                                return result;
                            }
                        }
                        if (verticalLength > 1) {
                            Optional<char[][]> result = traverse(data, mini, minj, verticalLength, wordsLine, words, false);
                            if (result.isPresent()) {
                                return result;
                            }
                        }
                        return Optional.empty();
                    }
                }
            }
            return Optional.empty();
        }

        private Optional<char[][]> traverse(char[][] data, int i, int j, int verticalLength, String wordsLine,
                                            List<String> words, boolean horizontal) {
            List<String> alternatives = words.stream()
                    .filter(w -> w.length() == verticalLength).collect(Collectors.toList());
            if (alternatives.size() == 0) {
                return Optional.empty();
            } else {
                return traverse(data, wordsLine, alternatives, i, j, horizontal);
            }
        }

        private Optional<char[][]> traverse(char[][] data, String wordsLine, List<String> alternatives,
                                                   int i, int j, boolean horizontal) {
            return alternatives.stream()
                    .map(w -> {
                        char[][] alternative = deepCopy(data);
                        for (int k = 0; k < w.length(); k++) {
                            if (horizontal) {
                                if (alternative[i][j + k] == '-') {
                                    alternative[i][j + k] = w.charAt(k);
                                } else if (alternative[i][j + k] != w.charAt(k)) {
                                    return Optional.<char[][]>empty();
                                }
                            } else {
                                if (alternative[i + k][j] == '-') {
                                    alternative[i + k][j] = w.charAt(k);
                                } else if (alternative[i + k][j] != w.charAt(k)) {
                                    return Optional.<char[][]>empty();
                                }
                            }
                        }
                        return traverse(alternative, wordsLine.replaceFirst(w, ""));
                    })
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .findFirst();
        }

        private char[][] deepCopy(char[][] matrix) {
            return Arrays.stream(matrix).map(char[]::clone).toArray(a -> matrix.clone());
        }

        private boolean hasNextChar(int i, int j, char[][] data) {
            return i >= 0 && i < 10 && j >= 0 && j < 10 && data[i][j] != space;
        }

    }

    private static String[] crosswordPuzzle(String[] crossword, String wordsLine) {
        char[][] data = new char[10][10];
        for (int i = 0; i < 10; i++) {
            data[i] = crossword[i].toCharArray();
        }
        char space = Arrays.stream(crossword).anyMatch(s -> s.contains("+")) ? '+' : 'X';
        return new CrosswordPuzzleSolver(space).solve(data, wordsLine);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] crossword = new String[10];
        for (int i = 0; i < 10; i++) {
            crossword[i] = scanner.nextLine();
        }
        Arrays.stream(crosswordPuzzle(crossword, scanner.nextLine())).forEach(System.out::println);
        scanner.close();
    }

}
