package frozen00000;

import java.util.Scanner;

/**
 * http://codeforces.com/problemset/problem/588/A
 */
public class Duff {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        int[] a = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            p[i] = scanner.nextInt();
        }
        int minPrice = p[0];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] < minPrice) {
                minPrice = p[i];
            }
            sum += minPrice * a[i];
        }
        System.out.println(sum);
    }


}
