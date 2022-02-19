package operators;

import java.util.Arrays;

//all other num appearing twice only 1 num appearing once, find out that one
public class FindDistinctNumInArray {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 2, 7, 3, 3, 4, 1, 5, 4, 6, 2, 7 };

		System.out.println(findDistinct(arr)); // pair of 2

		int[] arr1 = { 1,1, 5,5, 5,5, 4,4, 3,3, 4, 1,1,3, 4, 3, 200};
		int pairOf = 4;
		System.out.println(findDistinct(arr1, pairOf)); // pair of any number
	}

	private static int findDistinct(int[] arr, int pairOf) {

		int[] bitArray = new int[32];
		for (int i = 0; i < arr.length; i++) {
			int index = 0;
			int num = arr[i];
			while (num > 0) {
				bitArray[index] = bitArray[index] + num % 2;
				index++;
				num = num / 2;
			}
		}

		System.out.println(Arrays.toString(bitArray));
		int n = 0;
		int number = 0;
		for (int bit : bitArray) {
			number = number + (bit % pairOf << n); /// can be written as => number+ bit%pairOf * (int)Math.pow(2, n);
			n++;
		}
		return number;
	}

	private static int findDistinct(int[] arr) {
		int result = 0;

		for (int i : arr) {
			result ^= i;
		}
		return result;
	}
}
