package recurssion;

public class ReverseDigits {

	static int sum=0;
	public static void main(String[] args) {
		System.out.println(reverse(4638));
		reverseWithoutStringConversion(4638);
		System.out.println(sum);
		System.out.println(reverseWithUsingLog(4638));
	}

	private static int reverseWithUsingLog(int n) {
		return helper(n,(int)(Math.log10(n)+1));
		 
	}

	private static int helper(int n, int digits) {
		if(n%10==n) {
			return n;
		}
		return ((n%10)*(int)Math.pow(10, digits-1))+helper(n/10,digits-1);
	}

	static int reverse(int n) {
		if(n%10==n)
			return n;
		return Integer.parseInt((Integer.toString(n%10)) + reverse(n/10)); 
		
	}
	
	private static void reverseWithoutStringConversion(int n) {
		if(n==0)
			return ;
		
		sum=sum*10 + (n%10);
		reverseWithoutStringConversion(n/10);
		
	}
	
	

}
