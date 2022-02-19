package sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {2,-1,2,5,4,21,12,-19};
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void selectionSort(int[] arr) {
		int length = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			int maxIndex=0;
			for (int j = 0; j<arr.length-i; j++) {
				if (arr[j] > arr[maxIndex]) {
					maxIndex = j;
				}
			}
			int temp=arr[length];
			arr[length--]=arr[maxIndex];
			arr[maxIndex]=temp;
		}
	}

}
