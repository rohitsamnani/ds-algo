package array;

public class BinarySearchImpl {

	public static void main(String[] args) {
		// Imaging array is sorted one already

		int[] arr = { -22,-19,-10,-6,-5,0,1, 2, 3, 10, 13, 15, 16, 18, 20, 22, 26, 29 };
		System.out.println(findIndex(arr, -5));
	}

	static int findIndex(int[] arr, int number) {
		System.out.println(findIndexThroughBinarySearch(arr, number, 0, arr.length - 1));
		int start=0;
		int end=arr.length-1;
		
		while(start<=end) {
			int mid = start + (end-start)/2;
			if(arr[mid]<number) {
				start=mid+1;
			}
			else if(arr[mid]>number) {
				end=mid-1;
			}
			else {
				return mid;
			}
		}
		return -1;	
	}

	static int findIndexThroughBinarySearch(int[] arr, int number, int start, int end) {
		if (start>end) { 
				return -1;
		}
		int mid = (start + end) / 2;
		if (arr[mid] < number)
			return findIndexThroughBinarySearch(arr, number, mid + 1, end);
		else if (arr[mid] > number) {
			return findIndexThroughBinarySearch(arr, number, start, mid-1);
		} else {
			return mid;
		}
	}
}
