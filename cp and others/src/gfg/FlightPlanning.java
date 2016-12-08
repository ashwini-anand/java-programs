package gfg;

import java.util.ArrayList;
import java.util.Scanner;

public class FlightPlanning {

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		
		while(t>0){
			t--;
			int n = s.nextInt();
			boolean adjmatrix[][] = new boolean[n][n];
			Node nodesarr[] = new Node[n];
			
			for (int i = 0; i < nodesarr.length; i++) {
				Node node = new Node(i,-1);
				nodesarr[i] = node;
			}
			
			for (int i = 0; i < n-1; i++) {
					int c1 = s.nextInt()-1;
					int c2 = s.nextInt()-1;
					adjmatrix[c1][c2] = adjmatrix[c2][c1] = true;
			}
			
			Node node1 = new Node();
			node1 = bfs(nodesarr,nodesarr[0]);
			Node node2 = new Node();
			node2 = bfs(nodesarr,node1);
			int last = node2.depth;
			
			int middle = last/2;
			//below logic is wrong. o1 , o2 should be n1 and n2 resp. Anyway below logic will not work for odd number of 
			// nodes
			
			int o1depth = middle/2;
			int o2depth = o1depth +1;
			//int o2depth = ((middle + 1) - last)/2 + middle +1;
			Node o1 = new Node();
			Node o2 = new Node();
			ArrayList<Node> tmplo1 = new ArrayList<>();
			ArrayList<Node> tmplo2 = new ArrayList<>();
			for(int i=0; i<n;i++){
				if(nodesarr[i].depth == o1depth){
					tmplo1.add(nodesarr[i]);
				}else if(nodesarr[i].depth == o2depth){
					tmplo2.add(nodesarr[i]);
				}
			}
			
			bfs(nodesarr,node2);
			
			for (int i = 0; i < tmplo1.size(); i++) {
				if(tmplo1.get(i).depth == o1depth){
					o1 = tmplo1.get(i);
					break;
				}
			}
			
			for (int i = 0; i < tmplo2.size(); i++) {
				if(o2depth - tmplo2.get(i).depth == 2 && adjmatrix[o1.idx][tmplo2.get(i).idx]){
					o2 = tmplo2.get(i);
					break;
				}
			}
			
			//make old adjmatrix for o1 and o2 false and for n1 and n2 true and apply bfs again to get diameter
			
		}

	}
	
	public static Node bfs(Node[] nodesarr, Node nd){
		return null;
		
	}

}
