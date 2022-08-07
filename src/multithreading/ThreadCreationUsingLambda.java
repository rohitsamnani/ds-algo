package multithreading;

public class ThreadCreationUsingLambda {
	public static void main(String[] args) {
		ThreadCreationUsingLambda tcul = new ThreadCreationUsingLambda();
		Runnable r = () -> System.out.println(Thread.currentThread());
		Thread t1 = new Thread();
		Thread t2 = new Thread(r);
		ABC abc = tcul.new ABC();
		t1.start();
		t2.start();
		abc.start();
	}
	
	class ABC extends Thread{
		public void run() {
			System.out.println(Thread.currentThread()+ " inside ABC class");
		}
	}

}
