package frozen00000;

import java.util.concurrent.Executors;

public class ExecutionUtils {

	interface Task {
		void run() throws InterruptedException;
	}

	static void run(Task... tasks) {
		var executor = Executors.newFixedThreadPool(tasks.length);
		for (var task : tasks) {
			executor.submit(() -> {
				try {
					task.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}
			});
		}
		executor.shutdown();
	}
}
