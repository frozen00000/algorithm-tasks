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
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class Calc {

    static int calc(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        s = s.replaceAll(" ", "");
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean isDigit = Character.isDigit(c);
            if (isDigit) {
                sb.append(c);
            }
            if ((!isDigit && ' ' != c) || i == s.length() - 1) {
                int a = Integer.parseInt(sb.toString());
                if (sign == '+') {
                    stack.push(a);
                } else if (sign == '-') {
                    stack.push(-a);
                } else if (sign == '*') {
                    stack.push(stack.pop() * a);
                } else { // '/'
                    stack.push(stack.pop() / a);
                }
                sign = s.charAt(i);
                sb = new StringBuilder();
            }
        }
        int r = 0;
        for(int i : stack) {
            r += i;
        }
        return r;
    }

    static String next(int start, String s) {
        StringBuilder sb = new StringBuilder();
        int i = start;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            sb.append(s.charAt(i++));
        }
        return sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();
        int result = calc(s);
        System.out.println(result);
        scanner.close();
    }

}
