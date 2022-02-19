package java8;

import java.util.ArrayList;
import java.util.List;

public class LambdaFilter {

	public static void main(String[] args) {
		List<Integer> al = new ArrayList<Integer>();
		for(int i=1;i<=50;i++) {
			al.add(i);
		}
		System.out.println("Even num : ");
		al.stream().filter(x-> x%2==0).forEach(x->System.out.print(x+" "));
		System.out.println();
		System.out.println("Odd num : ");
		al.stream().filter(x-> x%2==1).forEach(y->System.out.print(y + " "));
	}
}
