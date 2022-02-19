package array;

public class OrderAgnosticBinarySearch {

	public static void main(String[] args) {
		int[] arr1 = { 100, 98, 95, 91, 83, 73, 64, 63, 54, 51, 32, 21, 14, 13, 11,10, 6, 3, 2, 1 };
		int[] arr = { -22,-19,-10,-6,-5,0,1, 2, 3, 10, 13, 15, 16, 18, 20, 22, 26, 29 };

		System.out.println(agnosticOrderBS(arr1, 10));
		System.out.println(agnosticOrderBS(arr, 10));
	}

	static int agnosticOrderBS(int[] arr, int number) {
		int start = 0;
		int end = arr.length - 1;
		boolean isAsc = arr[start] < arr[end];
		while (start <= end) {
			int mid = start + (end - start);
			if (arr[mid] == number) {
				return mid;
			}
			if (isAsc) {
				if (arr[mid] < number) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else {
				if (arr[mid] > number) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;

	}
}
