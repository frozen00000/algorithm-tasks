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
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigzagConversion {

    static String zigzagConversion(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int l = s.length();
        char[][] m = new char[l][numRows];
        for (int i = 0; i < l; i++) {
            m[i] = new char[numRows];
        }
        int x = 0;
        int y = 0;
        boolean down = true;
        for (int i = 0; i < s.length(); i++) {
            m[x][y] = s.charAt(i);
            if (down) {
                y++;
                if (y == numRows - 1) {
                    down = !down;
                }
            } else {
                y--;
                x++;
                if (y == 0) {
                    down = !down;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        char c = m[0][0];
        for (y = 0; y < numRows; y++) {
            for (x = 0; x < l; x++) {
                c = m[x][y];
                if (c != 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int numRows = scanner.nextInt();
            scanner.nextLine();
            String s = scanner.nextLine();
            String result = zigzagConversion(s, numRows);
            System.out.println(result);
        }
        scanner.close();
    }

}
