package designpattern;

public class SingletonTest {

	public static void main(String[] args) {
		DemoSingleton d1 = DemoSingleton.getInstance();
		DemoSingleton d2 = DemoSingleton.getInstance();
		//reflection, clone, serilization   => reflection through constructor mai return object, clone method override (return cloneNotSupportedException) and last serlization readResolve()  
		System.out.println(d1);
		System.out.println(d2);
	}
}
