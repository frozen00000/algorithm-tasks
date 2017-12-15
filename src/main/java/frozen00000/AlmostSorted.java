package frozen00000;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;

/**
 * https://www.hackerrank.com/challenges/almost-sorted/problem
 */
public class AlmostSorted {

    private static BiFunction<Integer, Integer, Boolean> ASCENDING = (a, b) -> a < b;
    private static BiFunction<Integer, Integer, Boolean> DESCENDING = (a, b) -> a > b;
    private BiFunction<Integer, Integer, Boolean>[] comparingFunctions = new BiFunction[] {ASCENDING, DESCENDING};
    private byte currentComparing = 0;
    private BiFunction<Integer, Integer, Boolean> comparingFunction = ASCENDING;
    private int[] data;
    private List<Integer> indices = new ArrayList<>();

    private void readData() {
        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
    }

    private void toggleComparingFunction() {
        currentComparing = (byte) ((currentComparing + 1) % 2);
        comparingFunction = comparingFunctions[currentComparing];
    }

    private boolean canInsert(int[] a, int l, int r) {
        if (l > 0 && a[l - 1] > a[r]) {
            return false;
        }
        if (r < a.length - 1 && a[l] > a[r + 1]) {
            return false;
        }
        return a[r] <= a[l + 1] && a[l] >= a[r - 1];
    }

    private void solve() {
        readData();
        if (data.length == 1) {
            System.out.println("yes");
            return;
        }
        for (int i = 0; i < data.length - 1; i++) {
            if (!comparingFunction.apply(data[i], data[i + 1])) {
                indices.add(i);
                toggleComparingFunction();
            }
        }
        if (indices.isEmpty()) {
            System.out.println("yes");
            return;
        }
        if (indices.size() == 1) {
            int i = indices.get(0);
            if ((i == 0 || i == data.length - 2) && canInsert(data, i, i + 1)) {
                System.out.println("yes");
                System.out.printf("swap %d %d", i + 1, i + 2);
                return;
            }
        } else if (indices.size() == 2 || indices.size() == 4) {
            int i = indices.get(0);
            int j = indices.get(indices.size() - 1);
            if (canInsert(data, i, j)) {
                System.out.println("yes");
                System.out.printf("%s %d %d", j - i > 1 && indices.size() == 2 ? "reverse" : "swap", i + 1, j + 1);
                return;
            }
        }
        System.out.println("no");
    }

    public static void main(String[] args) {
        new AlmostSorted().solve();
    }

}
