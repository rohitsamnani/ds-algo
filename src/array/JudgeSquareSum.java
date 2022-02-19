package array;

public class JudgeSquareSum {

	public static void main(String[] args) {

		System.out.println(judgeSquareSum(2147483600));
	}

	public static boolean judgeSquareSum(int c) {

		long start = 0;
		long end = (long) Math.sqrt(c);

		while (start <= end) {
			long current =end * end + start * start;
			if ( current> c) {
				 end--;
			} else if (current < c) {
				start++;
			} else {
				return true;
			}
		}
		return false;
	}

}
