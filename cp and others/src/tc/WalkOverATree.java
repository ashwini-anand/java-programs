package tc;

public class WalkOverATree {

	/**
	 * @param args
	 */
	
	static int max = -1;
	static boolean graph[][];
	static int steps;
	static int k =0;
	
	public static void main(String[] args) {
		int[] parent = {0,0};
		
		System.out.println(maxNodesVisited(parent, 2));

	}

	public static int maxNodesVisited(int[] parent, int L){
		int n= parent.length+1;
		graph =  new boolean[n][n];
		steps = L;
		
		for (int i = 0; i < parent.length; i++) {
			graph[i+1][parent[i]] = graph[parent[i]][i+1] = true;
		}
		
		boolean[] visited = new boolean[n];
		dfs(0,visited);
		return max;
		
	}
	
	public static void dfs(int v, boolean[] visited){
		int count =0;
		for (int i = v; count < visited.length; i=(i+1)%visited.length) {
			count++;
			if(!visited[i]){
				dfsutil(i,visited);
			}
		}
	}
	
    public static void dfsutil(int i,boolean[] visited){
		visited[i] = true;
		//System.out.println(i+" ");
		System.out.println(k);
		if(k==steps){
			int c =0;
			for (int j = 0; j < visited.length; j++) {
				if(visited[j]) c++;
			}
			if(c>max) max = c; 
		}
		
		k++;
		for (int j = 0; j < visited.length; j++) {
			if(!visited[j] && graph[i][j]){
				
				//System.out.println(i+" "+j+" "+graph[i][j]);
				//System.out.println(j+" ");
				dfsutil(j,visited);
			}
		}
		
		if(k==steps){
			int c =0;
			for (int j = 0; j < visited.length; j++) {
				if(visited[j]) c++;
			}
			if(c>max) max = c; 
		}
		k++;
	}
}
