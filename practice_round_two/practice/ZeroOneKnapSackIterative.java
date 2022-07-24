package practice;

public class ZeroOneKnapSackIterative {
	static int[][] t;

	public static void main(String[] args) {
		int w[] = { 50, 75, 175, 110, 155 };
		int v[] = { 1, 2, 3, 4, 5 };
		int n = w.length;
		int W = 200;
		printknapSack(w, v, W, n);

	}

	private static void printknapSack(int[] w, int[] v, int W, int n) {
		int[][] k = new int[n+1][W+1];
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=W;j++) {
				if(i==0 || j==0) {
					k[i][j]=0;
				}
				else if(w[i-1]<=j) {
					k[i][j]=Math.max((v[i-1]+k[i-1][j-w[i-1]]), k[i-1][j]);
				}
				else {
					k[i][j]=k[i-1][j];
				}
			}
		}
		for(int[] c:k) {
			for(int d:c) {
				System.out.print(d+" ");
			}
			System.out.println();
		}
		
		System.out.println("Answer will be: ");
		System.out.println(k[n][W]);
		System.out.println("Indexes will be below: ");
		int res = k[n][W];
		for(int i=n-1;n>0 && res>0;i--) {
			if(res==k[i][W]) {
				continue;
			}
			else {
				System.out.print(v[i]+" ");
				res=res-v[i];
				W= W-w[i];
			}
		}
	}
}