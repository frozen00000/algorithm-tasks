package frozen00000;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 */
public class RansomNote {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }

        Map<String, Integer> map = Arrays.stream(magazine).collect(Collectors.toMap(s -> s, s -> 1, (a, b) -> a + b));
        for (String word : ransom) {
            map.compute(word, (k, v) -> v == null ? -1 : v - 1);
        }
        System.out.println(map.values().stream().allMatch(v -> v > -1) ? "Yes" : "No");
    }

}
