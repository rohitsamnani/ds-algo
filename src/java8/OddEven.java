package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OddEven {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<10;i++) {
			list.add(i);	
		}
		
		list.stream().filter(x->x%2==1).forEach((x)-> System.out.print(x+" "));
		System.out.println();
		list.stream().map((x)->x*x).filter(x->x%2==0).forEach(x->System.out.print(x+" "));
		System.out.println();
		list=list.stream().map((x)->x*x).filter(x->x%2==0).collect(Collectors.toList());
		for(int l : list) {
			System.out.print(l+" ");
		}
		
		
	}

}
