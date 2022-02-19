package array;

public class MaximumSubArray {

	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));

	}

	public static int maxSubArray(int[] nums) {

		int globalMax = nums[0];
		int currentMax = nums[0];
		for (int i = 1; i < nums.length; i++) {
			currentMax = Math.max(nums[i], currentMax + nums[i]);
			if (currentMax > globalMax) {
				globalMax = currentMax;
			}
		}
		return globalMax;
	}
}