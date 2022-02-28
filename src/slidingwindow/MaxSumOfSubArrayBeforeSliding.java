package slidingwindow;
//Brute Force
public class MaxSumOfSubArrayBeforeSliding {

	public static void main(String[] args) {
		int[] arr = {2,3,5,2,9,7,1};
		int k= 3 ;		//size of subArray
		
		System.out.println(maxSumOfSubArrayBruteForce(arr,k));
	}

	private static int maxSumOfSubArrayBruteForce(int[] arr, int k) {
		int lastSum=0;
		for(int i=0;i<k;i++) {
			lastSum+=arr[i];
		}
		int max=lastSum;
		for(int i=k;i<arr.length;i++) {
			lastSum+=arr[i];
			lastSum-=arr[i-k];
			max=Math.max(max, lastSum);
		}
		return max;
	}
}
