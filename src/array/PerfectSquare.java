package array;

public class PerfectSquare {

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(104976));
	}

	public static boolean isPerfectSquare(int num) {
		if (num == 0) {
			return true;
		}
		int sqrt=SQRTWithoutInBuiltFunctions.binarySqrt(num);
		if(sqrt*sqrt==num) {
			return true;
		}
		else 
			return false;
	}
}
