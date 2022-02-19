package java.collections;

public class Student {

	
	int studentId;
	String name;
	String fatherName;
	
	Student(int studentId, String name, String fatherName){
		this.studentId=studentId;
		this.name=name;
		this.fatherName=fatherName;
	}
	
	public void setStudentId(int studentId) {
		this.studentId =studentId;
	}
	
	public int getStudentId() {
		return this.studentId;
	}
	
	public void setName(String name) {
		this.name =name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public int hashCode() {
		return (int)this.name.charAt(0);
	}
	
	@Override
	public boolean equals(Object o) {
		Student s =(Student)o;
		return this.name.equals(s.getName());
	}
	
	
}
	