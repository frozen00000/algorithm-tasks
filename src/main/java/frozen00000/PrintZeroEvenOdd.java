package frozen00000;

import java.util.function.IntConsumer;

/**
 * https://leetcode.com/problems/print-zero-even-odd/
 */
public class PrintZeroEvenOdd {

	private final int n;
	private boolean zero = true;
	private boolean odd = false;

	private PrintZeroEvenOdd(int n) {
		this.n = n;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	private void zero(IntConsumer printNumber) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			synchronized (this) {
				while (!zero) {
					wait();
				}
				printNumber.accept(0);
				odd = !odd;
				zero = false;
				notifyAll();
			}
		}
	}

	private void even(IntConsumer printNumber) throws InterruptedException {
		for (int i = 2; i <= n; i+=2) {
			synchronized (this) {
				while (zero || odd) {
					wait();
				}
				printNumber.accept(i);
				zero = true;
				notifyAll();
			}
		}
	}

	private void odd(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i+=2) {
			synchronized (this) {
				while (zero || !odd) {
					wait();
				}
				printNumber.accept(i);
				zero = true;
				notifyAll();
			}
		}
	}

	public static void main(String[] args) {
		var instance = new PrintZeroEvenOdd(2);
		ExecutionUtils.run(
				() -> instance.odd(System.out::print),
				() -> instance.even(System.out::print),
				() -> instance.zero(System.out::print)
		);
	}
}
