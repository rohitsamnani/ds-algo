package recurssion;

import java.util.ArrayList;
import java.util.Arrays;

//diff between subsequence and subset is subsequence will be only a group of adjacent elements while subsets can be group of adjacent or nonAdjacent elements too
//example: {a,b,c} => {b,c} is subseqence & subset both while {a,c} is not a subsequence. but {a,c} will be subset here.

public class ArraySubSets {

	public static void main(String[] args) {
		String[] arr1 = { "a", "b", "c" };
		String[] arr2 = { "a", "b", "b", "c", "c" };
		ArrayList<ArrayList<String>> list1 = subSets(arr1);

		for (ArrayList<String> al : list1) {
			System.out.print(al + " ");
		}
		System.out.println();
		ArrayList<ArrayList<String>> list2 = subSetsDuplicate(arr2);

		for (ArrayList<String> al : list2) {
			System.out.print(al + " ");
		}
		System.out.println();

		ArrayList<ArrayList<String>> list3 = tryOneMore(arr2);

		for (ArrayList<String> al : list3) {
			System.out.print(al + " ");
		}
	}

	private static ArrayList<ArrayList<String>> subSets(String[] arr) {
		ArrayList<ArrayList<String>> outer = new ArrayList<>();
		outer.add(new ArrayList<String>());

		for (int i = 0; i < arr.length; i++) {
			// as we are adding elements into outer list hence we need a constant size to
			// run below loop
			int constantSize = outer.size();
			for (int j = 0; j < constantSize; j++) {
				ArrayList<String> innerMost = new ArrayList<String>(outer.get(j));
				innerMost.add(arr[i]);
				outer.add(innerMost);
			}

		}
		return outer;
	}

	private static ArrayList<ArrayList<String>> subSetsDuplicate(String[] arr) {
		Arrays.sort(arr);
		ArrayList<ArrayList<String>> outer = new ArrayList<>();

		outer.add(new ArrayList<String>());
		int s = 0;
		int e = 0;

		for (int i = 0; i < arr.length; i++) {
			if (i > 0 && arr[i] == arr[i - 1]) {
				s = e + 1;
			}
			e = outer.size() - 1;
			int constantSize = outer.size();
			for (int j = s; j < constantSize; j++) {
				ArrayList<String> inner = new ArrayList<>(outer.get(j));
				inner.add(arr[i]);
				outer.add(inner);
			}
		}
		return outer;

	}

	// this one fails when multiple duplicate elements will be present.
	private static ArrayList<ArrayList<String>> tryOneMore(String[] arr) {
		Arrays.sort(arr);
		ArrayList<ArrayList<String>> outer = new ArrayList<>();

		outer.add(new ArrayList<String>());
		int s = 0;

		for (int i = 0; i < arr.length; i++) {
			if (i > 0 && arr[i] == arr[i - 1]) {
				s = outer.size() / 2;
			}
			int constantSize = outer.size();
			for (int j = s; j < constantSize; j++) {
				ArrayList<String> inner = new ArrayList<>(outer.get(j));
				inner.add(arr[i]);
				outer.add(inner);
			}
		}
		return outer;

	}
}