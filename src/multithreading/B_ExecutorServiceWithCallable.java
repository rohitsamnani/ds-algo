package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class B_ExecutorServiceWithCallable {

	public static void main(String[] args) throws Exception {
		ExecutorService es = Executors.newFixedThreadPool(10);
		
		//plain sinlge callable service
		Future<String> future1 = es.submit(new A());
		Future<String> future2= es.submit(new A());
		
		System.out.println(future1.get());
		System.out.println(future2.get());
		
		
		//Callable service with multiple exectuuin and result, take all result into futureList and we can go for printing the outcome, one by one in loop
		List<Future<Integer>> futureList=new ArrayList<>();
		for(int i=0;i<10;i++) {
			Future<Integer> future= es.submit(new B());
			futureList.add(future);
		}
		for(Future<Integer> f : futureList) {
			System.out.println(f.get());
		}
		
		es.shutdown();
	}
	
	static class A implements Callable<String>{
		public String call() {
			return Thread.currentThread().getName();
		}
	}
	static class B implements Callable<Integer>{
		
		public Integer call() throws Exception {
			return new Random().nextInt();
		}
	}
}