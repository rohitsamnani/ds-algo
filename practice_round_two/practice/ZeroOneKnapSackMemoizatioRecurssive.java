package practice;

public class ZeroOneKnapSackMemoizatioRecurssive {
	static int[][] t;

	public static void main(String[] args) {
		int w[] = { 50, 75, 175, 110, 155 };
		int v[] = { 1, 2, 3, 4, 5 };
		int n = w.length;
		int W = 200;
		t = new int[n + 1][W + 1];
		for (int x = 0; x < t.length; x++) {
			for (int y = 0; y < t[x].length; y++) {
				t[x][y] = 0;
			}
		}
		int res = knapsack(w, v, W, n);
		System.out.println(res);
		System.out.println();
		takeOutIndexes(res, W, n, w, v);
	}

	private static void takeOutIndexes(int res, int W, int n, int[] wt, int[] v) {
		
		for(int i=n;i>0 && res>0;i--) {
			if(t[i-1][W]==res) {
				continue;
			}
			else {
				System.out.print(v[i-1]+" ");
				res=res-v[i-1];
				W=W-wt[i-1];
			}
		}

	}

	private static int knapsack(int[] wt, int[] v, int W, int n) {

		if(W==0 || n==0) {
			return 0;
		}
		
		if(t[n][W]!=0) {
			return t[n][W];
		}
		
		if(wt[n-1]<=W) {
			return t[n][W]=Math.max((v[n-1]+(knapsack(wt, v, W-wt[n-1], n-1))), knapsack(wt, v, W, n-1));
		}
		else {
			return t[n][W]=knapsack(wt, v, W, n-1);
		}
	}

}
