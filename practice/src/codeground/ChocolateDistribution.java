package codeground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class ChocolateDistribution {

	/**
	 * @param args
	 */
	static class Node {
		int index;
		ArrayList<Integer> neigh = new ArrayList<>();
		int[] moreChoc;
	}

	static Node graph[];
	static Node revgraph[];
	static boolean visited[];
	static Stack<Integer> st;
	static ArrayList<Node> removeList = new ArrayList<>();
	static HashSet<Integer> hset = new HashSet<>();
	static ArrayList<Node> nodeList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		graph = new Node[n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			Node nd = new Node();
			nd.index = i;
			nd.moreChoc = new int[n];
			graph[i] = nd;
		}
		for (int i = 0; i < m; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int more = in.nextInt();
			graph[x - 1].neigh.add(y - 1);
			graph[x - 1].moreChoc[y-1] = more;
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
		nodeList =  new ArrayList<Node>(Arrays.asList(graph));
		// System.out.println(st.toString());
		Arrays.fill(visited, false);
		while (!st.isEmpty()) {
			int v = st.pop();
			if (!visited[v]) {
				//count++;
				dfs2(v);
			}
			nodeList.removeAll(removeList);
			//hset.addAll(removeList);
			for (int i = 0; i < removeList.size(); i++) {
				hset.add(removeList.get(i).index);
			}
			removeList.clear();
		}
		//System.out.println(count);
		
		for (int i = 0; i < nodeList.size(); i++) {
			Node nn = nodeList.get(i);
			for (int j = 0; j < nn.neigh.size(); j++) {
				int nI = nodeList.get(i).neigh.get(j);
				if(hset.contains(nI)){
					nodeList.remove(nn);
				}
			}
		}
		
		
		
		while(!nodeList.isEmpty()){
			for (int i = 0; i < nodeList.size(); i++) {
				Node nn = nodeList.get(i);
				boolean flag = false;
				for (int j = 0; j < nn.moreChoc.length; j++) {
//					if(nn.moreChoc[i] !=0) {
//						
//					}
				}
			}
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

		revgraph = revGraph;

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
		for (int i = 0; i < revgraph[idx].neigh.size(); i++) {
			int k = revgraph[idx].neigh.get(i);
			if (!visited[k]) {
				dfs1(k);
			}
		}
		removeList.add(revgraph[idx]);
	}

}
