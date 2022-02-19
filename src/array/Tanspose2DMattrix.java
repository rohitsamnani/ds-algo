package array;

public class Tanspose2DMattrix {
			
		public static void main(String[] args) {
			
			int[][] arr= {{23,3,4},{23,4,1},{25,54,5},{22,13,6},{15,5,84}};
			print2DArray(arr);
			int arr1[][]=transpostTwoDArray(arr);
			System.out.println("------------------");
			print2DArray(arr1);
		}
		
		private static void print2DArray(int[][] arr) {
			for(int r=0;r<arr.length;r++) {
				for(int c=0;c<arr[r].length;c++) {
					System.out.print(arr[r][c]+",");
				}
				System.out.println();
			}
			
		}

		static int[][] transpose2DArray(int[][] arr) {
			int row = arr.length;
			int col = arr[0].length;
			int targetArray[][] = new int[col][row];
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					targetArray[j][i]=arr[i][j];
				}
			}
			return targetArray;
	}
		
		
		static int[][] transpostTwoDArray(int [][]arr){
			int targetArray[][] = new int[arr[0].length][arr.length];
			int row= arr.length;
			int col=arr[0].length;
			for(int r=0;r<row;r++) {
				for(int c=0;c<col;c++) {
					targetArray[c][r]=arr[r][c];
				}
			}
			return targetArray;
		}
}
