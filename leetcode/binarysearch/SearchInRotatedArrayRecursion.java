package binarysearch;

public class SearchInRotatedArrayRecursion {

	public static void main(String[] args) {

		int[] nums = { 2,5,6,0,0,1,2};
		int target = 3;
		System.out.println(search(nums, target));

	}

	public static int search(int[] nums, int target) {

		return searchInRotatedArray(nums, 0, nums.length - 1, target);

	}

	static int searchInRotatedArray(int[] nums, int start, int end, int target) {
		if (start > end)
			return -1;
		
		
		int mid = start + (end - start) / 2;
		
		if(nums[start]==nums[end] && nums[start]==nums[mid]) {
			start++;
			end--;
			mid = start + (end - start) / 2;
		}

		if (nums[mid] == target) {
			return mid;
		}

		if (nums[start] <= nums[mid]) {
			if (target >= nums[start] && target <= nums[mid]) {
				return searchInRotatedArray(nums, start, mid - 1, target);
			} else {
				return searchInRotatedArray(nums, mid + 1, end, target);
			}
		} else {
			if (target >= nums[mid] && target <= nums[end]) {
				return searchInRotatedArray(nums, mid + 1, end, target);
			} else {
				return searchInRotatedArray(nums, start, mid - 1, target);
			}
		}
	}
}