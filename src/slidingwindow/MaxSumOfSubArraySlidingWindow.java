package slidingwindow;

public class MaxSumOfSubArraySlidingWindow {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 2, 9, 7, 1, 40 };
		int k = 3; // size of subArray

		System.out.println(maxSumOfSubArray(arr, k));
	}

	private static int maxSumOfSubArray(int[] arr, int k) {
		int i = 0;
		int j = 0;
		int sum = 0;
		int max = Integer.MIN_VALUE;
		while (j < arr.length) {
			sum += arr[j];
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				max = Math.max(max, sum);
				sum -= arr[i];
				i++;
				j++;
			}
		}
		return max;
	}

}
