package frozen00000;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * URL: https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
 */
public class DavisStaircase {

    private static final Map<Integer, Integer> CACHE = new HashMap<>();

    private static int count(int s) {
        return CACHE.computeIfAbsent(s, n -> {
            if (n < 0) {
                return 0;
            } else if (n == 0) {
                return 1;
            } else {
                return count(n - 1) + count(n - 2) + count(n - 3);
            }
        });
    }

    public static void main(String[] args) {
       try (Scanner in = new Scanner(System.in)) {
           int p = in.nextInt();
           while (p-- > 0) {
                System.out.println(count(in.nextInt()));
           }
       }
    }

}
