package frozen00000;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
 */
public class LeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        for (int j = 0; j < n; j++) {
            int i = (j + k + n) % n;
            System.out.print(a[i] + " ");
        }
    }

}
