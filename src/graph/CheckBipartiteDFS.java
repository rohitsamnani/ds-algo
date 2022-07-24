package graph;

import java.util.ArrayList;

public class CheckBipartiteDFS {
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	static int[] vis = new int[9];
	static int n = 8;

	public static void main(String[] args) {
		addNodes(adj, n);
		printIt(adj);
		for (int i = 0; i < vis.length; i++) {
			vis[i] = -1;
		}
		for (int i = 1; i < vis.length; i++) {
			if (vis[i] == -1) {
				vis[i] = 1;
				System.out.println(checkBipartite(i, -1, -1));
				System.exit(0);
			}
		}
	}

	static boolean checkBipartite(int value, int parent, int parentColor) {
		if (vis[value] == -1) {
			if (parentColor == 0) {
				vis[value] = 1;
			} else {
				vis[value] = 0;
			}
		} else {
			if (vis[value] == parentColor) {
				return false;
			}
		}
		for (Integer i : adj.get(value)) {
			if (vis[i] == -1)
				return checkBipartite(i, value, vis[value]);

		}

		return true;
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
		int[][] edges = { { 1, 2 }, { 2, 3 }, { 2, 8 }, { 3, 4 }, { 5, 8 }, { 4, 5 }, { 5, 6 }, { 6, 7 } }; // false
		// int[][] edges = { { 1, 2 }, { 2, 3 }, { 2, 7 }, { 3, 4 }, { 6, 7 }, { 4, 5
		// },{ 5, 6 }, { 5, 8 } }; // true
		for (int[] k : edges) {
			adj.get(k[0]).add(k[1]);
			adj.get(k[1]).add(k[0]);
		}

	}

}
