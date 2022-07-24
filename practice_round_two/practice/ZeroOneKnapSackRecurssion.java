package practice;

import java.util.ArrayList;
import java.util.List;

public class ZeroOneKnapSackRecurssion {

	static int[][] t ;
	static List<Integer> data= new ArrayList<>();
	public static void main(String[] args) {
		int w[] = { 50, 75, 175, 110, 155 };
		int v[] = { 1, 2, 3, 4, 5 };
		int n = w.length;
		int W = 200;
		t= new int[n+1][W+1];
		for(int x=0;x<t.length;x++) {
			for(int y=0;y<t[x].length;y++) {
				t[x][y]=0;
			}
		}
		int res=knapsack(w, v, W, n);
		System.out.println(res);
		System.out.println("Result");
		takeOutIndexes(res,W,n,w,v);
		System.out.println();
		System.out.println("ends here");
		System.out.println();
		printknapSack(w, v, W, n);

		

	}

	
	
	private static void takeOutIndexes(int res, int w, int n, int[] wt, int[] v) {
		for(int i=n;i>0 && res>0;i--) {
			if(t[i-1][w]==res) {
				continue;
			}
			else {
				System.out.print(v[i-1]+" ");
				res=res-v[i-1];
				w=w-wt[i-1];
				
			}
		}
		
	}



	private static int knapsack(int[] w, int[] v, int W, int n) {
		if (W == 0 || n == 0) {
			return 0;
		}
		if(t[n][W]!=0) {
			return t[n][W];
			
		}

		if (w[n - 1] <= W) {
			return t[n][W]= Math.max(v[n - 1] + (knapsack(w, v, W - w[n - 1], n - 1)), knapsack(w, v, W, n - 1));
		} else {
			return t[n][W]=knapsack(w, v, W, n - 1);
		}

	}

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	static void printknapSack(int wt[], int val[], int W, int n) {
		int i, w;
		int K[][] = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		// stores the result of Knapsack
		int res = K[n][W];
		System.out.println(res);

		w = W;
		for (i = n; i > 0 && res > 0; i--) {

			// either the result comes from the top
			// (K[i-1][w]) or from (val[i-1] + K[i-1]
			// [w-wt[i-1]]) as in Knapsack table. If
			// it comes from the latter one/ it means
			// the item is included.
			if (res == K[i - 1][w])
				continue;
			else {

				// This item is included.
				System.out.print(wt[i - 1] + " ");

				// Since this weight is included its
				// value is deducted
				res = res - val[i - 1];
				w = w - wt[i - 1];
			}
		}
	}
}
