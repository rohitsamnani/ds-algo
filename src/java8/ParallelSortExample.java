package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParallelSortExample {
	
	public static void main(String[] args) {
		
		 int[] arr = {5,8,1,0,6,9};  
		  for (int i : arr) {  
	            System.out.print(i+" ");  
	        }  
		  System.out.println();
		
		  Arrays.parallelSort(arr);
		  
		  for (int i : arr) {  
	            System.out.print(i+" ");  
	        }  
		  
		  System.out.println();
		  
		  Product[] p = new Product[5];
		  p[0] = new Product(1,"Rohit",2700f);
		  p[1]= new Product(2,"Mohit",3800f);
		  p[2]= new Product(3,"pohit",6800f);
		  p[3]= new Product(4,"oohit",5800f);
		  
		  //Arrays.parallelSort(p,(x,y)->x.name.compareTo(y.name));   not working
		  
		  List<Product> list = new ArrayList<Product>();
		  list.add(new Product(1,"Rohit",2700f));
		  list.add(new Product(2,"wohit",1700f));
		  list.add(new Product(3,"eohit",3700f));
		  list.add(new Product(4,"tohit",5700f));
		  
		  Collections.sort(list,(x,y)->x.name.compareTo(y.name));	//working
		  Collections.sort(list,(x,y)->x.price>y.price?1:-1);
		  for(Product p1: list) {
			  System.out.println(p1.price);
		  }
		  
	}

}
