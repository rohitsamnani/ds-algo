package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Stream : 
//stream(); return stream can be reference to Stream<> 
//filter(); accepts Predicate as args and return Stream only
//map();  accepts Function as args and retrun stream only
//collect() accepts Collectors.toList() and convert this as list

//Predicate only compare based on given conditions with true of false while Function map the result/produces result

//iterate : Stream.iterate(seed, unary operator like map's Function) iterate from 1 to many
//limit (): to decide limit
//forEach(Consumer) : to print/compute for Each
//reduce(): take sequence of elements to provide result in reduction, sum of 2 elements etc
public class StreamExample {
	
	public static void main(String[] args) {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1,"Rohit",2700f));
		list.add(new Product(2,"Mohit",3800f));
		list.add(new Product(3,"Lohit",8800f));
		list.add(new Product(4,"Pohit",1800f));
		list.add(new Product(5,"Oohit",3200f));
		list.add(new Product(6,"Uohit",3400f));
		list.add(new Product(7,"Tohit",6700f));
		
		List<Float> list1=list.stream().filter(x->x.price>3000f).map(x->x.price).collect(Collectors.toList());
		System.out.print(list1);
		System.out.println();
		
		List<Integer>list3=Stream.iterate(1,x->x+1).filter(x->x%5==0).limit(5).collect(Collectors.toList());
		System.out.println(list3);
		System.out.println("hi");
		
		Stream.iterate(1, x->x+1).filter(x->x%5==0).limit(6).forEach(x->{System.out.print(x+" ");});
		System.out.println("above and below both are same");
		Stream.iterate(1, x->x+1).filter(x->x%5==0).limit(6).forEach(System.out::println);

		//reduce : take the sum out of product price
		float total=list.stream().map(x->x.price).reduce(0.0f,(price,sum)->price+sum);
		float total1=list.stream().map(x->x.price).reduce(0.0f,Float::sum); //method reference
		System.out.println("total proice have to pay : "+total+"$");
		System.out.println("total proice have to pay(using method reference : "+total1+"$");
		
		//with using collectors
		System.out.println(list.stream().collect(Collectors.summingDouble(x->x.price)));
		
		//max and min and count
		Product minPriceProduct=list.stream().min((x,y)->x.price>y.price?1:-1).get();
		float maxPrice=list.stream().map(x->x.price).max((x,y)->x>y?1:-1).get();
		
		System.out.println("max is:"+maxPrice+ " & Min price is "+minPriceProduct.price);
		
		System.out.println(list.stream().filter(x->x.price%300==0).count());
		
		 Set<Product> productPriceList =   
		            list.stream()
		            .collect(Collectors.toSet());  
		
		 Map<Integer,String> productPriceMap = list.stream()  
		                        .collect(Collectors.toMap(p->p.id, p->p.name));  
		
		 //method reference
		  List<Float> Lllist =   
	                list.stream()  
	                            .filter(p -> p.price > 3000) // filtering data  
	                            .map(Product::getPrice)         // fetching price by referring getPrice method  
	                            .collect(Collectors.toList());  // collecting as list  
	        System.out.println(Lllist);  
	        
	        List<Integer> even=Stream.iterate(1, x->x+1).filter(x->x%2==0).limit(25).collect(Collectors.toList());
	        System.out.println(even);
	}

}
