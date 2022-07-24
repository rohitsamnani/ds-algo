package jvm;

public class OddEvenPrint {
	static int N;
	int counter = 1;

	public static void main(String[] args) {
		N = 10;
		OddEvenPrint mt = new OddEvenPrint();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					mt.evenPrint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		// Create thread t2
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					mt.oddPrint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
	}

	public void evenPrint() throws InterruptedException {
		synchronized (this) {
		while (counter < N) {
			
				while (counter % 2 == 1)
					wait();
			
			System.out.println("even " + counter);
			counter++;
			notify();
		}
		}
	}

	public void oddPrint() throws InterruptedException {
		synchronized (this) {
		while (counter < N) {
			
				while (counter % 2 == 0) {
					wait();
				}
				System.out.println("odd " + counter);
				counter++;
				notify();
		}
			
			
		}
	}
}