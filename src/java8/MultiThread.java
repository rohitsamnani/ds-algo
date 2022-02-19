package java8;

public class MultiThread {
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(()-> System.out.println(Thread.currentThread().getName()));
		Thread t2= new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		});
		
		Thread t3 = new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		};
		t1.start();
		t2.start();
		t3.start();
	}

}
