package queue;

public class Main {
	
	public static void main(String[] args) throws Exception {
		CustomQueue cq = new CustomQueue();
		cq.insert(1);
		cq.insert(-2);
		cq.insert(3);
		cq.insert(-10);
		
		cq.display();
		System.out.println(cq.remove());
		System.out.println(cq.remove());
		cq.display();
		
		System.out.println("========================================================");
		
		CircularQueue cqq= new CircularQueue();
		cqq.insert(1);
		
		cqq.insert(-2);
		
		cqq.insert(3);
		
		cqq.insert(-10);
		
		cqq.insert(-10);
		cqq.insert(-10);
		cqq.insert(-10);
		cqq.insert(-10);
		cqq.insert(-10);
		cqq.insert(6);
		cqq.insert(-20);
		cqq.insert(-30);
		
		
	
		
		cqq.display();
		System.out.println(cqq.remove());
		System.out.println(cqq.remove());
		System.out.println(cqq.remove());
		cqq.display();
	}
}
