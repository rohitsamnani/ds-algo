package heap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

//use min heap for sort the nearly sorted array
public class SortNearlySortedArray {

	public static void main(String[] args) {
		int[] arr = { 6, 5, 3, 2, 8, 10, 9 };
		sortNearlySortedArray(arr, 3);
		System.out.println(Arrays.toString(arr));
	}

	private static void sortNearlySortedArray(int[] arr, int kth) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < kth + 1; i++) {
			pq.add(arr[i]);
		}
		
		int length = arr.length;
		int index = 0;
		for (int i = kth + 1; i < length; i++) {
			arr[index++]=pq.peek();
			pq.poll();
			pq.add(arr[i]);
		}
		
		Iterator<Integer> itr=pq.iterator();
		
		while(itr.hasNext()) {
			arr[index++]=pq.peek();
			pq.poll();
		}
		
		/*
		 * while(!pq.isEmpty()) { arr[index++]=pq.peek(); pq.poll(); }
		 */
	}
}