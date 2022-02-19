package array;

public class FindMinimumInLinearArray {
	
	public static void main(String[] args) {
		int[] arr = {1,13,43,-13,16,64,25};
		System.out.println(findMinimum(arr));
	}
	
	static int findMinimum(int arr[]) {
		int answer = Integer.MAX_VALUE;	
		for(int i=0 ;i<arr.length;i++) {
			if(arr[i]<answer) {
				answer=arr[i];
			}
		}
		
		return answer;
	}

}
