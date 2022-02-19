package numbers;

//check number is prime or not
public class PrimeNumber {

	public static void main(String[] args) {
		int num = 13;
		System.out.println(isPrime(num));

		System.out.println(countPrimeNumberTill(40));
	}

	private static int countPrimeNumberTill(int num) {
		if (num <= 0) {
			return 0;
		}
		int count=0;
		for (int i = 2; i <= num; i++) {
			if(isPrime(i)) {
				count++;
			}
		}
		return count;
	}

	private static boolean isPrime(int num) {
		if (num <= 0) {
			return false;
		}
		int counter = 2;
		while (counter * counter <= num) { // can write while(counter<=Math.sqrt(num))
			if (num % counter == 0)
				return false;
			counter++;
		}
		return true;
	}
}
