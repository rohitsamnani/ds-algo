package graph;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindPath {	    
	    public boolean validPath(int n, int[][] edges, int source, int destination) {
	        
	        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		    int[] vis = new int[n+1]; 
			for (int[] k : edges) {
				adj.get(k[0]).add(k[1]);
				adj.get(k[1]).add(k[0]);
			}
	        	for (int i = 1; i < vis.length; i++) {
				if (vis[i] == 0) {
					if(detectCycle(i,edges,vis,adj)) {
						return true;
					}
				}
			}
	        return false;
	        }
	    static boolean detectCycle(int node, int[][] edges, int[] vis, ArrayList<ArrayList<Integer>> adj) {
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
	    }
