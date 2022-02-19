package backtracking;

import java.lang.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] accountNames = new String[n];
		int[] dues = new int[n];
		for (int i = 0; i < n; i++) {
			accountNames[i] = sc.nextLine();
		}
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			dues[i] = Integer.parseInt(sc.nextLine());
		}
		int m = Integer.parseInt(sc.nextLine());
		String[] accountsPayingByCheques = new String[m];
		int[] chequeAmounts = new int[m];
		for (int i = 0; i < m; i++) {
			accountsPayingByCheques[i] = sc.nextLine();
		}
		sc.nextLine();
		for (int i = 0; i < m; i++) {
			chequeAmounts[i] = Integer.parseInt(sc.nextLine());
		}
		int result = countMismatchedPayments(n, accountNames, dues, m, accountsPayingByCheques, chequeAmounts);
		System.out.println(result);
	}

	static int countMismatchedPayments(int n, String[] accountNames, int[] dues, int m,
			String[] accountsPayingByCheques, int[] chequeAmounts) {
		int result = 0;

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {
				if (accountsPayingByCheques[j] == accountNames[i]) {
					if (chequeAmounts[j] != dues[i]) {
						result++;

					}
				}
			}

		}
		return result;

	}

}