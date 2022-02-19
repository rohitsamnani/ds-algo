package java8;

import java.util.function.Supplier;

public class SupplierExample {
	
	public static void main(String[] args) {
		printSuppiedValue();
	}

	private static void printSuppiedValue() {
		Supplier<Double> sup1 = ()-> Math.random();
		
		System.out.println(sup1.get());
		
		Supplier<String> sup2 = ()->"rohit";
		
		System.out.println(sup2.get());
	}
}
