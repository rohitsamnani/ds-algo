package binarysearch;

//find ceiling of a given target in a sorted array, ceiling means either number or next element (max) of that target 
public class CeilingOfNumber {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5, 9, 14, 16, 18 };
		int target = 15;
		System.out.println(getCeiling(arr, target));
	}

	private static int getCeiling(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] > target) {
				end = mid - 1;
			} else if (arr[mid] < target) {
				start = mid + 1;
			} else {
				return target;
			}
		}

		return arr[start];
	}
}
