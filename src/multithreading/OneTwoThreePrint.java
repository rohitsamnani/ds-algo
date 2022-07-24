package multithreading;

public class OneTwoThreePrint {

	Object lock = new Object();
	int counter = 0;

	public static void main(String[] args) {
		OneTwoThreePrint ott = new OneTwoThreePrint();
		new Thread(ott.new PrintOneTwoThree(0, 3)).start();
		new Thread(ott.new PrintOneTwoThree(1, 3)).start();
		new Thread(ott.new PrintOneTwoThree(2, 3)).start();
	}

	class PrintOneTwoThree implements Runnable {
		int id;
		int numOfThreads;

		public PrintOneTwoThree(int id, int numOfThreads) {
			this.id = id;
			this.numOfThreads = numOfThreads;
		}

		public void run() {
			try {
				printIt();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		private void printIt() throws InterruptedException {

			while (counter < 20) {
				synchronized (lock) {
					if (counter % numOfThreads != id) {
						lock.wait();
					} else {
						System.out.println(Thread.currentThread() + " : " + counter);
						counter++;
						lock.notifyAll();
					}
				}
			}
		}
	}
}