package java.collections;

import java.util.Comparator;

public class StudentNameComprator implements Comparator<Student>{

	public int compare(Student s1, Student s2) {
		if(s1.getStudentId()==s2.getStudentId())
			return (s1.getName().compareTo(s2.getName()));
		else
			return s1.getStudentId()-s2.getStudentId();
	}
}
