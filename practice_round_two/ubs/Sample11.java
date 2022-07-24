package ubs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Sample11 {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		// 2+3 ,3+4, 4+5 = 5,7,9 => 5+7, 7+9 => 12,16 => 12+16 = 28
		
		int step = list.size()-1;
		int lastSize=0;
		
		while(step!=0) {
			int listSize = list.size();
			for(int i =lastSize;i<listSize-1;i++) {
				list.add(list.get(i)+list.get(i+1));
				
			}
			lastSize=listSize;
			step--;
		}
		
		System.out.println(list.get(list.size()-1));
		
		List<Integer> list1 = new ArrayList<>();
		list1.add(20);
		list1.add(3);
		list1.add(-40);
		list1.add(5);

		System.out.println(list1);
		List<Integer> list2=list1.stream().sorted().collect(Collectors.toList());
		System.out.println(list2);
		
	}

}
