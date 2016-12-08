package gfg;

import java.util.Arrays;

class Edge{
	int src;
	int dest;
}

class Graph{
	int v,e;
	Edge[] edges;
	
	Graph(int v,int e){
		this.v=v;
		this.e=e;
		edges = new Edge[e];
	}
}

public class UnionFind {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Graph graph = new Graph(3, 3);
		
		graph.edges[0] = new Edge();
		graph.edges[0].src = 0;
	    graph.edges[0].dest = 1;
	 
	    graph.edges[1] = new Edge();
	    graph.edges[1].src = 1;
	    graph.edges[1].dest = 2;
	 
	    graph.edges[2] = new Edge();
//	    graph.edges[2].src = 0;
//	    graph.edges[2].dest = 2;
	    
	    if(isCyclic(graph)) System.out.println("Has cycle");
	    else System.out.println("No cycle");
	}
	
	public static int find(int[] parent, int i){
		if(parent[i]==-1) return i;
		return find(parent,parent[i]);
	}
	
	public static void union(int[] parent,int x, int y){
		int xp = find(parent,x);
		int yp = find(parent,y);
		
		parent[xp] = yp;
	}
	
	public static boolean isCyclic(Graph g){
		int[] parent = new int[g.v];
		Arrays.fill(parent, -1);
		
		for (int i = 0; i < g.e; i++) {
			System.out.println(g.edges[i].src+" "+g.edges[i].dest);
			if(!((g.edges[i].src == 0) && (g.edges[i].dest ==0))){  //not a perfect way as Node 0 can have self loop and that is a cycle
			int x = find(parent,g.edges[i].src);
			int y = find(parent,g.edges[i].dest);
			
			System.out.println(i+" "+x+" "+y);
			if(x==y) return true;
			
			union(parent,x,y);
			}
		}
		return false;
		
	}

}
