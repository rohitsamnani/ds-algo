package binarysearch;
//take out peak index when we have mountain array like this: [1,2,4,5,7,8,6,4,3,1], so here 8 is peak
public class PeakIndexInMountainArray {

	public static void main(String[] args) {
		int[] arr= {1,2,4,7,6,4,3,1};
		System.out.println(peakIndex(arr));
	}

	private static int peakIndex(int[] arr) {
		int start=0;
		int end=arr.length-1;
		while(start<end) {
			int mid=start+(end-start)/2;
			if(arr[mid]>arr[mid+1]) {
				end=mid;
			}
			else  {
				start=mid+1;
			}
		}
		// start and end are equal that mean they are pointing to the largest element in the array. Dry run the above two
        // condition, and you will, able to see this.
		if(start==end) {
			return start;
		}
		return -1;
	}
}
