package array;

public class SingleElementInSortedArray {

	public static void main(String[] args) {
		int[] arr = { 1,1,2,3,3,4,4,8,8 };
		search(arr, 0, arr.length - 1);
	}

	private static void search(int[] arr, int start, int end) {

		if (start > end)
			return;
		if (start == end) {
			System.out.println("The required element is " + arr[start]);
			return;
		}
		int mid = start + (end - start) / 2;
		if (mid % 2 == 0) {
			if (arr[mid] == arr[mid + 1]) {
				search(arr, mid + 2, end);
			} else {
				search(arr, start, mid);
			}
		}
		if (mid % 2 == 1) {
			if (arr[mid] == arr[mid - 1]) {
				search(arr, mid + 1, end);
			} else {
				search(arr, start, mid - 1);
			}
		}
	}
}
