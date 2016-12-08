package hr;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EvenTree {

	static class nodes {
		int index = -1;
		nodes parent = null;
		int discTime = -1;
		int finishTime = -1;
		List<nodes> adj = new LinkedList<nodes>();
	}

	static class graph {
		nodes[] nodes;

		graph(int n) {
			nodes = new nodes[n];
		}
	}

	static boolean visited[];
	static int countc[];
	static int time = 0;

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int numOfnodes = s.nextInt();
		graph g = new graph(numOfnodes);
        countc = new int[numOfnodes];
        Arrays.fill(countc, 1);
		for (int i = 0; i < numOfnodes; i++) {
			g.nodes[i] = new nodes();
			g.nodes[i].index = i;
		}

		int numOfEdges = s.nextInt();

			for (int i = 0; i < numOfEdges; i++) {
				int u = s.nextInt();
				int v = s.nextInt();
				g.nodes[u-1].adj.add(g.nodes[v-1]);
				g.nodes[v-1].adj.add(g.nodes[u-1]);
			}

		dfs(g, g.nodes[0]);
		int numDelEdges =0;
		for (int i = 1; i < numOfEdges; i++) {
			if(countc[i]%2==0) numDelEdges++;
		}
		System.out.println(numDelEdges);

	}

	public static void dfs(graph g, nodes v) {
		int count = 0;
		visited = new boolean[g.nodes.length];
		for (int i = v.index; count < g.nodes.length; i = (i + 1)
				% visited.length) {
			count++;
			if (!visited[i]) {
				dfsutil(g, g.nodes[i]);
			}
		}
	}

	public static int dfsutil(graph g, nodes s) {
		time++;
		visited[s.index] = true;
		s.discTime = time;
		//System.out.print(s.index + " ");

		for (int i = 0; i < s.adj.size(); i++) {
			if (!visited[s.adj.get(i).index]) {
				visited[s.adj.get(i).index] = true;
				s.adj.get(i).parent = s;
				countc[s.index] += dfsutil(g, s.adj.get(i));
			}
		}
		time++;
		s.finishTime = time;
		//System.out.println("s.index="+s.index+"  count="+countc[s.index]);
		return countc[s.index];
	}
}
