package array;

import java.util.ArrayList;

public class SubArrayWithGivenSum {
	
	public static void main(String[] args) {
		int arr[]={1,2,3,4,5,6,7,8,9,10};
		int N=10; int S=15;
		
		System.out.println(subArrayWithGivenSum(arr,N,S));
	}

	private static ArrayList<Integer> subArrayWithGivenSum(int[] arr, int n, int s) {
		
		
		
		
		
		
		
		return null;
	}

//	private static ArrayList<Integer> subArrayWithGivenSum(int[] arr, int n, int s) {
//		ArrayList<Integer> subArray= new ArrayList<Integer>();
//		int start=0,i=0;
//		int sum= arr[0];
//		for(i=1;i<=n;i++) {
//			
//			while(sum>s && start<i-1) {
//				sum= sum-arr[start];
//				start++;
//			}
//			if(sum==s) {
//				int j=i;
//				subArray.add(start+1);
//				subArray.add(j);
//				break;
//			}
//			if(i<n)
//				sum +=arr[i];
//		}
//		if(!subArray.isEmpty()) {
//			return subArray;
//		}
//		else {
//			subArray.add(-1);
//			return subArray;
//		}
//		
//	}
	
	
	
}