package frozen00000;

import lombok.SneakyThrows;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Stream;

/**
 *
 */
public class Abbreviation {

    static String abbreviation(String a, String b) {
        boolean[][] dp = new boolean[b.length() + 1][a.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i++) {
            if (Character.isLowerCase(a.charAt(i - 1))) {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char ca = a.charAt(j - 1);
                char cb = b.charAt(i - 1);
                if (Character.isUpperCase(ca)) {
                    if (ca == cb) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    ca = Character.toUpperCase(ca);
                    if (ca == cb) {
                        dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        return dp[b.length()][a.length()] ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < q; i++) {
            System.out.println(abbreviation(scanner.nextLine(), scanner.nextLine()));
        }
        scanner.close();
    }

}
