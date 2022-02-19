package operators;

//find out number of set bits in given number n
public class NumOfSetBits {

	public static void main(String[] args) {
		int n = 20000989;
		int counter = 0;
		while (n > 0) {
			n = n & (n - 1);
			counter++;
		}
		System.out.println(counter);
	}
}
