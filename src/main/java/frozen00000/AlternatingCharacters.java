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
public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int counter = 0;
        char a = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char b = s.charAt(i);
            if (a == b) {
                counter++;
            }
            a = b;
        }
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();
            int result = alternatingCharacters(s);
            System.out.println(result);

        }
        scanner.close();
    }

}
