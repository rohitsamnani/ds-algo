package heap;

import java.util.PriorityQueue;

//Min Heap
public class FindKthLargest {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 5, 7, 3, 2, 10, 21, 25, 51, 13 };
		System.out.println(findKthLargestNumber(arr, 5));
	}

	private static int findKthLargestNumber(int[] arr, int kth) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0;i<arr.length;i++) {
			pq.add(arr[i]);
			if(pq.size()>kth) {
				pq.remove();
			}
		}

		System.out.println(pq);
		return pq.poll();
	}
}
