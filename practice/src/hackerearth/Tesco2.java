package hackerearth;

import java.util.*;

public class Tesco2 {

	/**
	 * @param args
	 */
	static int[] depth;
	static int parent[][];
	static int lon = 20;
	static Node[] ktree;
	static class Node{
		HashSet<Integer> alist = new HashSet<Integer>(10000,0.9f);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		depth = new int[101072];
		//lon = log(n,2);
		parent = new int[lon][101072];
		ktree = new Node[101072];
		for (int i = 0; i < n; i++) {
			ktree[i] = new Node();
		}
		for(int i=0; i<n-1; i++){
			int p = in.nextInt()-1;
			ktree[p].alist.add(i+1);
		}
		Arrays.fill(depth, -1);
		for(int i=0; i<parent.length; i++){
			Arrays.fill(parent[i], -1);
		}
		
		dfs(0,-1,0);
		
		for(int i=1; i<lon; i++){
			for(int j=0; j<n;j++){
				if(parent[i-1][j] != -1){
					parent[i][j] = parent[i-1][parent[i-1][j]];
				}
			}
		}
		
		while(q >0){
			q--;
			int k = in.nextInt();
			int[] arr = new int[k];
			for(int i=0; i<k; i++){
				arr[i] = in.nextInt()-1;
			}
			if(k==1){
				System.out.println(arr[0]+1);
				continue;
			}
			int res = findLca(arr[0],arr[1]);
			for (int i = 2; i < arr.length; i++) {
				res = findLca(res, arr[i]);
				if(res==0)break;
			}
			System.out.println(res+1);
		}

	}
	private static int findLca(int u, int v) {
		if(depth[u] < depth[v]){
			int tmp = u;
			u=v;
			v=tmp;
		}
		for(int i=lon-1; i>=0; i--){
			if(depth[u] - (1<<i) >= depth[v]){
				u = parent[i][u];
			}
		}
		
		if(u==v){
			//System.out.println("gere");
			return u;
		}
		
		for(int i=lon; i>=0; i--){
			if( parent[i][u] != -1 && parent[i][u] != parent[i][v] ){
				u = parent[i][u];
				v = parent[i][v];
			}
		}
		return parent[0][u];
	}
	private static void dfs(int idx, int pa, int d) {
		depth[idx] = d;
		parent[0][idx] = pa;
		
		for (Integer jj: ktree[idx].alist) {
			//int jj = ktree[idx].get(i);
			if(depth[jj]==-1){
				dfs(jj,idx,d+1);
			}
		}
		
	}
	
	static int log(int x, int base){
		int res = (int) Math.ceil((Math.log(x) / Math.log(base)));
		return res;
	}

}
