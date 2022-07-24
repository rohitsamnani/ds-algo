package jvm;

public class LockingInThreads extends Thread {
	static LockingInThreads lit = new LockingInThreads();

	public void run() {
		synchronized (lit) {
		try {
			lit.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		lit.start();
		lit.show();
	}

	public void show() {
		System.out.println("show this");
	}
}
