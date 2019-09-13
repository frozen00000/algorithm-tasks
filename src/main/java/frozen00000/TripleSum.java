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
 * https://www.hackerrank.com/challenges/triple-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
 */
public class TripleSum {

    static long triplets(int[] ag, int[] bg, int[] cg) {
        int[] a = Arrays.stream(ag).distinct().sorted().toArray();
        int[] b = Arrays.stream(bg).distinct().sorted().toArray();
        int[] c = Arrays.stream(cg).distinct().sorted().toArray();
        int counter = 0;
        for (int value : b) {
            counter += countOfLessThreshold(a, value) * countOfLessThreshold(c, value);
        }
        return counter;
    }

    private static int countOfLessThreshold(int[] array, int threshold) {
        int c = 0;
        for (int i = 0; i < array.length && array[i] <= threshold; i++) {
            c++;
        }
        return c;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int aSize = scanner.nextInt();
        int bSize = scanner.nextInt();
        int cSize = scanner.nextInt();
        int[] a = new int[aSize];
        int[] b = new int[bSize];
        int[] c = new int[cSize];

        for (int i = 0; i < aSize; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < bSize; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = 0; i < cSize; i++) {
            c[i] = scanner.nextInt();
        }
        long result = triplets(a, b, c);
        System.out.println(result);
        scanner.close();
    }

}
