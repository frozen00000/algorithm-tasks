package frozen00000;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-great-xor/problem
 */
public class TheGreatXOR {

    private static long theGreatXor(long x){
        long n = Long.highestOneBit(x) - 1;
        return n - (x & n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            long result = theGreatXor(x);
            System.out.println(result);
        }
    }

}
