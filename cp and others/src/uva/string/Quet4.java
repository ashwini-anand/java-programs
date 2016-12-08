// First 4 test cases are passing

package uva.string;

import java.util.ArrayList;
import java.util.Scanner;

public class Quet4 {

	/**
	 * @param args
	 */
	
	static class Node {
		int index;
		ArrayList<Integer> neigh = new ArrayList<>();
	}
	
	static Node graph[];
	static boolean visited[];
	static int balances[];
	static int bl;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		while(t-- >0){
			int n = in.nextInt();
			graph = new Node[n];
			balances = new int[n];

			for (int i = 0; i < n; i++) {
				Node nd = new Node();
				nd.index = i;
				graph[i] = nd;
			}
			
			for (int i = 0; i < n-1; i++) {
				int src = in.nextInt()-1;
				int dest = in.nextInt()-1;
				graph[src].neigh.add(dest);
				graph[dest].neigh.add(src);
			}
			
			int maxBl = Integer.MIN_VALUE;
			bl =Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				int count =0;
				ArrayList<Integer> tmpNeigh = new ArrayList<>();
				tmpNeigh.addAll(graph[i].neigh);
				visited = new boolean[n];
				graph[i].neigh.clear();
				maxBl = Integer.MIN_VALUE;
				for (int j = 0; j < n; j++) {
					if(j!=i){
						if(visited[j]==false){
							bl =1;
							count++;
							dfs2(j);
						}
					}
//					if(i==0){
//						System.out.println(bl+" ");
//					}
					maxBl = bl > maxBl ? bl : maxBl;
				}
				balances[i] = maxBl;
				graph[i].neigh.addAll(tmpNeigh);
			}
			
			int min =Integer.MAX_VALUE;
			int idx = -1;
			for (int i = 0; i < balances.length; i++) {
				if(balances[i] < min){
					min = balances[i]-1;
					idx = i+1;
				}
			}
			//System.out.println(Arrays.toString(balances));
			System.out.println(min+" "+idx);
		}

	}
	
	public static void dfs2(int idx) {
		visited[idx] = true;
		for (int i = 0; i < graph[idx].neigh.size(); i++) {
			int k = graph[idx].neigh.get(i);
			if (!visited[k]) {
				bl++;
				dfs2(k);
			}
		}
	}

}
