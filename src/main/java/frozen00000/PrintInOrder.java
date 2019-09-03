package frozen00000;

import java.util.concurrent.CountDownLatch;

/**
 * https://leetcode.com/problems/print-in-order
 */
public class PrintInOrder {

	private CountDownLatch firstLatch = new CountDownLatch(1);
	private CountDownLatch secondLatch = new CountDownLatch(1);

	private void first(Runnable printFirst) throws InterruptedException {
		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		firstLatch.countDown();
	}

	private void second(Runnable printSecond) throws InterruptedException {
		firstLatch.await();
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		secondLatch.countDown();
	}

	private void third(Runnable printThird) throws InterruptedException {
		secondLatch.await();
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}

	public static void main(String[] args) {
		var instance = new PrintInOrder();
		ExecutionUtils.run(
				() -> instance.third(() -> System.out.print("3")),
				() -> instance.second(() -> System.out.print("2")),
				() -> instance.first(() -> System.out.print("1"))
		);
	}

}
