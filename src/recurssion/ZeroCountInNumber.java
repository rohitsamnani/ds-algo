package recurssion;

public class ZeroCountInNumber {
	
	public static void main(String[] args) {
		
		System.out.println(numOfZero(101010201,0));
	}

	private static int numOfZero(int num, int count) {
		if(num%10==0) {
			return numOfZero(num/10,++count);
		}
		if(num%10==num) {
			return count;
		}
		return numOfZero(num/10,count);
	}

}
