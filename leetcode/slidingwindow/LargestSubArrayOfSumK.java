package slidingwindow;
//all numbers into array are positive
public class LargestSubArrayOfSumK {
	
	public static void main(String[] args) {
	
		int[] arr = {2,3,5,1,1,1,1,1,3,5,9};
		int sum=5;
		int count = largestSubArray(arr,sum);
		System.out.println(count);
		
	}

	private static int largestSubArray(int[] arr, int k) {
		int i=0;int j=0;
		int subArrayCount=0;
		int sum=0;
		
		while(j<arr.length) {
			sum+=arr[j];
			if(sum<k) {
				j++;
			}
			else if(sum>k) {
				while (sum > k) {
					sum -= arr[i];
					i++;
				}
				if(sum==k) {
					subArrayCount= Math.max(subArrayCount,j-i+1);
					System.out.println("candidate : "+subArrayCount+" with "+i+" and "+j);
			}
				j++;
			}
			else if(sum==k) {
					subArrayCount= Math.max(subArrayCount,j-i+1);
					System.out.println("candidate : "+subArrayCount+" with "+i+" and "+j);
					j++;
			}
		}
		return subArrayCount;
	}

}
	