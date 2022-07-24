package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//check graph is bipartite graph or not using BFS
public class CheckBipartiteBFS {

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
				System.out.println(checkBipartite(i));
				System.exit(0);
			}
		}
	}

	static boolean checkBipartite(int value) {
		Queue<Integer> q = new LinkedList<>();
		q.add(value);
		vis[value] = 0;

		while (!q.isEmpty()) {
			int key = q.poll();
			for (Integer i : adj.get(key)) {
				if (vis[i] == -1) {
					if (vis[key] == 0) {
						vis[i] = 1;
					} else {
						vis[i] = 0;
					}
					q.add(i);
				} else {
					if (vis[i] == vis[key]) {
						return false;
					}
				}
			}
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
		//int[][] edges = { { 1, 2 }, { 2, 3 }, { 2, 8 }, { 3, 4 }, { 5, 8 }, { 4, 5 }, { 5, 6 }, { 6, 7 } };			//false
		int[][] edges = { { 1, 2 }, { 2, 3 }, { 2, 7 }, { 3, 4 }, { 6, 7 }, { 4, 5 }, { 5, 6 }, { 5, 8 } };		//true
		for (int[] k : edges) {
			adj.get(k[0]).add(k[1]);
			adj.get(k[1]).add(k[0]);
		}

	}

}
