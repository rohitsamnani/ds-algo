package binarysearch;

//this is different approach where we are hunt for pivot (max element of array)
public class SearchInRotatedArrayUsingPivot {

	public static void main(String[] args) {
		int[] arr = { 4,5,6,7, 0,1, 2 }; // rotated binary search
		int target = 2;

		System.out.println(searchUsingPivot(arr, target));
	}

	private static int searchUsingPivot(int[] arr, int target) {
		int pivotIndex = searchPiVot(arr);
		int result=-1;
		if(arr[pivotIndex]==target)
			return pivotIndex;
		else if(target<arr[0]) {
			result=agnosticBinarySearch(arr, target, pivotIndex+1, arr.length-1);
		}
		else {
			result=agnosticBinarySearch(arr, target, 0, pivotIndex);
		}

		return result;
	}

	private static int searchPiVot(int[] arr) {
			int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			// there will be 4 condition, 1st if mid element is greater than next element 13
			// is mid and mid+1 i. e 1 is smaller than 13.
			// 2nd will be mid is smaller than mid-1, here if mid is 1 then mid-1 will be
			// 13. (so two check are at 13 and 1 where trends changing rest all are upwards
			// trends)
			if (mid<end &&  arr[mid] > arr[mid + 1]) {
				return mid;
			} else if (mid>start && arr[mid] < arr[mid - 1]) {
				return mid - 1;
			} else if (arr[start] >= arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return -1;
	}

	private static int agnosticBinarySearch(int[] arr, int target, int start, int end) {
		boolean isAsc = arr[start] < arr[end];

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] > target) {
				if (isAsc) {
					end = mid - 1;

				} else {
					start = mid + 1;

				}

			} else if (arr[mid] < target) {
				if (isAsc) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else {
				return mid;
			}
		}

		return -1;
	}
}
