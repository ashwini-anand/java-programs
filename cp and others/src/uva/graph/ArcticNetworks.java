package uva.graph;

import java.util.Arrays;
import java.util.Scanner;

public class ArcticNetworks {
	static class Edge implements Comparable<Edge> {
		int src;
		int dest;
		double weight;

		public int compareTo(Edge e) {
			if(this.weight > e.weight){
				return 1;
			}
			if(this.weight < e.weight){
				return -1;
			}
			return 0;
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
		int t = in.nextInt();

		while (t-- > 0) {
			int s = in.nextInt();
			int p = in.nextInt();

			int x[] = new int[p];
			int y[] = new int[p];
			
			for (int i = 0; i < p; i++) {
				x[i] = in.nextInt();
				y[i] = in.nextInt();
			}
			int numOfEdges = p*(p-1);
			numOfEdges = numOfEdges/2;
			edges = new Edge[numOfEdges];
			sptree = new Edge[p-1];
			res = 0;
			subsets = new Subset[p];
			int k =0;
			for (int i = 0; i < p; i++) {
				for (int j = i+1; j < p; j++) {
					double wt = Math.sqrt((x[i]-x[j])*(x[i]-x[j]) + (y[i]-y[j])*(y[i]-y[j]));
					Edge ed = new Edge();
					ed.src = i;
					ed.dest = j;
					ed.weight = wt;
					edges[k++] = ed;
				}
			}

//			for (int i = 0; i < numOfEdges; i++) {
//				System.out.println(edges[i].weight);
//			}
			//System.out.println(k+" "+numOfEdges);
			//System.out.println(edges[1].weight);
			Arrays.sort(edges);
			kruskal();
			System.out.printf("%.2f", sptree[p-s-1].weight);
			System.out.println();
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
			}
		}
	}
}
