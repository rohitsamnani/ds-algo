package numbers;

//HCF and GCD both are same only
//Highest common factor of 14 and 35 will be 7
//Least common multiple of 14 and 35 will be 70
public class HCFAndLCM {

	public static void main(String[] args) {
		System.out.println(gcd(14,35));			//also called hcf
		System.out.println(lcm(14,35));

	}

	static int gcd(int a, int b) {
		if(a==0) {
			return b;
		}
		return gcd(b%a,a);
	}
	
	static int lcm(int a, int b) {
		int d=gcd(a,b);					//this is highest number lets say d is with which both a and b will be divide, rest are indivisible and thats multiplication along with this d will be our answer
		int f= a/d;
		int g=b/d;
		
		return g*f*d;				//even you can write (a*b)/gcd(a,b) why because (fd * gd)/d=g*f*d
	}
}
