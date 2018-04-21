package frozen00000;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-find-the-running-median/problem
 */
class MedianHandler {

    private PriorityQueue<Integer> min;
    private PriorityQueue<Integer> max;
    private int middle;
    private int size;

    MedianHandler(int capacity) {
        min = new PriorityQueue<>(capacity / 2, Comparator.reverseOrder());
        max = new PriorityQueue<>(capacity / 2, Comparator.naturalOrder());
    }

    double add(int value) {
        size++;
        if (size == 1) {
            middle = value;
            return middle;
        } else if (size % 2 == 0) {
            if (middle < value) {
                min.add(middle);
                max.add(value);
            } else {
                min.add(value);
                max.add(middle);
            }
            return (min.peek() + max.peek()) / 2.0;
        } else {
            if (value > min.peek() && value < max.peek()) {
                middle = value;
            } else if (value <= min.peek()) {
                middle = min.poll();
                min.add(value);
            } else {
                middle = max.poll();
                max.add(value);
            }
            return middle;
        }
    }

}

public class RunningMedian {

    public static void main(String[] strings) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        MedianHandler medianHandler = new MedianHandler(n);
        for(int i = 1; i <= n; i++){
            System.out.printf("%.1f\n", medianHandler.add(in.nextInt()));
        }
    }

}
