package slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeInEveryWindowOfSizeK {

	public static void main(String[] args) {
		int[] arr = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int k = 3; // size of subArray

		firstNegativeInEveryWindowOfSizeK(arr, k);
	}

	private static void firstNegativeInEveryWindowOfSizeK(int[] arr, int k) {
		int i=0;int j=0;
		List<Integer> list = new ArrayList<>();
		while(j<arr.length) {
			if(arr[j]<0) {
				list.add(arr[j]);
			}
			if(j-i+1<k) {
				j++;
			}
			else if(j-i+1==k) {
				if(list.size()!=0) {
					System.out.print(list.get(0)+" ");
				}
				else {
					System.out.print(0+" ");
				}
				if(list.size()!=0 && list.get(0)==arr[i]) {
					list.remove(0);
				}
				i++;
				j++;
			}
		}
	}
}
