package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenUsingReentrantLock {

	static int counter = 1;
	ReentrantLock lock = new ReentrantLock(true);
	Condition odd = lock.newCondition();
	Condition even = lock.newCondition();

	public static void main(String[] args) {
		OddEvenUsingReentrantLock oes = new OddEvenUsingReentrantLock();
		new Thread(() -> oes.printOdd()).start();
		new Thread(() -> oes.printEven()).start();

	}

	private void printEven() {
		lock.lock();
		while (counter < 40) {
			while (counter % 2 != 0) {
				try {
					even.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread() + " : " + counter);
			counter++;
			odd.signal();
		}
		lock.unlock();
	}

	private void printOdd() {
		lock.lock();
		while (counter < 40) {
			while (counter % 2 != 1) {
				try {
					odd.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread() + " : " + counter);
			counter++;
			even.signal();
		}
		lock.unlock();
	}
}
