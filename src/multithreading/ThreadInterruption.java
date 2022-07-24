package multithreading;

public class ThreadInterruption {
	
	public static void main(String[] args) {
		ThreadInterruption ti= new ThreadInterruption();
		try {
		ABC th = ti.new ABC();
		th.t1= Thread.currentThread();
		th.start();
		Thread.sleep(1000);
		System.out.println("this will be unreachable after Interruption");
		}
		catch(InterruptedException e) {
			System.out.println("Thread interrupted");
		}
		
	}
	
	class ABC extends Thread{
		Thread t1;
		public void run() {
			t1.interrupt();
		}
	}
}
