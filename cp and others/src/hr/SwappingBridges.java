package hr;

import java.util.Arrays;
import java.util.Scanner;

public class SwappingBridges {

	/**
	 * @param args
	 */
	final static int inf = 9999;
	static int[][] graph;
	static boolean visited[];
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t>0){
			t--;
			int n = s.nextInt();
			graph = new int[n][n];
			visited = new boolean[n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(graph[i], inf);
			}
			for (int i = 0; i < n; i++) {
				int in = s.nextInt();
				graph[i][in-1]=1;
			}
			dfs(0);
		}
		
	}

	public static void dfs(int v){
		int count =0;
		int swap = -1;
		for (int i = v; count < visited.length; i=(i+1)%visited.length) {
			count++;
			if(!visited[i]){
				swap++;
				dfsutil(i);
			}
		}
		System.out.println((swap));
	}
	
    public static void dfsutil(int i){
		visited[i] = true;
		//System.out.println(i+" ");
		
		for (int j = 0; j < visited.length; j++) {
			if(!visited[j] && graph[i][j]!=inf){
				
				//System.out.println(i+" "+j+" "+graph[i][j]);
				//System.out.println(j+" ");
				dfsutil(j);
			}
		}
	}
}
