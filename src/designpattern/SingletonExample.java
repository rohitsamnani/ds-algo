package designpattern;

public class SingletonExample {
	
	private static volatile SingletonExample singleton = null;
	
	private SingletonExample() {
	}
	
	public static SingletonExample getSingletonExampleInstance() {
		if(singleton==null) {
			synchronized (SingletonExample.class) {
			if(singleton==null)
				singleton= new SingletonExample();
			}
		}
		return singleton;
	}
}
