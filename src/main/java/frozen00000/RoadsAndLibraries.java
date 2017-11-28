package frozen00000;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/torque-and-development/problem
 */

class City {

    private boolean accessToLibrary = false;
    private Set<City> neighbors = new LinkedHashSet<>();

    public boolean hasNotAccessToLibrary() {
        return !accessToLibrary;
    }

    public void connect(City other) {
        neighbors.add(other);
        other.neighbors.add(this);
    }

    public void enableAccessToLibrary() {
        accessToLibrary = true;
    }

    public Set<City> getNeighbors() {
        return neighbors;
    }
}

public class RoadsAndLibraries {

    private static final Scanner IN = new Scanner(System.in);

    public static void main(String[] args) {
        int q = IN.nextInt();
        for(int i = 0; i < q; i++){
            System.out.println(getMinCost());
        }
    }

    private static long getMinCost() {
        int n = IN.nextInt();
        int m = IN.nextInt();
        long libraryPrice = IN.nextLong();
        long roadPrice = IN.nextLong();
        if (libraryPrice <= roadPrice) {
            // In this case it's cheaper to build a new library in each city instead of repairing any road.
            for(int a1 = 0; a1 < m * 2; a1++) {
                IN.nextInt(); // Just read all input for this case.
            }
            return n * libraryPrice;
        }
        Map<Integer, City> cities = readCities(n, m);
        long sum = 0;
        for (City c : cities.values()) {
            if (c.hasNotAccessToLibrary()) {
                sum += libraryPrice + (mark(c) - 1) * roadPrice;
            }
        }
        return sum + (n - cities.size()) * libraryPrice;
    }

    private static City nextCity(Map<Integer, City> cities) {
        return cities.computeIfAbsent(IN.nextInt() - 1, id -> new City());
    }

    private static Map<Integer, City> readCities(int n, int m) {
        Map<Integer, City> cities = new HashMap<>(n);
        for (int i = 0; i < m; i++){
            nextCity(cities).connect(nextCity(cities));
        }
        return cities;
    }

    /**
     * Marks the given city and all of the cities that can be reached from it.
     * @param city original city.
     * @return number of marked cities.
     */
    private static long mark(City city) {
        city.enableAccessToLibrary();
        return 1 + city.getNeighbors().stream()
                .filter(City::hasNotAccessToLibrary)
                .map(RoadsAndLibraries::mark)
                .reduce(Long::sum)
                .orElse(0L);
    }

}
