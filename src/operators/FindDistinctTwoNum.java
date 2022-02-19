package operators;

import java.util.ArrayList;
import java.util.Arrays;

//Find Two single number, rest all are in pair of 3
public class FindDistinctTwoNum {

	public static void main(String[] args) {
		int[] arr = {1,1,1,2,2,3,7,8,8,7,3,3,2,8,7,12,6,6,6,9};
		
		int[] result = findSingleTwoNum(arr);
		System.out.println(Arrays.toString(result));
	}

	private static int[] findSingleTwoNum(int[] arr) {
		
		return findSingleTwoNumMini(arr,0, new ArrayList<Integer>(), new ArrayList<Integer>());
	}

	private static int[] findSingleTwoNumMini(int[] arr, int index, ArrayList<Integer> res,
			ArrayList<Integer> dupRes) {
		
		int value = arr[index];
		
		if(res.contains(value)) {
			dupRes.add(value);
		}
		else {
			res.add(value);
		}
		
		if(index==arr.length-1) {
			res.removeAll(dupRes);
			return new int[] {res.get(0),res.get(1)};
		}
		else {
			return findSingleTwoNumMini(arr,index+1,res,dupRes);
		}
	}
}
