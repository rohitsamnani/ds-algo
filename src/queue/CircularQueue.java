package queue;

public class CircularQueue {

	int s = 0;
	int size = 0;
	private static final int DEFAULT_SIZE = 10;
	int e = 0;
	int[] arr = null;

	public CircularQueue() {
		this(DEFAULT_SIZE);
	}

	public CircularQueue(int size) {
		arr = new int[size];		
	}

	public boolean insert(int data) {
		int newIndex = (e % arr.length);
		arr[newIndex] = data;
		e++;
		size++;
		return true;
	}

	public int remove() {
		int data = arr[s++];
		return data;
	}

	public void display() {
		for (int i = s; i < size; i++) {
			if(i<arr.length)
				System.out.print(arr[i%arr.length] + " ");
		}
		System.out.println();
	}

}
