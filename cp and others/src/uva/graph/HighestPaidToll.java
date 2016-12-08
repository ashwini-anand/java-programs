package uva.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class HighestPaidToll {

	/**
	 * @param args
	 */
	static class Node{
		int idx;
		ArrayList<Neigh> nghs = new ArrayList<>();
	}
	
	static class Neigh{
		int idx;
		int wt;
		boolean done=false;
	}
	
	static int res;
	static int p;
	static int m;
	static int n;
	static int t;
	static Neigh path[];
	static Node nodes[];
	static boolean vis[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner  in =  new Scanner(System.in);
		int t1 = in.nextInt();
		
		while(t1-- > 0){
			n = in.nextInt();
			m = in.nextInt();
			int s = in.nextInt()-1;
			t = in.nextInt()-1;
			p= in.nextInt();
			path = new Neigh[n];
			nodes = new Node[n];
			vis = new boolean[n];
			res = -1;
			for (int i = 0; i < n; i++) {
				nodes[i] = new Node();
				nodes[i].idx = i;
			}
			
			for (int i = 0; i < m; i++) {
				int u = in.nextInt();
				int v = in.nextInt();
				int c = in.nextInt();
				Neigh nh = new Neigh();
				nh.idx = v-1;
				nh.wt  = c;
				nodes[u-1].nghs.add(nh);
			}
			for (int i = 0; i < nodes[s].nghs.size(); i++) {
				//System.out.println("oooo");
				vis[s] = true;
				dfs(nodes[s].nghs.get(i),nodes[s].nghs.get(i).wt,0);
			}
			System.out.println(res);
			
		}

	}
	
	public static void dfs(Neigh u, int sum, int pathIndex){
		vis[u.idx] = true;
		path[pathIndex] = u;
		pathIndex++;
		//System.out.println("abc");
		if(u.idx == t && sum <= p){
			for (int i = pathIndex-1; i >=0; i--) {
				//System.out.println("abc2");
				if(path[i].done == true) break;
				if(path[i].wt > res) {
					res = path[i].wt;
					path[i].done = true;
				}
			}
		}else{
			//System.out.println("abc1 "+u.idx);
			Node nd = nodes[u.idx];
			for (int i = 0; i < nd.nghs.size(); i++) {
				Neigh ng = nd.nghs.get(i);
				if(vis[ng.idx] != true){
					dfs(ng,sum+ng.wt,pathIndex);
				}
			}
			
		}
		u.done = false;
		vis[u.idx] = false;
		
	}

}
