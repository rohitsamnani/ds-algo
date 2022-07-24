package jvm;

import java.util.LinkedList;

public class ProducerCosnumer {

	public static void main(String[] args) throws InterruptedException {

		PC pc = new PC();
		Thread t1 = new Thread() {
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}

}

class PC {
	LinkedList<Integer> list = new LinkedList<>();
	int capacity = 2;
	int element = 0;

	public void produce() throws InterruptedException {
		synchronized (this) {
			while (true) {
				while (list.size() == capacity) {
					wait();
				}
				System.out.println("produced " + element);
				list.add(element++);
				notify();
				Thread.sleep(1000);
			}
		}
	}

	public void consume() throws InterruptedException {
		synchronized (this) {
			while (true) {
				while (list.size() == 0) {
					wait();
				}

				int val = list.removeFirst();
				System.out.println("consumed " + val);
				notify();
				Thread.sleep(1000);

			}
		}
	}
}
