package multithreading;

public class MultiThreadingBasics {
	static int counter = 1;
	static int N = 20;

	public static void main(String[] args) throws InterruptedException {

		MultiThreadingBasics mtb = new MultiThreadingBasics();
		Thread t1 = new Thread() {
			public void run() {
				mtb.printEvenNumber();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				mtb.printOddNumber();
			}
		};

		t1.start();
		t2.start();

	}

	protected void printOddNumber() {
		synchronized (this) {
			while (counter < N) {
				while (counter % 2 == 0 || counter%3 != 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread() + " : " + counter);
				notify();
				counter++;
			}
		}
	}

	protected void printEvenNumber() {
		synchronized (this) {
			while (counter < N) {
				while (counter % 2 == 1 || counter%3!=1) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread() + " : " + counter);
				notify();
				counter++;
			}
		}
	}
}