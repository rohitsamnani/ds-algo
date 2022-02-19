package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordFrequency {

	
	public static void main(String[] args) {
		
		String[] arr = {"hello", "bye", "ciao", "bye", "ciao"};
		List<String> list1= Arrays.asList(arr);
		Integer[] arr1= list1.stream().toArray(Integer[]::new);
		List<String> list= new ArrayList<>();		
	}
}
