package java8;

public class Product {

	int id;
	String name;
	float price;
	
	public Product(int id, String name, float price) {
		this.id=id;
		this.name=name;
		this.price=price;
	}
	
	public float getPrice() {
		return this.price;
	}
}
