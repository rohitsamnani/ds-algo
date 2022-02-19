package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListToArray {

	public static void main(String[] args) {
		List<List<Integer>> mainList = new ArrayList<List<Integer>>();
		Random NewRandomNumber = new Random();
		int l=1;
		
		for (int i = 0; i < 3; i++) {
			List<Integer> SecondList = new ArrayList<Integer>();
			mainList.add(SecondList);
			for (int i2 = 0; i2 < 3; i2++) {
				SecondList.add(l++);
			}
	}
		System.out.println(mainList);
		Integer[][] arr = mainList.stream().map(u -> u.toArray(new Integer[3])).toArray(Integer[][]::new);
		System.out.println(arr[0][1]);
	}
}
