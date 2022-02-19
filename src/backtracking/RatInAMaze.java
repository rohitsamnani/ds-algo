package backtracking;

public class RatInAMaze {

	public static void main(String[] args) {
		int count = printTwoWays(new boolean[3][3], "", 0, 0);
		System.out.println();
		System.out.println(count);
		count = printThreeWays(new boolean[3][3], "", 0, 0);
		System.out.println();
		System.out.println(count);
		printWaysWithBlocker(new boolean[][] { { true, true, true }, { true, false, true }, { true, true, true } }, "",
				0, 0);

		System.out.println("----------------------------------Print all 4 directions--------------------------");
		printAllDirections(new boolean[][] { { true, true, true }, { true, true, true }, { true, true, true } }, "", 0,
				0);

		System.out.println("----------------------------------Rate Maze--------------------------");
		
		System.out.println();
		ratPath(new int[][] { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } }, "", 0, 0,new int[4][4]);
	}

	private static void ratPath(int[][] arr, String p, int r, int c,int[][] pArr) {
		if (r == arr.length - 1 && c == arr[0].length - 1) {
			pArr[r][c]=1;
			/*
			 * for(int[] row:pArr) { for(int col:row) System.out.print(col+" ");
			 * System.out.println(); }
			 */
			System.out.print(p + " ");
			return;
		}

		pArr[r][c]=1;
		if ( r < arr.length - 1 && isSafe(arr,r,c)) {
			ratPath(arr,p+"D",r+1,c,pArr);
		}

		if (c < arr[0].length - 1 && isSafe(arr,r,c)) {
			ratPath(arr,p+"R",r,c+1,pArr);
		}
		pArr[r][c]=0;
	}

	private static boolean isSafe(int[][] arr, int r, int c) {
		if(arr[r][c]==0)
			return false;

		return true;
	}

	private static void printAllDirections(boolean[][] boolArr, String p, int r, int c) {
		if (r == boolArr.length - 1 && c == boolArr.length - 1) {
			System.out.print(p + " ");
			return;
		}

		if (!boolArr[r][c])
			return;

		boolArr[r][c] = false;

		if (r < boolArr.length - 1)
			printAllDirections(boolArr, p + "D", r + 1, c);
		if (r > 0)
			printAllDirections(boolArr, p + "U", r - 1, c);
		if (c < boolArr[0].length - 1)
			printAllDirections(boolArr, p + "R", r, c + 1);
		if (c > 0)
			printAllDirections(boolArr, p + "L", r, c - 1);
		boolArr[r][c] = true;

	}

	private static void printWaysWithBlocker(boolean[][] boolArr, String p, int r, int c) {
		if (r == boolArr.length - 1 && c == boolArr.length - 1) {
			System.out.print(p + " ");
			return;
		}

		if (!boolArr[r][c])
			return;

		if (r < boolArr.length - 1)
			printWaysWithBlocker(boolArr, p + "V", r + 1, c);
		if (c < boolArr[0].length - 1)
			printWaysWithBlocker(boolArr, p + "H", r, c + 1);

		if (r < boolArr.length - 1 && c < boolArr[0].length - 1)
			printWaysWithBlocker(boolArr, p + "D", r + 1, c + 1);
	}

	private static int printTwoWays(boolean[][] boolArr, String p, int r, int c) {
		if (r == boolArr.length - 1 && c == boolArr.length - 1) {
			System.out.print(p + " ");
			return 1;
		}
		int counter = 0;
		if (r < boolArr.length)
			counter += printTwoWays(boolArr, p + "V", r + 1, c);
		if (c < boolArr[0].length)
			counter += printTwoWays(boolArr, p + "H", r, c + 1);
		return counter;
	}

	private static int printThreeWays(boolean[][] boolArr, String p, int r, int c) {
		if (r == boolArr.length - 1 && c == boolArr.length - 1) {
			System.out.print(p + " ");
			return 1;
		}
		int counter = 0;
		if (r < boolArr.length)
			counter += printTwoWays(boolArr, p + "V", r + 1, c);
		if (c < boolArr[0].length)
			counter += printTwoWays(boolArr, p + "H", r, c + 1);
		if (r < boolArr.length && c < boolArr[0].length)
			counter += printTwoWays(boolArr, p + "D", r + 1, c + 1);
		return counter;
	}
}
