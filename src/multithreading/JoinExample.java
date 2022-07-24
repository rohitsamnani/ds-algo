package multithreading;

public class JoinExample {
	
	public static void main(String[] args) throws InterruptedException {
		JoinExample je = new JoinExample();
		Thread t1 = new Thread(je.new ThreadJoin());
		Thread t2 = new Thread(je.new ThreadJoin());
		Thread t3 = new Thread(je.new ThreadJoin());
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
	}

	class ThreadJoin implements Runnable{
		public void run() {
			System.out.println(Thread.currentThread());
		}
	}
}
