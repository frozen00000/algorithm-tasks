package frozen00000;

import java.util.Scanner;

/**
 *
 */
public class PaintHouse {

    private static int paintHouse(int[][] data) {
        return paint(data, 0, -1);
    }

    private static int paint(int[][] data, int houseIndex, int previousColor) {
        int[] house = data[houseIndex];
        int minCost = Integer.MAX_VALUE;
        for (int color = 0; color < 3; color++) {
            if (color == previousColor) {
                continue;
            }
            int cost = house[color];
            int nextCost = houseIndex + 1 < data.length ? paint(data, houseIndex + 1, color) : 0;
            minCost = Math.min(minCost, nextCost + cost);
        }
        return minCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        int[][] data = new int[q][];
        for (int i = 0; i < q; i++) {
            data[i] = new int[3];
            for (int j = 0; j < 3; j++) {
                data[i][j] = scanner.nextInt();
            }
        }
        int result = paintHouse(data);
        System.out.println(result);
        scanner.close();
    }

}
