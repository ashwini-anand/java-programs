package gfg;

import java.util.LinkedList;

public class FordFulkerson {

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
		// TODO Auto-generated method stub
		graph = new int[][] { { 0, 16, 13, 0, 0, 0 }, { 0, 0, 10, 12, 0, 0 },
				{ 0, 4, 0, 0, 14, 0 }, { 0, 0, 9, 0, 0, 20 },
				{ 0, 0, 0, 7, 0, 4 }, { 0, 0, 0, 0, 0, 0 } };
		System.out.println("The maximum possible flow is "
				+ fordFulkerson(0, 5));

	}

}
