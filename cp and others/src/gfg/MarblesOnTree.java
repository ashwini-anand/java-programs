//working for all test case given in sample.Also working for all the random test case I could generate.
// Input file is attached.
////-------------Below code looks for each node ,starting from leaf. If a node has more than 0 marbles, then
//processing is skipped. If node has 0 marble then we look for nearest node which has more then 1 marble(done using modified bfs).
//If there are more then one such nearest node then select the one with maximum. 
//More description of program is below along with code.


package gfg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MarblesOnTree {

	/**
	 * @param args
	 */
	static class Node{
		int idx;
		int marbles;
		int bfsdepth =0;
		List<Integer> adjList = new ArrayList<>();
		public Node(){
			
		}
		public Node(int idx, int marbles) {
			super();
			this.idx = idx;
			this.marbles = marbles;
		}
		
	}
	
	static int count; // count is number of transferred required
	static Node nodesarr[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		
		while(true){
			int n = s.nextInt();
			if(n==0) break;
			count =0;
			nodesarr = new Node[n];
			//-------------Taking input starts----------------
			
			for (int i = 0; i < nodesarr.length; i++) {
				nodesarr[i] = new Node();
			}
			
			for (int i = 0; i < n; i++) {
				int v = s.nextInt()-1;
				int marbles = s.nextInt();
				nodesarr[i].idx = v;
				nodesarr[i].marbles = marbles;
				int d = s.nextInt();
				for (int j = 0; j < d; j++) {
					int k =s.nextInt()-1;
					nodesarr[i].adjList.add(k);
					nodesarr[k].adjList.add(i);
					
				}
			}
			
			//-------------Taking input finishes----------------------------------------------------------
			//-------------Below code looks for each node ,starting from leaf. If a node has more than 0 marbles, then
			//processing is skipped. If node has 0 marble then we look for nearest node which has more then 1 marble(done using modified bfs).
			//If there are more then one such nearest node then select the one with maximum. 
			for (int i = nodesarr.length-1; i >=0; i--) {
				if(nodesarr[i].marbles >0) continue;  //skip this node as it has enough marble
				max =0;
				maxIdx =-1;
				bfs(nodesarr[i]); // if #marbles at i is 0 then do bfs to find a target node from which we will extract marble
				nodesarr[maxIdx].marbles = nodesarr[maxIdx].marbles -1; // subtract marble from target
				nodesarr[i].marbles = nodesarr[i].marbles+1; //add marble to target
				count += nodesarr[maxIdx].bfsdepth; // number of transfer is increased by distance of target from ith node
			}
			
			System.out.println(count);
		}
	}
	
	static int max;
	static int maxIdx; // stores the index of target node
	
	public static void bfs(Node nd){

		LinkedList<Node> queue = new LinkedList<Node>();
		boolean[] visited = new boolean[nodesarr.length];
		
		queue.add(nd);
		nd.bfsdepth =0;
		visited[nd.idx]=true;
		boolean flag = false;
		while(queue.isEmpty()==false){
			Node nd1 = queue.poll();
			for (int i = 0; i < nd1.adjList.size(); i++) {
				if(nodesarr[nd1.adjList.get(i)].marbles > 1){
					flag = true;
					break;
				}
			}
			for (int i = 0; i < nd1.adjList.size(); i++) {
				if(!visited[nd1.adjList.get(i)]){
					visited[nd1.adjList.get(i)]=true;
					nodesarr[nd1.adjList.get(i)].bfsdepth = nd1.bfsdepth+1;
					if(nodesarr[nd1.adjList.get(i)].marbles > max){
						max = nodesarr[nd1.adjList.get(i)].marbles;
						maxIdx = nd1.adjList.get(i);
					}
					if(!flag){
						queue.add(nodesarr[nd1.adjList.get(i)]);
					}
			 }
			}
		}
	
	}

}
