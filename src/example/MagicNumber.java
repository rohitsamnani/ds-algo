package example;

public class MagicNumber {
	
	public static void main(String[] args) {
		printMagicSquare(3);
	}

	private static void printMagicSquare(int n) {
		
		int arr[][] = new int[n][n];
		int i= n/2;
		int j=n-1;
		
		for(int num=1;num<=n*n;) {
			//3rd condition
			if(i==-1 && j==n) {
				i=0;
				j=n-2;
			}
			//1st condition if square limit getting cross
			else  {
				if(j==n)
					j=0;
				if(i<0) 
					i=n-1;
		}
			//2nd condition
			if(arr[i][j]!=0) {
				i++;
				j-=2;
				continue;
			}
			//finally set number
			else {
				arr[i][j] = num++;
			}
			//1st condition basic
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
