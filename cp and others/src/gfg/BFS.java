package gfg;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class nodes{
	int index;
	List<Integer> adj = new LinkedList<Integer>();
}

class graph{
	int numOfnodes;
	nodes[] nodes;
	
	graph(int n){
		numOfnodes = n;
		nodes = new nodes[n];
	}
}

public class BFS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Enter the num of nodes");
		Scanner s = new Scanner(System.in);
		int numofnodes = s.nextInt();
		
		graph g = new graph(numofnodes);
	//	g.numOfnodes = numofnodes;
		//g.nodes = new nodes[numofnodes];
		
		for (int i = 0; i < g.numOfnodes; i++) {
			System.out.println("Enter 999 to enter adj nodes of next node ");
			System.out.println("Enter adj nodes to "+i);
			g.nodes[i] = new nodes();
			while(true){
				int adjn = s.nextInt();
				if(adjn == 999) break;
				g.nodes[i].adj.add(adjn);
				
			}
		}
		System.out.println("BFS traversal is: ");
		bfs(g,2);
		
	}
	public static void bfs(graph g, int n){
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[g.numOfnodes];
		
		queue.add(n);
		visited[n]=true;
		
		while(queue.isEmpty()==false){
			int s = queue.poll();
			System.out.print(s+" ");
			for (int i = 0; i < g.nodes[s].adj.size(); i++) {
				if(!visited[g.nodes[s].adj.get(i)]){
					visited[g.nodes[s].adj.get(i)]=true;
				    queue.add(g.nodes[s].adj.get(i));
			 }
			}
		}
	}

}
