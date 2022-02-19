package java8;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateExample {
	
	public static void main(String[] args) {
		filterNames();
	}

	private static void filterNames() {
		Predicate<String> p = str -> str.startsWith("S");
		
		Stream.of("rohit","mohit","Shobhit","Sagar").filter(p).forEach(k -> System.out.println(k));
		
	}

}
