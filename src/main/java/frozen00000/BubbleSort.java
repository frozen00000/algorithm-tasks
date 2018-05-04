package frozen00000;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-bubble-sort
 */
public class BubbleSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j && a[i] > a[j]) {
                    int buf = a[i];
                    a[i] = a[j];
                    a[j] = buf;
                    swaps++;
                }
            }
        }
        System.out.printf("Array is sorted in %d swaps.\n", swaps);
        System.out.printf("First Element: %d\n", a[0]);
        System.out.printf("Last Element: %d", a[n - 1]);
    }

}
