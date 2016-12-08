package algoassignment3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BinaryTree {

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

		int t = s.nextInt();
		while (t > 0) {
			t--;
			//System.out.println("Enter the number of nodes");
			int numOfnodes = s.nextInt();
			graph g = new graph(numOfnodes);

			for (int i = 0; i < numOfnodes; i++) {
				g.nodes[i] = new nodes();
				g.nodes[i].index = i;
			}

			//System.out.println("Enter number of edges");
			int numOfEdges = s.nextInt();

			int[] childsArr = new int[numOfnodes];
			Arrays.fill(childsArr, 0);
			//System.out.println("Enter edges");

			for (int i = 0; i < numOfEdges; i++) {
				int u = s.nextInt();
				int v = s.nextInt();
				g.nodes[u - 1].adj.add(g.nodes[v - 1]);
				g.nodes[v - 1].adj.add(g.nodes[u - 1]);
				childsArr[u-1] = childsArr[u-1] +1;
				childsArr[v-1] = childsArr[v-1] +1;
			}

			if (numOfEdges != numOfnodes - 1) {
				System.out.println("Not a binary tree");
				continue;
			}
			
			boolean flag = false;
			for (int i = 0; i < childsArr.length; i++) {
				if(childsArr[i] > 3 || childsArr[i] == 0){
					System.out.println("Not a binary tree");
					flag = true;
					break;
				}
			}
			if(flag) continue;
			boolean bt = false;
			 bt = dfs(g, g.nodes[0]);
			if(bt){
				System.out.println("Not a binary tree");
				continue;
			}
			
			System.out.println("Binary tree");
		}

	}

	public static boolean dfs(graph g, nodes v) {
		int count = 0;
		visited = new boolean[g.nodes.length];
		Arrays.fill(visited, false);
		for (int i = v.index; count < g.nodes.length; i = (i + 1)
				% visited.length) {
			count++;
			if (!visited[i]) {
				if(count >= 2){
					return true;
				}
				dfsutil(g, g.nodes[i]);
			}
		}
		if(bool){
			bool = false;
			//System.out.println("near bool2");
			return true;
		}
		//System.out.println(visited[1]);
		return false;
	}

	static boolean bool = false;
	public static void dfsutil(graph g, nodes s) {
		time++;
		visited[s.index] = true;
		s.discTime = time;

		//System.out.println(s.index);
		for (int i = 0; i < s.adj.size(); i++) {
			//System.out.println(s.index);
			if(visited[s.adj.get(i).index] && s.parent != null && s.adj.get(i).index != s.parent.index){
				//System.out.println("near bool");
				bool = true;
				return;
			}
			else if (!visited[s.adj.get(i).index]) {
				visited[s.adj.get(i).index] = true;
				s.adj.get(i).parent = s;
				dfsutil(g, s.adj.get(i));
			}
		}
		time++;
		s.finishTime = time;
	}
}
