package java8;

import java.util.ArrayList;
import java.util.List;

public class Interview1 {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=2000;i<=3200;i++) {
			list.add(i);
		}
		list.stream().filter((x)->(x%7==0 && x%5!=0)).forEach((x)->System.out.print(x + ","));
	}

}
