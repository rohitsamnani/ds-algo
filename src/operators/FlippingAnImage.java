package operators;

//flip image horizontal & then invert it
public class FlippingAnImage {

	public static void main(String[] args) {
		// input: [[1,1,0],[1,0,1],[0,0,0]]
		// output: [[1,0,0],[0,1,0],[1,1,1]]

		int[][] arr = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
		flipIt(arr);
		for(int[] arr1:arr) {
			for(int arr2:arr1) {
				System.out.print(arr2);
			}
			System.out.println();
		}
	}

	private static void flipIt(int[][] arr) {
		for (int[] arr1 : arr) {
			for (int i = 0; i < arr[0].length / 2; i++) {
				// swap it for reverse
				int temp = arr1[i] ^ 1;
				arr1[i]=arr1[arr[0].length-1-i] ^1;
				arr1[arr[0].length-1-i]=temp;
			}
			if(arr[0].length%2==1) {
				arr1[arr[0].length/2]=arr1[arr[0].length/2]^1;
			}
			
		}

	}
}
