package recurssion;

import java.util.ArrayList;
import java.util.Arrays;

//we have 3*3 maze and person who stand at 0,0 has to reach till 2,2, only right and down are allowed, how many ways (count) it can go
public class MazeProblem {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(countPossibleDirection(arr, arr.length - 1, arr[0].length - 1));
		printWays(arr, "", arr.length - 1, arr[0].length - 1);
		System.out.println();
		printWays1(arr, "", arr.length - 1, arr[0].length - 1);
		System.out.println();
		ArrayList<String> al = printWays2(arr, "", arr.length - 1, arr[0].length - 1);
		System.out.println(al);
		System.out.println();
		ArrayList<String> list = printWays3(arr, "", arr.length - 1, arr[0].length - 1);
		System.out.println(list);

		System.out.println();
		boolean[][] boolArr = { { true, true, true }, { false, true, true }, { true, true, true } };
		avoidObstacles(boolArr, "", 0, 0);

		System.out.println();
		boolean[][] boolArr1 = { { true, true, true }, { true, false, true }, { true, true, true } };
		avoidObstaclesDiagonal(boolArr1, "", 0, 0);
		System.out.println();
		
		System.out.println("--------------All 4 direction---------------------------");

		boolean[][] boolArr2 = { { true, true, true }, { true, true, true }, { true, true, true } };
		printAllDirection(boolArr2, "", 0, 0);

		System.out.println();
		boolean[][] boolArr3 = { { true, true, true }, { true, true, true }, { true, true, true } };
		printAllPaths(boolArr3, "", 0, 0, new int[boolArr3.length][boolArr3[0].length], 1);

	}

	private static void printAllDirection(boolean[][] arr, String p, int r, int c) {
		if (arr.length - 1 == r && arr[0].length - 1 == c) {
			arr[r][c] = false;
			System.out.print(p + " ");
			return;
		}

		if (!arr[r][c]) {
			return;
		}
		// setting up as false after this is visited
		arr[r][c] = false;

		if (r < arr.length - 1) {
			printAllDirection(arr, p + "D", r + 1, c);
		}
		if (c < arr[0].length - 1) {
			printAllDirection(arr, p + "R", r, c + 1);
		}
		if (r > 0) {
			printAllDirection(arr, p + "U", r - 1, c);
		}
		if (c > 0) {
			printAllDirection(arr, p + "L", r, c - 1);
		}
		// reverting whatever changes i have done
		arr[r][c] = true;

	}

	private static void printAllPaths(boolean[][] boolArr, String p, int r, int c, int[][] arr, int step) {
		if (boolArr.length - 1 == r && boolArr[0].length - 1 == c) {
			boolArr[r][c] = false;
			arr[r][c] = step;
			for (int[] arr1 : arr) {
				System.out.println(Arrays.toString(arr1));
			}
			System.out.print(p + " ");
			System.out.println();
			return;
		}

		if (!boolArr[r][c]) {
			return;
		}
		// setting up as false after this is visited
		boolArr[r][c] = false;
		arr[r][c] = step;

		if (r < boolArr.length - 1) {
			printAllPaths(boolArr, p + "D", r + 1, c, arr, step + 1);
		}
		if (c < boolArr[0].length - 1) {
			printAllPaths(boolArr, p + "R", r, c + 1, arr, step + 1);
		}
		if (r > 0) {
			printAllPaths(boolArr, p + "U", r - 1, c, arr, step + 1);
		}
		if (c > 0) {
			printAllPaths(boolArr, p + "L", r, c - 1, arr, step + 1);
		}
		// reverting whatever changes i have done
		boolArr[r][c] = true;
		arr[r][c] = 0;

	}

	// output will be 6
	private static int countPossibleDirection(int[][] arr, int r, int c) {
		if (r == -1) {
			return 0;
		}
		if (c == -1) {
			return 0;
		}
		if (r == 0 && c == 0) {
			return 1;
		}

		int oneDir = countPossibleDirection(arr, r - 1, c);
		int secDir = countPossibleDirection(arr, r, c - 1);

		return oneDir + secDir;
	}

	// Output will be DDRR DRDR DRRD RDDR RDRD RRDD
	// Better Way not to call recurssion when r or c becomes less than 0
	private static void printWays1(int[][] arr, String p, int r, int c) {
		if (r == 0 && c == 0) {
			System.out.print(p + " ");
			return;
		}
		if (r > 0)
			printWays1(arr, p + "D", r - 1, c);
		if (c > 0)
			printWays1(arr, p + "R", r, c - 1);
	}

	// Output will be DDRR DRDR DRRD RDDR RDRD RRDD
	private static void printWays(int[][] arr, String p, int r, int c) {
		if (r == -1) {
			return;
		}
		if (c == -1) {
			return;
		}
		if (r == 0 && c == 0) {
			System.out.print(p + " ");
			return;
		}
		printWays(arr, p + "D", r - 1, c);
		printWays(arr, p + "R", r, c - 1);
	}

	// returning in list
	private static ArrayList<String> printWays2(int[][] arr, String p, int r, int c) {
		if (r == 0 && c == 0) {
			ArrayList<String> al = new ArrayList<String>();
			al.add(p);
			return al;
		}
		ArrayList<String> left = new ArrayList<String>();
		ArrayList<String> right = new ArrayList<String>();
		if (r > 0)
			left = printWays2(arr, p + "D", r - 1, c);
		if (c > 0)
			right = printWays2(arr, p + "R", r, c - 1);

		left.addAll(right);

		return left;
	}

	// Adding diagonally too
	private static ArrayList<String> printWays3(int[][] arr, String p, int r, int c) {
		if (r == 0 && c == 0) {
			ArrayList<String> al = new ArrayList<String>();
			al.add(p);
			return al;
		}
		ArrayList<String> list = new ArrayList<String>();

		if (r > 0)
			list.addAll(printWays3(arr, p + "V", r - 1, c));
		if (c > 0)
			list.addAll(printWays3(arr, p + "H", r, c - 1));
		if (r > 0 && c > 0)
			list.addAll(printWays3(arr, p + "D", r - 1, c - 1));

		return list;
	}

	private static void avoidObstacles(boolean[][] boolArr, String p, int r, int c) {

		if (r == boolArr.length - 1 && c == boolArr[0].length - 1) {
			System.out.print(p + " ");
			return;
		}

		if (!boolArr[r][c]) {
			return;
		}

		if (r < boolArr.length - 1)
			avoidObstacles(boolArr, p + "D", r + 1, c);
		if (c < boolArr[0].length - 1)
			avoidObstacles(boolArr, p + "R", r, c + 1);

	}

	private static void avoidObstaclesDiagonal(boolean[][] boolArr, String p, int r, int c) {

		if (r == boolArr.length - 1 && c == boolArr[0].length - 1) {
			System.out.print(p + " ");
			return;
		}

		if (!boolArr[r][c]) {
			return;
		}

		if (r < boolArr.length - 1)
			avoidObstaclesDiagonal(boolArr, p + "V", r + 1, c);
		if (c < boolArr[0].length - 1)
			avoidObstaclesDiagonal(boolArr, p + "H", r, c + 1);

		if (r < boolArr.length - 1 && c < boolArr[0].length - 1)
			avoidObstaclesDiagonal(boolArr, p + "D", r + 1, c + 1);

	}
}