package java8;

import java.util.function.BiConsumer;

public class BiConsumerExample {
	
	public static void main(String[] args) {
		BiConsumer<String,String> b = (x,y)-> System.out.println(x+y);
		b.accept("Sita", "Gita");
	}
}
