package numbers;
//was to find sqrt of a number
public class FindingSqrt {

	public static void main(String[] args) {
		int num = 40;
		
		System.out.println(getPerfectSqrt(num));
		
		double sqrt= getPerfectSqrt(num);
		double result = 0;
		while(sqrt*sqrt<num) {
			sqrt=sqrt+(double)0.1;
			result=sqrt;
		}
		
		System.out.printf("%.3f", result);
	}

	private static int getPerfectSqrt(int num) {
		int start =0 ;
		int end = num;
		while(start<end) {
			int mid = start+(end-start)/2;
			if(mid*mid==num) {
				return mid;
			}
			else if(mid*mid>num) {
				end=mid-1;
			}
			else {
				start=mid+1;
			}
		}
		
		return end;
	}
}
