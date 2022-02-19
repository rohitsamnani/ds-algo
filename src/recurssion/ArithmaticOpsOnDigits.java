package recurssion;

public class ArithmaticOpsOnDigits {
	
	public static void main(String[] args) {
		System.out.println(sumOfDigits(12345
				));
		System.out.println(prodOfDigits(12345));
		
	}

	private static int sumOfDigits(int n) {
		if(n==0) {
			return 0;
		}
		int r=n%10;
		return r+sumOfDigits(n/10);
	}
	
	private static int prodOfDigits(int n) {
		if(n%10==n) {			//can write if(n/10==0) return n;
			return n;
		}
		int r=n%10;
		return r*prodOfDigits(n/10);
	}

}
