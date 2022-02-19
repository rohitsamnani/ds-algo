package operators;

//facebook : find nth magic number with base 5 
public class MagicNumber {

	public static void main(String[] args) {
		int n = 6;
		int base = 5;
		int sum = 0;

		while (n > 0) {
			sum += base * (n & 1);
			n = n >> 1;
			base = base * 5;
		}
		System.out.println(sum);
	}
}
