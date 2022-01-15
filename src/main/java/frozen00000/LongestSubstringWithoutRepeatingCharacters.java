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
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    static int longestSubstringWithoutRepeatingCharacters(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int max = 0;
        int[] m = new int[256];
        Arrays.fill(m, -1);
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (m[a] > -1) {
                j = Math.max(j, m[a] + 1);
            }
            max = Math.max(max, i - j + 1);
            m[a] = i;
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();
        int result = longestSubstringWithoutRepeatingCharacters(s);
        System.out.println(result);
        scanner.close();
    }

}
