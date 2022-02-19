package recurssion;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 7, 6, 5, 4, 3, 2, 1 };
		int[] sortedArr = sort(arr);
		System.out.println(Arrays.toString(sortedArr));
		System.out.println(Arrays.toString(arr));
		sortInPlaceArray(arr, 0, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	private static void sortInPlaceArray(int[] arr, int s, int e) {
		if(s==e-1) {
			return; 
		}
		int mid = s+(e-s)/2;
		sortInPlaceArray(arr,s,mid);
		sortInPlaceArray(arr,mid,e);
		
		mergeInPlaceArray(arr,s,mid,e);
	}

	private static void mergeInPlaceArray(int[] arr, int s, int mid, int e) {

		int[] mix = new int[e - s];
		int i=s;
		int j=mid;
		int k = 0;
		while (i < mid && j < e) {
			if (arr[i] > arr[j]) {
				mix[k] = arr[j];
				j++;
			} else {
				mix[k] = arr[i];
				i++;
			}
			k++;
		}
		while (i < mid) {
			mix[k] = arr[i];
			i++;
			k++;
		}
		while (j < e) {
			mix[k] = arr[j];
			j++;
			k++; 
		}
		for(int l=0;l<mix.length;l++) {
			 	arr[s+l]=mix[l];
		}
	}


	private static int[] sort(int[] arr) {
		if (arr.length == 1) {
			return arr;
		}
		int mid = arr.length / 2;

		int[] left = sort(Arrays.copyOfRange(arr, 0, mid));
		int[] right = sort(Arrays.copyOfRange(arr, mid, arr.length));

		return merge(left, right);
	}

	private static int[] merge(int[] start, int[] end) {

		int[] arr1 = new int[start.length + end.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < start.length && j < end.length) {
			if (start[i] < end[j]) {
				arr1[k] = start[i];
				i++;
			} else {
				arr1[k] = end[j];
				j++;
			}
			k++;
		}

		while (i < start.length) {
			arr1[k] = start[i];
			i++;
			k++;
		}
		while (j < start.length) {
			arr1[k] = start[j];
			j++;
			k++;
		}
		return arr1;
	}
}
