package binarysearch;

public class PerfectSquare {

	public static void main(String[] args) {
		int x = 367;
		System.out.println(isPerfectSquare(x));

	}

	public static boolean isPerfectSquare(int num) {
		if (num == 0 || num==1) {
			return true;
		}

		int start = 0;
		int end = num;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (mid == num / mid) {
				return true;
			} else if (mid > num / mid) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}
}
