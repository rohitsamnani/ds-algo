package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumerExamples {
	
	public static void main(String[] args) {
		printNamesWithConsumer();
		System.out.println();
		printNamesWithConsumerAnotherWay();
	}

	private static void printNamesWithConsumerAnotherWay() {
		Stream.of("rohit","mohit","lohit").forEachOrdered(t->System.out.println(t));
		
		System.out.println();
		Consumer<List<String>> consumer1 = list -> list.stream().forEach(System.out::println);
		Consumer<List<String>> consumer2 = list -> {
			for(int i=0;i<list.size();i++) {
				list.set(i, list.get(i).toUpperCase());
			}
		};
		
		consumer1.andThen(consumer2).andThen(consumer1).accept(Arrays.asList("rohit","mohit","lohit"));
	}

	private static void printNamesWithConsumer() {
		
		String[] names = {"rohit","mohit","lohit"};
		List<String> names1=Arrays.asList(names);
		Consumer<String> printNames = t->System.out.println(t);
		names1.stream().forEach(printNames);
	}

}
