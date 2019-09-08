package frozen00000;

import java.util.*;

/**
 *
 */
public class MaxArraySum {

    static int maxSubsetSum(int[] array) {
        int include = Math.max(array[0], 0);
        int exclude = 0;
        int temp;
        for (int i = 1; i < array.length; i++) {
            temp = include;
            include = Math.max(include, exclude + array[i]);
            exclude = temp;
        }
        return Math.max(include, exclude);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int q = scanner.nextInt();
        int[] array = new int[q];
        for (int i = 0; i < q; i++) {
            array[i] = scanner.nextInt();
        }
        int result = maxSubsetSum(array);
        System.out.println(result);
    }

}
