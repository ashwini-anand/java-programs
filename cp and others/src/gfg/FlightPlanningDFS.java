package gfg;

import gfg.FlightPlanning.Node;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class FlightPlanningDFS {

	/**
	 * @param args
	 */
	
	static class Node{
		int idx;
		int depth;
		
		public Node(){
			
		}
		public Node(int idx, int depth) {
			super();
			this.idx = idx;
			this.depth = depth;
		}
		
	}
	
	static  Node nodesarr[];
	static boolean adjmatrix[][];
	static Stack<Node> st = new Stack<>();
	static int max;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		while(t>0){
			t--;
			int n = s.nextInt();
			adjmatrix = new boolean[n][n];
			nodesarr = new Node[n];
			vis= new boolean[n];
			for (int i = 0; i < nodesarr.length; i++) {
				Node node = new Node(i,0);
				nodesarr[i] = node;
			}
			
			for (int i = 0; i < n-1; i++) {
					int c1 = s.nextInt()-1;
					int c2 = s.nextInt()-1;
					adjmatrix[c1][c2] = adjmatrix[c2][c1] = true;
			}
			st.clear();
			max = -1;
			Node node1 = new Node();
			dfs(nodesarr[0]);
			//System.out.println(st.size());
			while(true){
				node1 = st.pop();
				if(node1.depth == max) break;
			}
			
			st.clear();
			max = -1;
			dfs(node1);
			Node node2 = new Node();
			while(true){
				node2 = st.pop();
				if(node2.depth == max) break;
			}
			int last = node2.depth;
			int middle = last/2;
			Node node3 = new Node();
			Node node4=new Node();;
			Node node5=new Node();;
			int count =0;
			while(true){
				node3 = st.pop();
				if(node3.depth == middle) {
					node4 = node3;
					count++;
				}else if(node3.depth == middle+1){
					node5 = node3;
					count++;
				}
				if(count>=2) break;
			}
			System.out.println(node4.idx+" "+node5.idx);
			adjmatrix[node4.idx][node5.idx] = adjmatrix[node5.idx][node4.idx] = false;
			st.clear();
			Node node6 = new Node();
			max=-1;
			dfs(node1);
			while(true){
				node6 = st.pop();
				if(node6.depth == max) break;
			}
			int middle1 = node6.depth/2; // this calculation of middle is wrong.
			Node node8 = new Node();
			while(true){
				node8 = st.pop();
				if(node8.depth==middle1) break;
			}
			Node node7 = new Node();
			st.clear();
			max = -1;
			dfs(node5);
			while(true){
				node7 = st.pop();
				if(node7.depth == max) break;
			}
			int middle2 = node7.depth/2;
			Node node9 = new Node();
			while(true){
				node9 = st.pop();
				if(node9.depth==middle2) break;
			}
			adjmatrix[node8.idx][node9.idx] = adjmatrix[node9.idx][node8.idx] = true;
			max = -1;
			st.clear();
			dfs(nodesarr[0]);
			Node node10 = new Node();
			while(true){
				node10 = st.pop();
				if(node10.depth == max) break;
			}
			st.clear();
			max= -1;
			dfs(node10);
			System.out.println(max);
			System.out.println(node4.idx+1+" "+node5.idx+1);
			System.out.println(node8.idx+1+" "+node9.idx+1);
		}
		
		
	}
	
	static boolean vis[];
	public static void dfs( Node nd){
		Arrays.fill(vis, false);
		dfs2(nd);
		
	}
	public static void dfs2( Node nd){

		vis[nd.idx] = true;
		st.push(nd);
		if(nd.depth > max) max = nd.depth;
		for (int j = 0; j < vis.length; j++) {
			if(!vis[j] && adjmatrix[nd.idx][j]){
				nodesarr[j].depth = nd.depth+1;
				dfs2(nodesarr[j]);
			}
		}
		
	
	}

}
