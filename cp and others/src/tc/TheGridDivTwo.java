package tc;

import java.util.Arrays;
import java.util.LinkedList;

class state{
	int x;
	int y;
	int k;
	
	public state(int x, int y, int k) {
		this.x =x;
		this.y = y;
		this.k =k;
	}
}


public class TheGridDivTwo {

     final static int n=2015;
     static boolean[][] vis = new boolean[n][n];
	 static int[] dx = {1,-1,0,0};
	 static int[] dy = {0,0,-1,1};
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int find(int[] x, int[] y, int k){
		for (int i = 0; i < n; i++) {
			Arrays.fill(vis[i], true);
		}
		
		for (int i = 0; i < y.length; i++) {
			vis[x[i]+1000][y[i]+1000] = false;
		}
		
		LinkedList<state> q = new LinkedList<state>();
		q.add(new state(0,0,0));
		int max =0;
		while(q.isEmpty() == false){
			state s = q.poll();
			if(vis[s.x+1000][s.y+1000] == false) continue;
			vis[s.x+1000][s.y+1000] = false;
			max = Math.max(max, s.x);
			if(s.k < k){
				for (int i = 0; i < dx.length; i++) {
					int x1 = s.x + dx[i];
					int y1 = s.y + dy[i];
					q.add(new state(x1,y1,s.k+1));
				}
			}
			
		}
		
		return max;
		
	}
}
