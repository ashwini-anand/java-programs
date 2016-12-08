package uva.graph;

import java.util.*;

public class DarkRoads {
	static class Edge implements Comparable<Edge> {
		int src;
		int dest;
		int weight;

		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}

	static class Subset {
		int parent;
		int rank;
	}

	public static Edge[] edges;
	public static Subset[] subsets;
	public static int res;
	public static Edge[] sptree;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (true) {
			int m = in.nextInt();
			int n = in.nextInt();

			if (m == 0 && n == 0)
				break;

			edges = new Edge[n];
			sptree = new Edge[n];// size should be m-1 instead of n
			res = 0;
			subsets = new Subset[m];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				Edge ed = new Edge();
				ed.src = in.nextInt();
				ed.dest = in.nextInt();
				ed.weight = in.nextInt();
				sum += ed.weight;
				edges[i] = ed;
			}

			Arrays.sort(edges);
			kruskal();
			System.out.println(sum - res);
		}

		in.close();

	}

	public static int find(int v) {
		if (subsets[v].parent != v) {
			subsets[v].parent = find(subsets[v].parent);
		}

		return subsets[v].parent;
	}

	public static void union(int x, int y) {
		int xroot = find(x);
		int yroot = find(y);

		if (subsets[xroot].rank < subsets[yroot].rank) {
			subsets[xroot].parent = yroot;
		} else if (subsets[xroot].rank > subsets[yroot].rank) {
			subsets[yroot].parent = xroot;
		} else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}

	}

	public static void kruskal() {

		int j = 0;
		int m = subsets.length;
		for (int i = 0; i < m; i++) {
			subsets[i] = new Subset();
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}

		int k = 0;
		while (k < m - 1) {
			Edge ed = new Edge();
			ed = edges[j++];
			int xroot = find(ed.src);
			int yroot = find(ed.dest);

			if (xroot != yroot) {
				sptree[k++] = ed;
				union(xroot, yroot);
				res += ed.weight;
			}
		}
	}
}