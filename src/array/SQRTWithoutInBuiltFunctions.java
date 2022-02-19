package array;

public class SQRTWithoutInBuiltFunctions {

	public static void main(String[] args) {
		System.out.println(binarySqrt(2147395599));
	}

	//static way. high time complexity
	static double sqrt(int number) {
		double t = 0;
		double sqrt = number / 2;

		do {
			t = sqrt;
			sqrt = (t + (number / t)) / 2;
		} while ((t - sqrt) != 0);
		return sqrt;
	}

	//binary way, best time complexity
	static int binarySqrt(int num) {
		if(num==1) {
			return 1;
		}
		int start = 0;
		int end = num;
		int ans = 0;

		while (start<=end) {
			int mid = start + (end - start) / 2;
			if (mid == num/mid) {
				ans=mid;
				break;
			} else if (mid  > num/mid) {
				end = mid-1;
			} else {
				start = mid+1;
				ans=mid;
			}
		}
		return ans;
	}

}
