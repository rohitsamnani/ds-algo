package graph;

import java.util.ArrayList;

/*
 * Undirected Graph
 * Node n= 7 & Edge m = 6
 * edges are: 1-2, 2-4, 2-7, 4-6, 6-7 & 3-5    => so total two components
 */
public class DFS {
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	static int[] vis = new int[8];
	static int n = 7;
	static int m = 6;

	public static void main(String[] args) {
		addNodes(adj, n);
		printIt(adj);

		for (int i = 1; i < vis.length; i++) {
			if (vis[i] == 0) {
				dfs(i);
			}
		}
	}

	private static void dfs(int node) {
		System.out.print(node + " ");
		vis[node] = 1;
		for (Integer i : adj.get(node)) {
			if (vis[i] == 0) {
				dfs(i);
			}
		}

	}

	private static void printIt(ArrayList<ArrayList<Integer>> adj) {
		System.out.print("{");
		for (int i = 0; i < adj.size(); i++) {
			System.out.print("{");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(adj.get(i).get(j));
				if (j != adj.get(i).size() - 1) {
					System.out.print(", ");
				}

			}
			System.out.print("} ");
		}
		System.out.print("}");
		System.out.println();
	}

	private static void addNodes(ArrayList<ArrayList<Integer>> adj, int n) {
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<Integer>());
		}

		// 1-2
		adj.get(1).add(2);
		adj.get(2).add(1);

		// 2-4
		adj.get(2).add(4);
		adj.get(4).add(2);

		// 2-7
		adj.get(2).add(7);
		adj.get(7).add(2);

		// 4-6
		adj.get(4).add(6);
		adj.get(6).add(4);

		// 6-7
		adj.get(6).add(7);
		adj.get(7).add(6);

		// 3-5
		adj.get(3).add(5);
		adj.get(5).add(3);

	}
}
