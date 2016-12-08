package uva.graph;

import java.util.Arrays;
import java.util.Scanner;

public class ForwardingEmails {

	/**
	 * @param args
	 */
	static boolean vis[];
	static int sizeCovered[];
	static int next[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int k =1;
		while(k<=t){
			int n = in.nextInt();
			vis = new boolean[n];
			sizeCovered = new int[n];
			next = new int[n];
			
			for (int i = 0; i < n; i++) {
				int u = in.nextInt();
				int v = in.nextInt();
				next[u-1] = v-1;
			}
			Arrays.fill(sizeCovered, -1);
			int ans =0, bestLen =0;
			
			for (int i = 0; i < n; i++) {
				if(sizeCovered[i] == -1){
					dfs(i);
				}
				if(sizeCovered[i] > bestLen){
					bestLen = sizeCovered[i];
					ans =i;
				}
			}
			ans= ans+1;
			System.out.println("Case "+k+": "+ans);
			k++;
		}
	}
	
	public static int dfs(int i){
		int size =0;
		int v = next[i];
		vis[i] = true;
		if(!vis[v]){
			size = 1+dfs(v);
		}
		vis[i] = false;
		sizeCovered[i] = size;
		return size;
	}

}
