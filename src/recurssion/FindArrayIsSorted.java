package recurssion;

public class FindArrayIsSorted {

	public static void main(String[] args) {
		System.out.println(find(new int[] { 1, 4, 6, 7, 9, 12, 13, 2 }));

	}

	private static boolean find(int[] arr) {
		return findOut(arr, 0);
	}

	private static boolean findOut(int[] arr, int index) {
		if (arr.length - 1 == index) {
			return true;
		}
		return (arr[index] < arr[index + 1]) && findOut(arr, index + 1); 
	}

}
