package backtracking;

//Time Complexity is O(N!)
public class NQueens {

	public static void main(String[] args) {
		int possbilePlaces = nQueenPossiblePlaces(new boolean[4][4], 0);
		System.out.println(possbilePlaces);
	}

	private static int nQueenPossiblePlaces(boolean[][] boolArr, int row) {
		if (row == boolArr.length) {
			printPlaces(boolArr);
			return 1;
		}
		int counter = 0;
		for (int c = 0; c < boolArr[0].length; c++) {
			if (isSafe(boolArr, row, c)) {
				boolArr[row][c] = true;
				counter += nQueenPossiblePlaces(boolArr, row + 1);
				boolArr[row][c] = false;
			}
		}
		return counter;
	}

	private static boolean isSafe(boolean[][] boolArr, int row, int c) {
		//3 condition require to check
		//1st check vertically queen can go or not
		
		for(int i=0;i<row;i++) {
			if(boolArr[i][c])
				return false;
		}
		
		//2nd check up left Side
		
		int maxPossibleLeft = Math.min(row, c);
		for(int i=1;i<=maxPossibleLeft;i++) {
			if(boolArr[row-i][c-i])
				return false;
		}
		
		//3rd check up right side
		
		int maxPossibleRight = Math.min(row, boolArr.length-1-c);
		for(int i=1;i<=maxPossibleRight;i++) {
			if(boolArr[row-i][c+i])
				return false;
		}
		return true;
	}

	private static void printPlaces(boolean[][] boolArr) {

		for (boolean[] row : boolArr) {
			for (boolean element : row) {
				if (element)
					System.out.print("Q ");
				else
					System.out.print("X ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
