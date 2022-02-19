package binarysearch;

import java.util.Arrays;

public class RangeOfNumber {

	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		int[] result = searchRange(nums, target);
		System.out.println(Arrays.toString(result));

	}

	public static int[] searchRange(int[] nums, int target) {
		int num = search(nums, target);
		if (num == -1) {
			return new int[] { -1, -1 };
		} else if (nums.length == 1 && nums[0] == target) {
			return new int[] { 0, 0 };
		}

		else {
			int startRange = num;
			int endRange = num;
			while (endRange < nums.length - 1 && nums[endRange + 1] == nums[num]) {
				endRange++;
			}
			while (startRange > 0 && nums[startRange - 1] == nums[num]) {
				startRange--;
			}
			return new int[] { startRange, endRange };
		}
	}

	public static int search(int[] nums, int target) {

		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
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