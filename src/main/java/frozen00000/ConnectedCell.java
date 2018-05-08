package frozen00000;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem
 */

public class ConnectedCell {

    private static int getBiggestRegion(int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    int size = getSize(i, j, matrix);
                    if (max < size) {
                        max = size;
                    }
                }
            }
        }
        return max;
    }

    private static int getSize(int i, int j, int[][] matrix) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length ||
                matrix[i][j] != 1) {
            return 0;
        }
        matrix[i][j] = 2;
        return 1 + getSize(i - 1, j, matrix)
                + getSize(i + 1, j, matrix)
                + getSize(i, j + 1, matrix)
                + getSize(i, j - 1, matrix)
                + getSize(i + 1, j + 1, matrix)
                + getSize(i - 1, j - 1, matrix)
                + getSize(i + 1, j - 1, matrix)
                + getSize(i - 1, j + 1, matrix);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }

}
