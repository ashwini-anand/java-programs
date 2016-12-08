// This program gives number of connected components.
// Note : this program is not extremely tested. Be cautious while using it.
// It can be use to print connected components with slight modification. Look into http://www.geeksforgeeks.org/strongly-connected-components/
// Input format is as below:
//1  /* Number of test cases */
//3 2  /* num of vertices and edges respectively. Index starts from 1 */ 
//1 2
//2 3
//ans: 3
// Input 2:
//1
//5 5
//2 1
//1 3
//3 2
//1 4
//4 5
// ans: 3

package gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StronglyConnectedComponents {

	/**
	 * @param args
	 */
	static class Node {
		int index;
		ArrayList<Integer> neigh = new ArrayList<>();
	}

	static Node graph[];
	static boolean visited[];
	static Stack<Integer> st;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		while (t-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			graph = new Node[n];
			visited = new boolean[n];

			for (int i = 0; i < n; i++) {
				Node nd = new Node();
				nd.index = i;
				graph[i] = nd;
			}
			for (int i = 0; i < m; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				graph[x - 1].neigh.add(y - 1);
				// graph[y-1].neigh.add(x-1);
			}

			int count = 0;
			st = new Stack<>();
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					dfs1(i);
				}
			}
			reverseGraph();
//			System.out.println(st.toString());
			Arrays.fill(visited, false);
			while (!st.isEmpty()) {
				int v = st.pop();
				if (!visited[v]) {
					count++;
					dfs2(v);
				}
			}
			System.out.println(count);
		}
		in.close();

	}

	public static void reverseGraph() {
		int n = graph.length;
		Node revGraph[] = new Node[n];
		for (int i = 0; i < revGraph.length; i++) {
			Node nd = new Node();
			nd.index = i;
			revGraph[i] = nd;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < graph[i].neigh.size(); j++) {
				int k = graph[i].neigh.get(j);
				revGraph[k].neigh.add(i);
			}
		}
		
		graph = revGraph;

	}

	public static void dfs1(int idx) {
		visited[idx] = true;
		for (int i = 0; i < graph[idx].neigh.size(); i++) {
			int k = graph[idx].neigh.get(i);
			if (!visited[k]) {
				dfs1(k);
			}
		}
		st.push(idx);
	}

	public static void dfs2(int idx) {
		visited[idx] = true;
		for (int i = 0; i < graph[idx].neigh.size(); i++) {
			int k = graph[idx].neigh.get(i);
			if (!visited[k]) {
				dfs2(k); 		// check here : dfs1 or dfs2
			}
		}
	}

}
