package recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinearSearch {
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) {
		int target = 2;
		int initialIndex = 0;
		int[] arr = new int[] { 1, 2, 3, 5, 8, 5, 2, 3, 45, 2, 45, 6 };
		int lastIndex = arr.length - 1;

		System.out.println(linearSearch(arr, initialIndex, target));
		System.out.println(findIndex(arr, initialIndex, target));
		System.out.println(lastIndex(arr, lastIndex, target));
		System.out.println(countOccurances(arr, initialIndex, target, 0));
		System.out.println(findAllIndexes(arr, initialIndex, target));
		System.out.println(findAllIndexes1(arr, initialIndex, target, new ArrayList<Integer>()));
		
		Integer[] arr1=list.stream().toArray(Integer[]::new);
		System.out.println(Arrays.toString(arr1));

	}

	private static List<Integer> findAllIndexes(int[] arr, int index, int target) {
		if (index == arr.length) {
			return list;
		}
		if (arr[index] == target) {
			list.add(index);
		}
		return findAllIndexes(arr, index + 1, target);
	}
	
	private static List<Integer> findAllIndexes1(int[] arr, int index, int target, List<Integer> list) {
		if (index == arr.length) {
			return list;
		}
		if (arr[index] == target) {
			list.add(index);
		}
		return findAllIndexes1(arr, index + 1, target, list);
	}
	
	private static int countOccurances(int[] arr, int index, int target, int occurance) {
		if (index == arr.length) {
			return occurance;
		}
		if (arr[index] == target) {
			occurance++;
		}
		return countOccurances(arr, index + 1, target, occurance);
	}

	private static boolean linearSearch(int[] arr, int index, int target) {
		if (arr.length == index) {
			return false;
		}
		return (arr[index] == target) || linearSearch(arr, index + 1, target);
	}

	private static int findIndex(int[] arr, int index, int target) {
		if (arr.length == index) {
			return -1;
		}
		if (arr[index] == target) {
			return index;
		}
		return findIndex(arr, index + 1, target);
	}

	private static int lastIndex(int[] arr, int index, int target) {
		if (-1 == index) {
			return -1;
		}
		if (arr[index] == target) {
			return index;
		}
		return lastIndex(arr, index - 1, target);
	}
}