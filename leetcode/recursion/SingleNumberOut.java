package recursion;

import java.util.ArrayList;
import java.util.List;

/*Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.
*/

public class SingleNumberOut {
	public static void main(String[] args) {
		int[] nums = {2,2,3,2};
		System.out.println(singleNumber(nums));

	}

	private static int singleNumber(int[] nums) {
		return singleNumberMini(nums, 0, new ArrayList<>(1), new ArrayList<>(1));
	}

	private static int singleNumberMini(int[] nums, int index, List<Integer> res, List<Integer> removeList) {
		int a = nums[index];
		if (res.contains(a)) {
			removeList.add(a);
		} else {
			res.add(a);
		}
		if (index == nums.length - 1) {
			res.removeAll(removeList);
			return res.get(0);
		} else {
			return singleNumberMini(nums, index + 1, res, removeList);
		}
	}
}
