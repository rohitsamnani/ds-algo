package example;

public class MagicSquare {

	public static void main(String[] args) {
		printMagicSquare(3);
	}

	private static void printMagicSquare(int n) {
		
		int [][] arr= new int[n][n];
		
		int i=n/2;
		int j=n-1;
		
		for(int num=1;num<=n*n;) {
			if(i==-1 && j==n) {
				i=0;
				j=n-2;
			}
			else {
				if(i<0)
					i=n-1;
				if(j==n)
					j=0;
			}
			if(arr[i][j]!=0) {
				i++;
				j-=2;
				continue;
			}
			else {
				arr[i][j]=num++;
			}
			i--;j++;
		}
		for(int x=0;x<n;x++) {
			for(int y=0;y<n;y++) {
				System.out.print(arr[x][y]+" ");
			}
			System.out.println();
		}
	}
}
