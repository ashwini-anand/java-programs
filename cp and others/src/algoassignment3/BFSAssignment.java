package algoassignment3;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class nodes {
	int index = -1;
	nodes parent = null;
	int distance = Integer.MAX_VALUE;
	List<nodes> adj = new LinkedList<nodes>();
}

class graph {
	nodes[] nodes;

	graph(int n) {
		nodes = new nodes[n];
	}
}

public class BFSAssignment {

	/**
	 * @param args
	 */
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
		System.out.println("BFS traversal is: ");
		bfs(g, g.nodes[start]);

	}

	public static void bfs(graph g, nodes n) {
		LinkedList<nodes> queue = new LinkedList<nodes>();
		boolean[] visited = new boolean[g.nodes.length];

		queue.add(n);
		n.distance = 0;
		visited[n.index] = true;

		while (queue.isEmpty() == false) {
			nodes s = queue.poll();
			System.out.print(s.index + " ");
			for (int i = 0; i < s.adj.size(); i++) {
				if (!visited[s.adj.get(i).index]) {
					visited[s.adj.get(i).index] = true;
					s.adj.get(i).parent = s;
					s.adj.get(i).distance = s.distance + 1;
					queue.add(s.adj.get(i));
				}
			}
		}
	}

}
