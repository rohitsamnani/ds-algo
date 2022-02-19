package sorting;

import java.util.Arrays;

//bubble, in-place sorting alogs or sinking algorithm 
//space complexity is O(1), time complexity best case O(N) & worst case O(N*N)
public class Bubble {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 5, 5 };
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	static void bubbleSort(int[] arr) {
		boolean swapped;
		for (int i = 0; i < arr.length; i++) {
			swapped =false;
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
					swapped=true;
				}
			}
			if(!swapped) {
				break;
			}
		}
	}
}
