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
public class MinimumTimeRequired {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);
        long slowest = machines[machines.length - 1];
        long maxTime = goal * slowest;
        if (machines.length == 1) {
            return maxTime;
        }
        return search(machines, maxTime, goal);
    }

    private static long search(long[] machines, long maxTime, long goal) {
        long countOfItems;
        long minTime = 1;
        while (true) {
            if (minTime == maxTime) {
                return minTime;
            }
            long mid = (maxTime - minTime) / 2 + minTime;
            countOfItems = getCountOfItemsAtDay(machines, mid);
            if (countOfItems >= goal) {
                maxTime = mid;
            } else {
                minTime = mid + 1;
            }
        }
    }

    private static long getCountOfItemsAtDay(long[] machines, long day) {
        long sum = 0;
        for (long machine : machines) {
            sum += day / machine;
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        long goal = scanner.nextLong();
        long[] machines = new long[q];
        for (int i = 0; i < q; i++) {
            machines[i] = scanner.nextLong();
        }
        long result = minTime(machines, goal);
        System.out.println(result);
        scanner.close();
    }

}
