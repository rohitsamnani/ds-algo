package backtracking;

import java.util.ArrayList;

class Solution {
	static ArrayList<String> al = new ArrayList<>();

	public static ArrayList<String> findPath(int[][] m, int n) {
		ratPath(m, "", 0, 0, new int[n][n]);
		return al;
	}

	private static void ratPath(int[][] arr, String p, int r, int c, int[][] pArr) {
		if (r == arr.length - 1 && c == arr[0].length - 1) {
			arr[r][c]=1;
			pArr[r][c] = 1;
			for (int[] row : pArr) {
				for (int col : row) {
					System.out.print(col + " ");
				}
				System.out.println();
			}
			System.out.println();
			al.add(p);
			return;
		}

		if (arr[r][c] == 0) {
			return;
		}

		pArr[r][c] = 1;
		arr[r][c] = 1;

		if (r < arr.length - 1 && isSafe(arr, r, c)) {
			ratPath(arr, p + "D", r + 1, c, pArr);
		}

		if (c < arr[0].length - 1 && isSafe(arr, r, c)) {
			ratPath(arr, p + "R", r, c + 1, pArr);
		}
		if (r > 0 && isSafe(arr, r, c))
			ratPath(arr, p + "U", r - 1, c, pArr);

		if (c > 0 && isSafe(arr, r, c))
			ratPath(arr, p + "L", r, c - 1, pArr);
		arr[r][c] = 0;
		pArr[r][c] = 0;

	}

	private static boolean isSafe(int[][] arr, int r, int c) {
		if (arr[r][c] == 0)
			return false;

		return true;
	}

	public static void main(String[] args) {

		System.out.println("----------------------------------Rate Maze--------------------------");

		System.out.println();
		findPath(new int[][] { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } }, 4);
		for (String element : al) {
			System.out.print(element + " ");
		}
	}
}