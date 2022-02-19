package java8;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionExample {
	
	public static void main(String[] args) {
		printNames();
	}

	private static void printNames() {
		
		Function<String, Integer> f = str-> str.length();
		
		List<Integer> i=Stream.of("rohit","mohitk").map(f).collect(Collectors.toList());
		System.out.println(i);
	}

}
