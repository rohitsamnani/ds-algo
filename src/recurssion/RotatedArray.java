package recurssion;

public class RotatedArray {

	public static void main(String[] args) {
		int[] arr = { 5, 6, 7, 8, 9, 10, 1, 2, 3, 4 };
		System.out.println(searchInRotatedArray(arr, 0, arr.length - 1, 5));
		System.out.println(searchInRotatedArray(arr, 0, arr.length - 1, 6));
		System.out.println(searchInRotatedArray(arr, 0, arr.length - 1, 7));
		System.out.println(searchInRotatedArray(arr, 0, arr.length - 1, 8));
		System.out.println(searchInRotatedArray(arr, 0, arr.length - 1, 9));
		System.out.println(searchInRotatedArray(arr, 0, arr.length - 1, 10));
		System.out.println(searchInRotatedArray(arr, 0, arr.length - 1, 1));
		System.out.println(searchInRotatedArray(arr, 0, arr.length - 1, 2));
		System.out.println(searchInRotatedArray(arr, 0, arr.length - 1, 3));
		System.out.println(searchInRotatedArray(arr, 0, arr.length - 1, 4));
		
		System.out.println("-------------------------------------------------------------");
		
		System.out.println(searchInRotatedArray1(arr, 0, arr.length - 1, 5));
		System.out.println(searchInRotatedArray1(arr, 0, arr.length - 1, 6));
		System.out.println(searchInRotatedArray1(arr, 0, arr.length - 1, 7));
		System.out.println(searchInRotatedArray1(arr, 0, arr.length - 1, 8));
		System.out.println(searchInRotatedArray1(arr, 0, arr.length - 1, 9));
		System.out.println(searchInRotatedArray1(arr, 0, arr.length - 1, 10));
		System.out.println(searchInRotatedArray1(arr, 0, arr.length - 1, 1));
		System.out.println(searchInRotatedArray1(arr, 0, arr.length - 1, 2));
		System.out.println(searchInRotatedArray1(arr, 0, arr.length - 1, 3));
		System.out.println(searchInRotatedArray1(arr, 0, arr.length - 1, 4));
	}

	private static int searchInRotatedArray1(int[] arr, int start, int end, int target) {

		while (start <=end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == target) {
				return mid;
			}
			if (arr[start] <= arr[mid]) {
				if (arr[start] <= target && target <= arr[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (arr[mid] <= target && arr[end] >= target) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}
	
	private static int searchInRotatedArray(int[] arr, int start, int end, int target) {

		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;

		if (arr[mid] == target) {
			return mid;
		}
		if (arr[start] <= arr[mid]) {
			if (arr[start] <= target && target <= arr[mid]) {
				return searchInRotatedArray(arr, start, mid - 1, target);
			} else {
				return searchInRotatedArray(arr, mid + 1, end, target);
			}
		} else {
			if (arr[mid] <= target && arr[end] >= target) {
				return searchInRotatedArray(arr, mid + 1, end, target);
			} else {
				return searchInRotatedArray(arr, start, mid - 1, target);
			}
		}
	}
}
