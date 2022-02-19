package recurssion;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 6, 7, 8, 3, 0, 1, 10,-1,-2 };
		sort1(arr, 0, arr.length - 1);
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr, int low, int high) {
		
		if(low>high) {
			return;
		}
		
		int s=low;
		int e=high;
		int mid= s+(e-s)/2;
		int pivot= arr[mid];
		
		while(s<=e) {
			
			while(arr[s]<pivot) {
				s++;
			}
			while(arr[e]>pivot) {
				e--;
			}
			if(s<=e) {
				int temp=arr[s];
				arr[s]=arr[e];
				arr[e]=temp;
				s++;
				e--;
			}
		}
		sort(arr,low,e);
		sort(arr,s,high);
	}
	
	
	static void sort1(int[] arr, int low, int high) {
		
		if(low>high) {
			return;
		}
		int s=low; int e=high; int pivot = arr[s+(e-s)/2]; 
		while(s<=e) {
			while(arr[s]<pivot) {
				s++;
			}
			while(arr[e]>pivot) {
				e--;
			}
			if(s<=e) {
				int temp=arr[s];
				arr[s]=arr[e];
				arr[e]=temp;
				s++;
				e--;
			}
		}
		sort1(arr,low,e);
		sort1(arr,s,high);
	}
}
