package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

//max heap
public class KthSmallestNumber {

	public static void main(String[] args) {
		int[] arr = {7, 10, 4, 3, 20, 15}  ;
		System.out.println(findKthSmallestNumber(arr, 4));
	}

	private static int findKthSmallestNumber(int[] arr, int kth) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b-a;
			}
		});
		
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
