package java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FetchFromStream {
	
	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(new Employee(1, "Rohit",700),new Employee(2, "Rahul",600), new Employee(3,"Ganesh",500));
		list.stream().filter((e)-> e.getScore()>=600).limit(10).forEach(e -> System.out.println(e.getName()));
		
		Map<String, String> map = new HashMap<>();
		map.put("Shawshank", "The Shawshank Redemption");
		
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach((e)-> System.out.println(e.getKey() + " : "+e.getValue()));
		
	}
}
