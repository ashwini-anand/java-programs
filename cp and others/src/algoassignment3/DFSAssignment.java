package algoassignment3;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DFSAssignment {

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
	static int time = 0;

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		System.out.println("Enter the number of nodes");
		int numOfnodes = s.nextInt();
		graph g = new graph(numOfnodes);

		for (int i = 0; i < numOfnodes; i++) {
			g.nodes[i] = new nodes();
			g.nodes[i].index = i;
		}

		System.out.println("Enter number of edges");
		int numOfEdges = s.nextInt();

		System.out
				.println("Enter type of graph. Enter 0 for Undirected and 1 for Directed.");
		int gtype = s.nextInt();

		System.out.println("Enter edges");

		if (gtype == 0) {
			for (int i = 0; i < numOfEdges; i++) {
				int u = s.nextInt();
				int v = s.nextInt();
				g.nodes[u].adj.add(g.nodes[v]);
				g.nodes[v].adj.add(g.nodes[u]);
			}
		} else {
			for (int i = 0; i < numOfEdges; i++) {
				int u = s.nextInt();
				int v = s.nextInt();
				g.nodes[u].adj.add(g.nodes[v]);
			}
		}

		System.out.println("Enter the start vertex for BFS");
		int start = s.nextInt();
		System.out.println("DFS traversal is: ");
		dfs(g, g.nodes[start]);

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

	public static void dfsutil(graph g, nodes s) {
		time++;
		visited[s.index] = true;
		s.discTime = time;
		System.out.print(s.index + " ");

		for (int i = 0; i < s.adj.size(); i++) {
			if (!visited[s.adj.get(i).index]) {
				visited[s.adj.get(i).index] = true;
				s.adj.get(i).parent = s;
				dfsutil(g, s.adj.get(i));
			}
		}
		time++;
		s.finishTime = time;
	}
}
