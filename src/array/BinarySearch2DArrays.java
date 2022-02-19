//Matrix is sorted that mean row are sorted and column are sorted
package array;

import java.util.Arrays;

public class BinarySearch2DArrays {
	
	public static void main(String[] args) {
		//int[][] arr = {{10,20,30,40},{15,25,35,45},{17,28,38,48},{33,45,56,67}};
		int[][] arr = {{10,20,30,40},{15,25,35,45},{17,28,38,48}};
		System.out.println(Arrays.toString(binarySearch2DArrays(arr,10)));
		System.out.println(Arrays.toString(binarySearch2DArrays(arr,20)));
		System.out.println(Arrays.toString(binarySearch2DArrays(arr,30)));
		System.out.println(Arrays.toString(binarySearch2DArrays(arr,40)));
		System.out.println(Arrays.toString(binarySearch2DArrays(arr,15)));
		System.out.println(Arrays.toString(binarySearch2DArrays(arr,25)));
		System.out.println(Arrays.toString(binarySearch2DArrays(arr,35)));
		System.out.println(Arrays.toString(binarySearch2DArrays(arr,45)));
		System.out.println(Arrays.toString(binarySearch2DArrays(arr,17)));
		System.out.println(Arrays.toString(binarySearch2DArrays(arr,28)));
		System.out.println(Arrays.toString(binarySearch2DArrays(arr,38)));
		System.out.println(Arrays.toString(binarySearch2DArrays(arr,48)));
		/*
		 * System.out.println(Arrays.toString(binarySearch2DArrays(arr,33)));
		 * System.out.println(Arrays.toString(binarySearch2DArrays(arr,45)));
		 * System.out.println(Arrays.toString(binarySearch2DArrays(arr,56)));
		 * System.out.println(Arrays.toString(binarySearch2DArrays(arr,67)));
		 */
	}

	private static int[] binarySearch2DArrays(int[][] arr, int number) {

		int row=arr.length-1;
		int col=arr[0].length-1;
		
		for(int r=0;r<row;) {
			for(int c=col;c>=0;) {
				if(arr[r][c]==number) {
					return new int[] {r,c}; 
				}
				if(arr[r][c]>number) {
					c-=1;
				}
				else {
					r+=1;;
				}
			}
		}
		return new int[] {-1,-1};
	}
}
