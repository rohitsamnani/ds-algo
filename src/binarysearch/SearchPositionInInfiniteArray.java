package binarysearch;

//we are assuming here infinite array as we can;t create one, so no end length is known to us
public class SearchPositionInInfiniteArray {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 7, 8, 9, 11, 14, 15, 17, 19, 25, 27, 28, 30, 32, 38, 48, 56, 59, 67, 76, 89, 95,
				100 };
		int target = 19;
		System.out.println(findIndexInInfiniteArray(nums, target));
	}

	private static int findIndexInInfiniteArray(int[] nums, int target) {
		int start=0;
		int end=1;
		while(nums[end]<target) {
			int temp=end+1;
			//keep double the size until we aren't getting range, this will assure Time complexity of O(logn) 
			end=end +(end-start+1)*2;
			start=temp;
		}
		while(start<=target) {
			int mid = start + (end - start) / 2;

			if (nums[mid] > target) {
				end = mid - 1;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
