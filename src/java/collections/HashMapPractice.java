package java.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapPractice {
	
	public static void main(String[] args) throws InterruptedException {
		
		HashMap<Student, String> hm = new HashMap<Student,String>();
		Student s1=new Student(1,"rahul","rajkumar");
		Student s2= new Student(1,"priyanka","rajkumar");
		hm.put(new Student(1,"rohit","rajkumar"), "Samnani");
		hm.put(s1, "Samnani");
		hm.put(s2, "Samnani");
		
		
		for (Map.Entry<Student,String> entry : hm.entrySet()) {
			System.out.println(((Student)entry.getKey()).getName()+" "+entry.getKey().hashCode());
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		System.out.println("--------------------------------------------------");
		LinkedHashMap<Student, String> hm1 = new LinkedHashMap<Student,String>();
		hm1.put(new Student(1,"rohit","rajkumar"), "Samnani");
		hm1.put(s2, "Samnani");
		hm1.put(s1, "Samnani");
		
		for (Map.Entry<Student,String> entry : hm1.entrySet()) {
			System.out.println(((Student)entry.getKey()).getName()+" "+entry.getKey().hashCode());
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
