package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class D_ScatterGatherWithCountDownLatch {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(2);
		A a = new A(latch);
		B b = new B(latch);

		new Thread(a).start();
		new Thread(b).start();
		latch.await(5000, TimeUnit.MILLISECONDS);
		System.out.println("Waiting for both");
	}

	static class A implements Runnable {
		CountDownLatch latch = null;

		public A(CountDownLatch latch) {
			this.latch = latch;
		}
		public void run() {
			latch.countDown();
			System.out.println(Thread.currentThread().getName());
		}
	}

	static class B implements Runnable {
		CountDownLatch latch = null;

		public B(CountDownLatch latch) {
			this.latch = latch;
		}

		public void run() {
			try {
				Thread.sleep(4000);
				latch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		}
	}
}
