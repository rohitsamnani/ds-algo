package queue;
//insert, display, remove, isFull, is Empty
public class CustomQueue {
	private static final int DEFAULT_SIZE=10;
	int e=0;
	int[] arr = null;
	public CustomQueue() {
		this(DEFAULT_SIZE);
	}
	public CustomQueue(int size) {
		arr = new int[size];
	}
	
	public boolean insert(int data) {
		if(arr.length==e) {
			return false;
		}
		arr[e++]=data;
		return true;
	}
	
	public int remove() throws Exception {
		if(e==0) {
			throw new Exception("array is empty");
		}
		int removal = arr[0];
		for(int i=1;i<arr.length;i++) {
			arr[i-1]=arr[i];
		}
		e--;
		return removal;
	}
	
	public void display() {
		for(int i=0;i<e;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}	
}
