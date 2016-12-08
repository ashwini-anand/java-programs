package gfg;

import java.util.LinkedList;
import java.util.Scanner;

public class Test3 {

	/**
	 * @param args
	 */
	static int[][] graph;
	static int[][] rGraph;
	static int[] parent;
    static int max = 999999;
	public static boolean bfs(int s, int t) {
		int size = graph.length;
		boolean vis[] = new boolean[size];
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(s);
		vis[s] = true;
		parent[s] = -1;

		while (queue.size() != 0 && !vis[t]) {
			int u = queue.poll();
			for (int v = 0; v < vis.length; v++) {
				if (!vis[v] && rGraph[u][v] > 0) {
					queue.add(v);
					parent[v] = u;
					vis[v] = true;
				}
			}
		}

		return (vis[t] == true);

	}

	public static int fordFulkerson(int s, int t) {

		int size = graph.length;
		rGraph = new int[size][size];
		parent = new int[size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				rGraph[i][j] = graph[i][j];
			}
		}

		int maxFlow = 0;

		while (bfs(s, t)) {
			int pathFlow = Integer.MAX_VALUE;
			for (int v = t; v != s; v = parent[v]) {
				int u = parent[v];
				pathFlow = Math.min(pathFlow, rGraph[u][v]);
			}
			for (int v = t; v != s; v = parent[v]) {
				int u = parent[v];
				rGraph[u][v] -= pathFlow;
				rGraph[v][u] += pathFlow;
			}

			maxFlow += pathFlow;
		}
		return maxFlow;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- >0){
			int n = in.nextInt();
			int m = in.nextInt();
			graph = new int[n+m+2][n+m+2];
			int sch[] = new int[n];
			for (int i = 1; i <= m; i++) {
				for (int j = 0; j < n; j++) {
					sch[j] = in.nextInt();
				}
				int k = in.nextInt();
				for (int j = 0; j < n; j++) {
					if(sch[j]==1){
						graph[n+i][j+1] = k;
					}
				}
			}
			for (int i = 1; i <=n; i++) {
				graph[i][0] = max;
			}
			for (int i = n+1; i <= n+m; i++) {
				graph[n+m+1][i] = max;
			}
//			for (int i = 0; i < graph.length; i++) {
//				for (int j = 0; j <graph.length; j++) {
//					System.out.print(graph[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			System.out.print(fordFulkerson(n+m+1,0)/n+" ");
//			for (int i = 0; i < rGraph.length; i++) {
//				for (int j = 0; j <rGraph.length; j++) {
//					System.out.print(rGraph[i][j]+" ");
//				}
//				System.out.println();
//			}
		}

	}

}
