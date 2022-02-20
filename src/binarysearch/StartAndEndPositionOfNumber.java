package binarysearch;

import java.util.Arrays;

/*
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
 */
public class StartAndEndPositionOfNumber {
	
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10}; 
		int target = 8;
		int[] positions = getPositions(nums, target);
		System.out.println(Arrays.toString(positions));
	}

	private static int[] getPositions(int[] nums, int target) {
		
		int targetIndex = binarySearch(nums, target);
		
		if(targetIndex==-1) {
			return new int[] {-1,-1};	
		}
		int startIndex=targetIndex;
		int endIndex=targetIndex;
		while(startIndex>0 && target==nums[startIndex-1]) {
			startIndex--;
		}
		while(endIndex<nums.length-1 && target==nums[endIndex+1]) {
			endIndex++;
		}

		return new int[] {startIndex,endIndex};
	}

	private static int binarySearch(int[] nums, int target) {
		int start=0;
		int end=nums.length-1;
		
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
