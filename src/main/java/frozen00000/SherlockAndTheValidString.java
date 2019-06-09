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
public class SherlockAndTheValidString {

    // Complete the sherlockAndTheValidString function below.
    static String sherlockAndTheValidString(String s) {
        int offset = 'a';
        int size = ('z' - 'a') + 1;
        int[] freq = new int[size];
        for (char c : s.toCharArray()) {
            freq[c - offset]++;
        }
        int c = freq[0];
        boolean replaceRequired = false;
        for (int v : freq) {
            if (v > 0 && c != v) {
                if (!replaceRequired) {
                    replaceRequired = true;
                } else {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String result = sherlockAndTheValidString(s);
        System.out.println(result);
    }

}
