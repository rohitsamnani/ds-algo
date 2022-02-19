package numbers;

import java.util.Stack;

//n=20, 20 will be divide by 1,2,4,5,10,20 , so there are 6 factors of 20
public class FactorOfNumber {
	public static void main(String[] args) {
		System.out.println(factsCount(20));

		printFacts(20);
		System.out.println();
		printFactsInSortingOrder(20);
	}

	private static void printFactsInSortingOrder(int n) {
		Stack<Integer> s = new Stack<>();
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (n / i == i) {
					System.out.print(i + " ");
				} else {
					System.out.print(i + " ");
					s.push(n / i);
				}
			}
		}
		while(!s.isEmpty()) {
			System.out.print(s.pop()+" ");
		}

	}

	private static void printFacts(int n) {
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (n / i == i) {
					System.out.print(i + " ");
				} else {
					System.out.print(i + " " + n / i + " ");
				}
			}
		}
	}

	static int factsCount(int n) {
		int count = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (n / i == i) {
					count++;
				}
				count += 2;
			}
		}
		return count;
	}
}
