package frozen00000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/cut-the-sticks/problem
 */
public class CutTheSticks {

    private static Integer[] cutTheSticks(int[] arr) {
        if (arr.length == 0) {
            return new Integer[0];
        }
        Arrays.sort(arr);
        List<Integer> result = new ArrayList<>();
        result.add(arr.length);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                result.add(arr.length - i);
            }
        }
        return result.toArray(new Integer[result.size()]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        Integer[] result = cutTheSticks(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
        in.close();
    }

}
