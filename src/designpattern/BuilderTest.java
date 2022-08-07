package designpattern;

public class BuilderTest {
	
	public static void main(String[] args) {
		Coffee coffee = new Coffee.Builder().type("Mocha").size("Large").sugar(false).milk(true).build();
		System.out.println(coffee);
	}

}
