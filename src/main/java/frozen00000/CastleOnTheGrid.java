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
public class CastleOnTheGrid {

    static class Point {
        int x;
        int y;
        int s;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point(Point point) {
            this.x = point.x;
            this.y = point.y;
            this.s = point.s + 1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        Point copy() {
            Point clone = new Point(this);
            clone.s = this.s;
            return clone;
        }

    }

    // Complete the minimumMoves function below.
    private static int minimumMoves(String[] grid, int startY, int startX, int goalY, int goalX) {
        char[][] g = new char[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                g[i][j] = grid[i].charAt(j);
            }
        }
        Queue<Point> queue = new ArrayDeque<>();
        Set<Point> visited = new HashSet<>();
        Point c = new Point(startX, startY);
        queue.add(c);
        while (queue.size() > 0) {
            c = queue.poll();
            if (c.x == goalX && c.y == goalY) {
                return c.s;
            }
            queue.addAll(getNextPoints(g, c, visited));
        }
        return -1;
    }

    private static Collection<Point> getNextPoints(char[][] g, Point c, Set<Point> visited) {
        List<Point> points = new ArrayList<>();
        // right
        Point p = new Point(c);
        while (p.x + 1 < g.length && g[p.y][p.x + 1] != 'X') {
            p.x++;
            addPoint(visited, points, p);
        }
        // left
        p = new Point(c);
        while (p.x - 1 >= 0 && g[p.y][p.x - 1] != 'X') {
            p.x--;
            addPoint(visited, points, p);
        }
        // top
        p = new Point(c);
        while (p.y - 1 >= 0 && g[p.y - 1][p.x] != 'X') {
            p.y--;
            addPoint(visited, points, p);
        }
        // bottom
        p = new Point(c);
        while (p.y + 1 < g.length && g[p.y + 1][p.x] != 'X') {
            p.y++;
            addPoint(visited, points, p);
        }
        return points;
    }

    private static void addPoint(Set<Point> visited, List<Point> points, Point p) {
        if (!visited.contains(p)) {
            Point copy = p.copy();
            points.add(copy);
            visited.add(copy);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.nextLine();
        String[] grid = new String[q];
        for (int i = 0; i < q; i++) {
            grid[i] = scanner.nextLine();
        }
        int result = minimumMoves(grid, scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.println(result);
        scanner.close();
    }

}
