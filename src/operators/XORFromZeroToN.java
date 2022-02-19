package operators;

//find XOR from 0 to n
//we can also find XOR from a to b
public class XORFromZeroToN {

	public static void main(String[] args) {
		int n=10;
		System.out.println(findXOR(n));
		
		int a=3;
		int b=9;
		System.out.println(XORFromAToB(a,b));
	}

	private static int XORFromAToB(int a, int b) {
		//it can be find by xOR from (0 to b) - (0 to a) i.e (0 to b)^(0 to a)	
		return findXOR(b) ^ findXOR(a-1);
	}

	private static int findXOR(int n) {
		if(n%4==0)
			return n;
		if(n%4==1)
			return 1;
		if(n%4==2)
			return n+1;
		if(n%4==3)
			return 0;
		else
			return -1;

	}
}
