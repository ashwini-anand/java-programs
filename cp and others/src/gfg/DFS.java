package gfg;

public class DFS {

	/**
	 * @param args
	 */
	final static int inf = 9999;
	static int[][] graph={
			{inf,1,1,inf},
			{inf,inf,1,inf},
			{1,inf,inf,1},
			{inf,inf,inf,1}
	};
	static boolean visited[]=new boolean[4];
	
	public static void main(String[] args) {

		dfs(2);
		
	}

	public static void dfs(int v){
		int count =0;
		for (int i = v; count < visited.length; i=(i+1)%visited.length) {
			count++;
			if(!visited[i]){
				dfsutil(i);
			}
		}
	}
	
    public static void dfsutil(int i){
		visited[i] = true;
		System.out.println(i+" ");
		
		for (int j = 0; j < visited.length; j++) {
			if(!visited[j] && graph[i][j]!=inf){
				
				//System.out.println(i+" "+j+" "+graph[i][j]);
				//System.out.println(j+" ");
				dfsutil(j);
			}
		}
	}
}
