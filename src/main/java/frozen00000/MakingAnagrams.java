package frozen00000;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Function;

/**
 * https://www.hackerrank.com/challenges/ctci-making-anagrams
 */

public class MakingAnagrams {

    private static void traverse(HashMap<Character, Integer> map, String value, Function<Integer, Integer> mapper) {
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            map.compute(c, (k, v) -> mapper.apply(v));
        }
    }

    private static int numberNeeded(String first, String second) {
        HashMap<Character, Integer> map = new HashMap<>();
        traverse(map, first, v -> v == null ? 1 : v + 1);
        traverse(map, second, v -> v == null ? -1 : v - 1);
        return map.values().stream().mapToInt(Math::abs).sum();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }

}
