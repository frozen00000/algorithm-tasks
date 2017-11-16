package frozen0000;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * The task is described here: http://www.spoj.com/problems/PIGBANK/
 *
 * See also: https://en.wikipedia.org/wiki/Knapsack_problem
 *
 */

class Coin {

    final int p; // value of the coin in monetary units
    final int w; // weight in grams

    Coin(int p, int w) {
        this.p = p;
        this.w = w;
    }

}

public class PigBank { // For applying solution on Spoj you need to rename class. It shoud be called "Main".

    private final int coinsTotalWeight;

    /**
     * 1 <= E <= F <= 10000
     * @param e weight of an empty pig
     * @param f pig filled with coins
     */
    private PigBank(final int e, final int f) {
        coinsTotalWeight = f - e;
    }

    /**
     * @return The minimum amount of money
     */
    private long getMinimumAmountOfMoney(final List<Coin> coins) {
        long[] m = new long[coinsTotalWeight + 1];
        Arrays.fill(m, 1, m.length, Long.MAX_VALUE);
        for (int i = 1; i < m.length; i++) {
            int w = i;
            m[i] = coins.stream()
                    .filter(c -> w - c.w >= 0)
                    .map(c -> {
                        long v = m[w - c.w];
                        return v == Long.MAX_VALUE ? v : c.p + v;
                    })
                    .min(Long::compareTo)
                    .orElse(Long.MAX_VALUE);
        }
        return m[coinsTotalWeight];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int t = scanner.nextInt(); // count of test cases
        for (int i = 0; i < t; i++) {
            PigBank pigBank = new PigBank(scanner.nextInt(), scanner.nextInt());
            int n = scanner.nextInt(); // 1 <= N <= 500
            List<Coin> coins = IntStream.range(0, n).boxed()
                    .map(j -> new Coin(scanner.nextInt(), scanner.nextInt())) // P and W (1 <= P <= 50000, 1 <= W <=10000)
                    .collect(Collectors.toList());
            long result = pigBank.getMinimumAmountOfMoney(coins);
            if (result != Long.MAX_VALUE) {
                System.out.println(String.format("The minimum amount of money in the piggy-bank is %d.", result));
            } else {
                System.out.println("This is impossible.");
            }
        }
    }

}
