package heap;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int arr[] = { 11, 10, 12, 14, 7, 13 };
		heapSort(arr);
		System.out.println("Sorted array is : " + Arrays.toString(arr));
	}

	private static void heapSort(int[] arr) {
		int n = arr.length;
		System.out.println(Arrays.toString(arr));
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr,i,n);
		}
		System.out.println("heapified Array is : "+Arrays.toString(arr));
		
		for(int i=n-1;i>0;i--) {
			//swap
			int temp= arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			heapify(arr,0,i);
		}

	}

	private static void heapify(int[] arr, int i, int n) {

		int largest = i;
		int leftNode = 2*i+1;
		int rightNode = 2*i+2;
		
		if(leftNode<n && arr[leftNode]>arr[largest])
			largest=leftNode;
		
		if(rightNode<n && arr[rightNode]>arr[largest])
			largest=rightNode;
		
		if(largest!=i) {
			
			//swap elements
			int temp=arr[i];
			arr[i]=arr[largest];
			arr[largest]=temp;
			heapify(arr,largest,n);
		}
	}
}
