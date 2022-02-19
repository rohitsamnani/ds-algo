package recurssion;

public class NumberOfStepsLeet {
	
	public static void main(String[] args) {
		System.out.println(numberOfSteps(40587));
	}

	private static int numberOfSteps(int n) {
		 int stpes = 0;
		return helper1(n,stpes);
	}

	static int helper(int n, int steps) {
		if(n==0) {
			return steps;
		}
		if(n%2==1) {
			return helper((n-1),++steps);
		}
		return helper(n/2,++steps);
	}
	
	static int helper1(int n, int steps) {
		if(n==0) {
			return --steps;
		}
		if(n%2==1) {
			return helper1((n-1)/2,steps+2);
		}
		return helper1(n/2,++steps);
	}
}
