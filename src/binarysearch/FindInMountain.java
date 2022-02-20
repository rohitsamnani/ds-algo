package binarysearch;

public class FindInMountain {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5, 7, 10, 13, 14, 10, 5, 3, 2, 1 };
		int target = 10;
		System.out.println(findInMountainArray(target, arr));
	}

	private static int findInMountainArray(int target, int[] arr) {
		int peakIndex = peakIndex(arr);
		// search in first half which is asc order;
		int result = agnosticBinarySearch(arr, target, 0, peakIndex);
		if (result == -1) {
			// if not find in first hafl, search in second half which des order
			result = agnosticBinarySearch(arr, target, peakIndex + 1, arr.length - 1);
		}

		return result;
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

	private static int peakIndex(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] > arr[mid + 1]) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		// start and end are equal that mean they are pointing to the largest element in
		// the array. Dry run the above two
		// condition, and you will, able to see this.
		if (start == end) {
			return start;
		}
		return -1;
	}

}
