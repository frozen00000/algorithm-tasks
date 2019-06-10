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
public class CommonChild {

    static int commonChild(String s1, String s2){
        int[][] c = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    c[i + 1][j + 1] = c[i][j] + 1;
                } else {
                    c[i + 1][j + 1] = Math.max(c[i + 1][j], c[i][j + 1]);
                }
            }
        }
        return c[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int result = commonChild(s1, s2);
        System.out.println(result);
    }

}
