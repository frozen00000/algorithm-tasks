package frozen00000;

/**
 * https://leetcode.com/problems/print-foobar-alternately/
 */
public class PrintFooBarAlternately {

	private int n;
	private boolean foo = true;

	private PrintFooBarAlternately(int n) {
		this.n = n;
	}

	private void foo(Runnable printFoo) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			synchronized (this) {
				while (!foo) {
					wait();
				}
				// printFoo.run() outputs "foo". Do not change or remove this line.
				printFoo.run();
				foo = !foo;
				notifyAll();
			}

		}
	}

	private void bar(Runnable printBar) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			synchronized (this) {
				while (foo) {
					wait();
				}
				// printBar.run() outputs "bar". Do not change or remove this line.
				printBar.run();
				foo = !foo;
				notifyAll();
			}

		}
	}

	public static void main(String[] args) {
		var instance = new PrintFooBarAlternately(3);
		ExecutionUtils.run(
				() -> instance.bar(() -> System.out.print("bar")),
				() -> instance.foo(() -> System.out.print("foo"))
		);
	}

}
