package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceFixedThreadPool {

	public static void main(String[] args) {
		ExecutorService e = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			e.execute(new AThread("" + i));
		}
		e.shutdown();
		while (!e.isTerminated()) {
		}
		System.out.println("Finished All Threads");

	}
}
	class AThread implements Runnable {
		private String msg;

		public AThread(String msg) {
			this.msg = msg;
		}

		public void run() {
			System.out.println(Thread.currentThread().getName() + " => starts : " + msg);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " => ends : " + msg);
		}
	}
