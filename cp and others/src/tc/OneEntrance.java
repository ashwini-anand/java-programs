package tc;

import java.util.Arrays;

public class OneEntrance {
	public static void main(String[] args) {
		int[] a={0, 1, 2};
		int[] b= {1, 2, 3};
        int s = 2;
        System.out.println(count(a, b, s));
	}
	
	public static int solve(boolean[][] adj, int[] count, int s){
		int ret = 0;
		if(count[s] == 0) return 1;
		
		for (int i = 0; i < count.length; i++) {
			if(i==s) continue;
			if(count[i] == 1){
				for (int j = 0; j < count.length; j++) {
					if(!adj[i][j]) continue;
					adj[i][j] = false;
					adj[j][i] = false;
					count[i]--;
					count[j]--;
					//System.out.print(ret+"  ");
					ret+=solve(adj, count, s);
					adj[i][j] = true;
					adj[j][i] = true;
					count[i]++;
					count[j]++;
					
				}
			}
		}
		
		return ret;
		
	}
	
	public static int count(int[] a, int[] b, int s){
		int n = a.length+1;
		if(n==1) return 1;
		boolean adj[][]= new boolean[n][n];
		int cunt[] = new int[n];
		
		Arrays.fill(cunt, 0);
		
		for (int i = 0; i < n-1; i++) {
			adj[a[i]][b[i]] = true;
			adj[b[i]][a[i]] = true;
			cunt[a[i]]++;
			cunt[b[i]]++;
		}
		return solve(adj,cunt,s);
		
	}

}
