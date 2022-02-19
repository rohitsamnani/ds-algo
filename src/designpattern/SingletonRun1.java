package designpattern;

public class SingletonRun1 {

	public static void main(String[] args) {
		SingletonExample s1= SingletonExample.getSingletonExampleInstance();
		SingletonExample s2=SingletonExample.getSingletonExampleInstance();
		if(s1.hashCode()==s2.hashCode()) {
			System.out.println("both are same only");
		}
	}
}
