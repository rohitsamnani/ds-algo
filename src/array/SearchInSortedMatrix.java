package array;

import java.util.Arrays;

public class SearchInSortedMatrix {

	public static void main(String[] args) {
		int[][] arr =  {{1,2,3},{4,5,6},{7,8,9}};
		int[][] arr1 = {{1,2,3,4,5,6,7}};					//for single row search
		System.out.println(Arrays.toString(searchInSortedMatrix(arr1,5)));
		System.out.println(Arrays.toString(searchInSortedMatrix(arr,1)));
		System.out.println(Arrays.toString(searchInSortedMatrix(arr,2)));
		System.out.println(Arrays.toString(searchInSortedMatrix(arr,3)));
		System.out.println(Arrays.toString(searchInSortedMatrix(arr,4)));
		System.out.println(Arrays.toString(searchInSortedMatrix(arr,5)));
		System.out.println(Arrays.toString(searchInSortedMatrix(arr,6)));
		System.out.println(Arrays.toString(searchInSortedMatrix(arr,7)));
		System.out.println(Arrays.toString(searchInSortedMatrix(arr,8)));
		System.out.println(Arrays.toString(searchInSortedMatrix(arr,9)));
	}
	//binary search on a single row and n cols
	static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
		
		while(cStart<=cEnd) {
			int cMid = cStart + (cEnd-cStart)/2;
			if(matrix[row][cMid]==target) {
				return new int[] {row,cMid};
			}
			else if(matrix[row][cMid]<target) {
				cStart= cMid+1;
			}
			else {
				cEnd=cMid-1;
			}
		}
		return new int[] {-1,-1};
	}
	
	
	static int[] searchInSortedMatrix(int[][] matrix, int target) {
		int rows= matrix.length; 
		int cols=matrix[0].length;
		
		if(rows==1) {
			return binarySearch(matrix,0,0,cols-1,target);
		}
		int rStart=0;
		int rEnd=rows-1;
		int cMid = cols/2;
		int cStart=0;
		int cEnd=cols-1;
		while(rStart<rEnd-1) {
			int mid = rStart + (rEnd-rStart)/2;
			if(matrix[mid][cStart]==target) {
				return new int[] {mid,cMid};
			}
			else if(matrix[mid][cStart]<target) {
				rStart=mid;
			}
			else {
				rEnd=mid;
			}
		}
		
		if(matrix[rStart][cMid]==target) {
			return new int[] {rStart,cMid};
		}
		if(matrix[rStart+1][cMid]==target) {
			return new int[] {rStart+1,cMid};
		}
		//check middle element of row 1, if middle element is greater and target is smaller
		if(matrix[rStart][cMid-1]>=target) {
			return binarySearch(matrix, rStart,cStart,cMid-1,target);
		}
		
		//check middle element of row 1, if middle element is smaller and target is greater than middle but smaller than last element of row (last col)
		if(matrix[rStart][cMid+1]<=target && matrix[rStart][cEnd]>=target) {
			return binarySearch(matrix, rStart,cMid+1,cEnd,target);
		}
		//check middle element of row 2, if middle element is greater and target is smaller
		if(matrix[rStart+1][cMid-1]>=target) {
			return binarySearch(matrix, rStart+1,cStart,cMid-1,target);
		}
		//else
		else {
			return binarySearch(matrix, rStart+1,cMid+1,cEnd,target);
		}
	}
}
