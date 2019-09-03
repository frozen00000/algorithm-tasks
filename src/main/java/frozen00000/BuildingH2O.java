package frozen00000;

/**
 * https://leetcode.com/problems/building-h2o/
 */
public class BuildingH2O {

	private int h;
	private int o;

	private void reset() {
		h = 0;
		o = 0;
	}

	private void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		synchronized (this) {
			while (h > 1) {
				wait();
			}
			h++;
			// releaseHydrogen.run() outputs "H". Do not change or remove this line.
			releaseHydrogen.run();
			if (o == 1 && h == 2) {
				reset();
			}
			notifyAll();
		}
	}

	private void oxygen(Runnable releaseOxygen) throws InterruptedException {
		synchronized (this) {
			while (o > 0) {
				wait();
			}
			o++;
			// releaseOxygen.run() outputs "O". Do not change or remove this line.
			releaseOxygen.run();
			if (h == 2) {
				reset();
			}
			notifyAll();
		}
	}

	public static void main(String[] args) {
		var instance = new BuildingH2O();
		ExecutionUtils.run(
				() -> {
					for (int i = 0; i < 6; i++) {
						instance.hydrogen(() -> System.out.print("H"));
					}
				},
				() -> {
					for (int i = 0; i < 3; i++) {
						instance.oxygen(() -> System.out.print("O"));
					}
				}
		);
	}
}