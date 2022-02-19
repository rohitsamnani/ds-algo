package numbers;
//use newton-raphson method to find out dqrt

public class FindSqrtNewtonRapsonMethod {

	public static void main(String[] args) {
		System.out.println(sqrt(40));
	}

	static double sqrt(int num) {

		double x = num;
		double base = 0;
		while (true) {
			base = 0.5 * (x + num / x);
			if (Math.abs(base - x) < 0.5) {
				break;
			}
			x = base;
		}
		return base;
	}
}
