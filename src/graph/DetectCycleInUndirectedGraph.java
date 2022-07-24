package graph;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Detect a cycle in undirected graph, this can be achieve using BFS
 * n=11, edges are : 1-2, 2-4, 3-5, 5-10, 10-9, 9-8, 8-11, 5-6, 6-7, 7-8
 * 
 */

public class DetectCycleInUndirectedGraph {
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	static int[] vis = new int[12];
	static int n = 11;
	public static void main(String[] args) {
		addNodes(adj, n);
		printIt(adj);
		for (int i = 1; i < vis.length; i++) {
			if (vis[i] == 0) {
				if(detectCycle(i)) {
					System.out.println(true);
				}
			}
		}
	}
	
	static boolean detectCycle(int node) {
		Queue<SimpleEntry<Integer,Integer>> q = new LinkedList<>();
		q.add(new SimpleEntry<>(node, -1));
		vis[node]= 1;
		
		while(!q.isEmpty()) {
			SimpleEntry se = q.poll();
			int k= (Integer)se.getKey();
			int v = (Integer) se.getValue();
			for(Integer i: adj.get(k)) {
				if(vis[i]==0) {
					q.add(new SimpleEntry<>(i,k));
					vis[i]=1;
				}
				else if(v!=i && v!=-1) {
					return true;
				}
			}
		}
		return false;
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
		int[][] edges = {{1,2}, {2,4}, {3,5}, {5,10}, {10,9}, {9,8}, {8,11}, {5,6}, {6,7}, {7,8}};
		for(int[] k : edges) {
			adj.get(k[0]).add(k[1]);
			adj.get(k[1]).add(k[0]);
		}
	
	}
}
