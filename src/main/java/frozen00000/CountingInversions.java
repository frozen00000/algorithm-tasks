package frozen00000;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-merge-sort/problem
 */

class MergeSorter {

    private final int[] origin;
    private final int[] buffer;
    private long swaps;

    MergeSorter(int[] origin) {
        this.origin = origin;
        buffer = new int[origin.length];
    }

    long sort() {
        sort(0, origin.length - 1);
        return swaps;
    }

    private void sort(int s, int e) {
        int d = e - s;
        if (d >= 1) {
            int n = (e + s) / 2;
            if (s != n) {
                sort(s, n);
                sort(n + 1, e);
            }
            merge(s, n, e);
        }
    }

    private void merge(int s, int n, int e) {
        int li = s;
        int ri = n + 1;
        int t = s;
        while (li <= n) {
            if (ri > e || origin[li] <= origin[ri]) {
                buffer[t++] = origin[li++];
            } else {
                swaps += ri - t;
                buffer[t++] = origin[ri++];
            }
        }
        System.arraycopy(buffer, s, origin, s, t - s);
    }

}

public class CountingInversions {

    private static long countInversions(int[] arr) {
        return new MergeSorter(arr).sort();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            long result = countInversions(arr);
            System.out.println(result);
        }
        in.close();
    }

}
