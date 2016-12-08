package hr;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class nodes {
	int index;
	List<Integer> adj = new LinkedList<Integer>();
}

class graph {
	int numOfnodes;
	nodes[] nodes;

	graph(int n) {
		numOfnodes = n;
		nodes = new nodes[n];
	}
}

public class SwappingBridgesBFS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int t = s.nextInt();
		while (t > 0) {
			t--;
			int numofnodes = s.nextInt();

			graph g = new graph(numofnodes);
			for (int i = 0; i < g.numOfnodes; i++) {
				g.nodes[i] = new nodes();
				int adjn = s.nextInt();
				g.nodes[i].adj.add(adjn - 1);

			}
			boolean[] visited = new boolean[g.numOfnodes];

			int swap = -1;
			for (int i = 0; i < visited.length; i = (i + 1) ) {
				if (!visited[i]) {
					//System.out.println("i="+i);
					swap++;
					//System.out.println(g.nodes[i].adj.get(0)+"-------");
					bfs(g, i, visited);
					
					//System.out.println("Here------");
				}
			}
			System.out.println((swap));
		}
	}

	public static void bfs(graph g, int n, boolean[] visited) {
		LinkedList<Integer> queue = new LinkedList<Integer>();

		queue.add(n);
		visited[n] = true;

		while (queue.isEmpty() == false) {
			int s = queue.poll();
			for (int i = 0; i < g.nodes[s].adj.size(); i++) {
				//System.out.println(g.nodes[i].adj.get(0)+"-------");
				if (!visited[g.nodes[s].adj.get(i)]) {
					//System.out.println("here g.nodes[s].adj.get(i)="+g.nodes[s].adj.get(i));
					visited[g.nodes[s].adj.get(i)] = true;
					queue.add(g.nodes[s].adj.get(i));
				}
			}
		}
	}

}
