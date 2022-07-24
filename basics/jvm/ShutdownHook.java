package jvm;

public class ShutdownHook {
	
	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run() {
				System.out.println("add shutdown hook called");
			}
		});
		System.out.println("i got a call");
		System.exit(0);
	}

}
