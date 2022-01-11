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
 * https://leetcode.com/problems/minimum-area-rectangle
 */
public class MinArea {

    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            map.compute(point[0], (key, value) -> {
                if (value == null) {
                    value = new HashSet<Integer>();
                }
                value.add(point[1]);
                return value;
            });
        }
        Integer minArea = null;
        for (int i = 0; i < points.length; i++) {
            int[] pointi = points[i];
            for (int j = 0; j < points.length; j++) {
                int[] pointj = points[j];
                int area = getArea(pointi, pointj);
                if (area == 0 || (minArea != null && area > minArea)) {
                    continue;
                }
                int[] point1 = new int[] {pointi[0], pointj[1]};
                int[] point2 = new int[] {pointj[0], pointi[1]};
                if (exists(map, point1) && exists(map, point2)) {
                    minArea = area;
                }
            }
        }
        return minArea == null ? 0 : minArea;
    }

    int getArea(int[] point1, int[] point2) {
        if (point1[0] == point2[0] || point1[1] == point2[1]) {
            return 0;
        }
        return Math.abs(point2[0] - point1[0]) * Math.abs(point2[1] - point1[1]);
    }

    boolean exists(Map<Integer, Set<Integer>> map, int[] point) {
        Set<Integer> s = map.get(point[0]);
        if (s == null) {
            return false;
        }
        return s.contains(point[1]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String line = scanner.nextLine();
        line = line.replaceAll("(\\[|\\])", "");
        String[] numbers = line.split(",");
        int[][] coords = new int[numbers.length / 2][];
        for (int i = 0; i < numbers.length; i += 2) {
            coords[i / 2] = new int[] {Integer.parseInt(numbers[i]), Integer.parseInt(numbers[i + 1])};
        }
        int result = new MinArea().minAreaRect(coords);
        System.out.println(result);
        scanner.close();
    }

}
