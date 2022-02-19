package backtracking;

public class NKnights {

	static int count=0;
	public static void main(String[] args) {
		nKnightPlaces(new boolean[4][4], 0, 0, 4);
		System.out.println(count);
	}

	private static void nKnightPlaces(boolean[][] boolArr, int r, int c, int counter) {
		if (counter == 0) {
			count++;
			printKnightsPosition(boolArr);
			return;
		}

		if (r == boolArr.length - 1 && c == boolArr.length) {
			return;
		}

		if (c == boolArr.length) {
			nKnightPlaces(boolArr, r + 1, 0, counter);
			return;
		}

		if (isSafe(boolArr, r, c)) {
			boolArr[r][c] = true;
			nKnightPlaces(boolArr, r, c + 1, counter - 1);
			boolArr[r][c] = false;
		}
		nKnightPlaces(boolArr, r, c + 1, counter);
	}

	private static boolean isSafe(boolean[][] boolArr, int r, int c) {
		// 4 condition to check for knights: r-2 c-1,r-2 c+1,r-1 c-2, r-1 c+1

		if (isValid(boolArr, r - 2, c - 1) && boolArr[r - 2][c - 1])
			return false;
		if (isValid(boolArr, r - 2, c + 1) && boolArr[r - 2][c + 1])
			return false;
		if (isValid(boolArr, r - 1, c - 2) && boolArr[r - 1][c - 2])
			return false;
		if (isValid(boolArr, r - 1, c + 2) && boolArr[r - 1][c + 2])
			return false;
		return true;
	}

	private static boolean isValid(boolean[][] boolArr, int i, int j) {
		if (i >= 0 && i < boolArr.length && j >= 0 && j < boolArr[0].length)
			return true;
		return false;
	}

	private static void printKnightsPosition(boolean[][] boolArr) {

		for (boolean[] r : boolArr) {
			for (boolean c : r) {
				if (c) {
					System.out.print("K ");
				} else {
					System.out.print("X ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
