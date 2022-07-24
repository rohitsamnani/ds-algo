package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreeNumberThreadPrinter {

	Object lock = new Object();
	AtomicInteger number = new AtomicInteger(1);
	static int counter =0;
	static int N=10;

	public static void main(String[] args) {
		ThreeNumberThreadPrinter n = new ThreeNumberThreadPrinter();
		Thread t1 = new Thread(n.new PrintIt(1, 3));
		Thread t2 = new Thread(n.new PrintIt(2, 3));
		Thread t3 = new Thread(n.new PrintIt(0, 3));
		t3.start();
		t2.start();
		t1.start();
	}

	class PrintIt implements Runnable {

		int threadId = 0;
		int totalThreadCount = 0;

		public PrintIt(int threadId, int totalThreadCount) {
			this.threadId = threadId;
			this.totalThreadCount = totalThreadCount;
		}

		public void run() {
			try {
				printIt();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private void printIt() throws InterruptedException {
			while (counter<=N) {
				Thread.sleep(1000l);
				synchronized (lock) {
					if (number.get() % totalThreadCount != threadId) {
						lock.wait();
					}
					else {
					System.out.println(Thread.currentThread() + " : " + number);
					number.getAndIncrement();
					lock.notifyAll();
					}
				}
				counter++;
			}
		}
	}
}
