package example;

public class GraphDiff {
	
	public static void main(String[] args) {
		int arr[] = {1,3,2,1,2,1,5,3,4,2};
		int arr1[]= {5,8,13,2,6};
		System.out.println(checkIt(arr1));
	
	}

	private static int checkIt(int[] arr) {
		int result=arr[0];
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]<arr[i+1]) {
				result=result+(arr[i+1]-arr[i]);
			}
		}
		return result;
	}

}
