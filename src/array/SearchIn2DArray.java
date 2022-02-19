package array;

import java.util.Arrays;

public class SearchIn2DArray {
	
	public static void main(String[] args) {
		
		int[][] arr= {{23,3,4},{23,4,1,2},{25,54,5,7,1},{22,13,6,7},{15,5,84,2}};
		int target= 84;
		System.out.println(Arrays.toString(searchIn2DArray(arr,target)));
	}
	
	static int[] searchIn2DArray(int[][] arr, int target) {
		int[] arr1=new int[2];
		arr1[0]=Integer.MAX_VALUE;
		arr1[1]=Integer.MAX_VALUE;
		
		for(int r=0;r<arr.length;r++) {
			for(int c=0;c<arr[r].length;c++) {
				if(arr[r][c]==target) {
					arr1[0]=r;
					arr1[1]=c;
				}
			}
		}
		return arr1;
	}
}
