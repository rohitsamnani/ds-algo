package operators;

//calculate Math.pow(x,y) without using Math.pow() function
public class XPowerOfY {
	public static void main(String[] args) {

		long x = 3;
		long y = 19;
		long ans=1;
		while (y > 0) {
			if ((y & 1) == 1) {
					ans=ans*x;
			}
			y=y>>1;
			x=x*x;
		}
		System.out.println(ans);
		 x = 3;
		 y = 19;
		System.out.println((int) Math.pow(x, y));
	}
}
