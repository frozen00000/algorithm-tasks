package frozen00000;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem
 */

public class IceCreamParlor {

    private static void solve(int[] arr, int money) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int n = money - arr[i];
            if (n > 0) {
                Integer index = map.get(n);
                if (index != null) {
                    System.out.printf("%d %d%s", index + 1, i + 1, System.lineSeparator());
                    break;
                }
            }
            map.put(arr[i], i);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int money = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            solve(arr, money);
        }
        in.close();
    }

}
