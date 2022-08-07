package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class A_ExecutorServiceWithRunnable {

	public static void main(String[] args) {
		int task=1;
		ExecutorService executor =  Executors.newFixedThreadPool(5);
		
		for(int i =0;i<10;i++) {
			executor.execute(new A(task++));
		}
		executor.shutdown();
		while(!executor.isShutdown()) {	}
	}
	
	static class A implements Runnable{
		int taskNumber;
		public A(int taskNumber) {
			this.taskNumber=taskNumber;
		}
		public void run() {
			System.out.println("task: "+taskNumber +" => "+Thread.currentThread().getName());
		}
	}
}
