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
public class SpecialPalindromeAgain {

    static class Item {
        char c;
        long length;

        Item(char c, long length) {
            this.c = c;
            this.length = length;
        }
    }

    static long specialPalindromeAgain(int n, String s) {

        List<Item> items = new ArrayList<>();

        char c = s.charAt(0);
        long counter = 1;
        for (int i = 1; i < s.length(); i++) {
            char a = s.charAt(i);
            if (c == a) {
                counter++;
            } else {
                items.add(new Item(c, counter));
                counter = 1;
            }
            c = a;
        }
        items.add(new Item(c, counter));

        counter = 0;
        for (int i = 0; i < items.size() - 2; i++) {
            Item i1 = items.get(i);
            Item i2 = items.get(i + 1);
            Item i3 = items.get(i + 2);
            if (i1.c == i3.c && i2.length == 1) {
                counter += Math.min(i1.length, i3.length);
            }
        }

        return items.stream().mapToLong(i -> i.length * (i.length + 1) / 2).sum() + counter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String s = scanner.nextLine();
        long result = specialPalindromeAgain(n, s);
        System.out.println(result);
    }

}
