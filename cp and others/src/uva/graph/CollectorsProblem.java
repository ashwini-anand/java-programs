package uva.graph;

import java.util.LinkedList;
import java.util.Scanner;

public class CollectorsProblem {

	/**
	 * @param args
	 */
	static int[][] graph;
	static int[][] rGraph;
	static int[] parent;

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
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int tc = 1;
		while(tc <= t){
			int n = in.nextInt();
			int m = in.nextInt();
			graph = new int[n+m+1][n+m+1];
			
			for (int i = 0; i < n; i++) {
				int[] count = new int[m];
				int k =in.nextInt();
				for (int j = 0; j < k; j++) {
					count[in.nextInt()-1]++;
				}
				if(i==0){
					for (int j = 0; j < count.length; j++) {
						graph[0][j+1] = count[j];
					}
				}else{
					int v = m+i;
					for (int j = 0; j < count.length; j++) {
						if(count[j] == 0){
							graph[j+1][v] =1;
						}
						if(count[j] > 1){
							graph[v][j+1] = count[j] -1;
						}
					}
				}
			}
			for (int i = 1; i <=m; i++) {
				graph[i][n+m] = 1;
			}
			System.out.println("Case #"+tc+": "+fordFulkerson(0, n+m));
			tc++;
		}

	}

}
