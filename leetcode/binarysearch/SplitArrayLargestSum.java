package binarysearch;

//Leet code Hard problem

/*Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.

Write an algorithm to minimize the largest sum among these m subarrays.
*/

//here we are going to split into max and min , max split will be when individual element gets seprated and min split when whole array will be together.
//max split will give minimum range (here largest element: 10) and min split will max range (sum of all : 32) of a answer
public class SplitArrayLargestSum {

	public static void main(String[] args) {
		int[] arr = { 7, 2, 5, 8, 10 };
		int m = 2; // split count
		System.out.println(splitArrayLargestSum(arr, m));
	}

	private static int splitArrayLargestSum(int[] arr, int m) {
		int minRange = largestSingleElementOfArray(arr);
		int maxRange = sumOfAllElements(arr);
		// apply binary search for possible answer from(10,32), make sure split count
		// wont exceeds to m=2
		while (minRange < maxRange) {
			int mid = minRange + (maxRange - minRange) / 2;
			int arrayCount = 1;
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (mid >= sum + arr[i]) {
					sum += arr[i];
				} else {
					i--;
					arrayCount++;
					sum = 0;
				}
			}
			if (arrayCount <= m) {
				maxRange = mid;
			} else {
				minRange = mid + 1;
			}
		}
		if (minRange == maxRange) {
			return minRange;
		}

		return -1;
	}

	private static int sumOfAllElements(int[] arr) {
		int sum = 0;

		for (int e : arr) {
			sum += e;
		}
		return sum;
	}

	private static int largestSingleElementOfArray(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int e : arr) {
			if (e > max)
				max = e;
		}
		return max;

	}
}