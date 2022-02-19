package java.collections;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
	
	public static void main(String[] args) {
	
		TreeMap<Student,String> tm = new TreeMap<Student, String>(new StudentNameComprator());
		tm.put(new Student(1,"rohit",""),"rohit");
		tm.put(new Student(2,"rahul",""),"rahul");
		tm.put(new Student(2,"gudiyaw",""),"Gudiya");
		System.out.println(tm);
		
		for(Map.Entry<Student,String> entry: tm.entrySet()) {
			System.out.println(((Student)entry.getKey()).getStudentId()+" "+entry.getValue());
		}
	}
}
