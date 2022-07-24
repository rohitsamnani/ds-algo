package temp;

import java.util.ArrayList;
import java.util.List;

public class Sort_KG {

	public static void main(String[] args) {
		int[] arr = { 50, 75, 175, 110, 155 };

		sortIt(arr);
	}

	private static void sortIt(int[] arr) {
		List<Integer> totalWeightKg = new ArrayList<Integer>();
		List<List<Integer>> selectedForDelievery = new ArrayList<List<Integer>>();

		for (int j = arr.length - 1; j >= 0; j--) {
			int i = 0;
			if (arr[j] + arr[i] > 200) {
				List<Integer> al = new ArrayList<>();
				al.add(j);
				selectedForDelievery.add(al);
				return;
			} else {
				giveMeList(arr);
			}

		}

	}

	private static List<Integer> giveMeList(int[] arr) {

		List<Integer> tempList = new ArrayList<>();
		for (int j = 0; j < arr.length; j++) {
			int i = arr.length - 1;
			int totalWeight = arr[i];
			tempList.add(i);
			int maxWeight = Integer.MIN_VALUE;
			while (totalWeight + arr[j] < 200) {
				totalWeight += arr[j];
				j++;
				tempList.add(j);
			}
			if (maxWeight < totalWeight) {
				maxWeight = totalWeight;
			}
		}
		/*
		 * List<Integer> al = new ArrayList<>(); al.add(j); for (int k = 0; k < i; k++)
		 * { al.add(k); }
		 */
		return null;
	}
}
