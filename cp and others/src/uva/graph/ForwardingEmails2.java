package uva.graph;

import java.util.Arrays;
import java.util.Scanner;

public class ForwardingEmails2 {

	/**
	 * @param args
	 */
	static boolean vis[];
	static int sizeCovered[];
	static int next[];
	static int iter;
	static int cycle[];
	static int keepIter[];
	static boolean isCycle=false;
	static int cycleEle = -1;
	
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
			cycle = new int[n];
			keepIter = new int[n];
			
			for (int i = 0; i < n; i++) {
				int u = in.nextInt();
				int v = in.nextInt();
				next[u-1] = v-1;
			}
			Arrays.fill(sizeCovered, -1);
			for (int i = 0; i <n; i++) {
				cycle[i] = i;
			}
			int ans =0, bestLen =0;
			iter =0;
			for (int i = 0; i < n; i++) {
				if(!vis[i]){
					isCycle = false;
					cycleEle = -1;
					iter++;
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
		keepIter[i] = iter;
		int v = next[i];
		vis[i] = true;
		if(!vis[v]){
			size = 1+dfs(v);
		}else{
			if(keepIter[v] == iter){
				cycle[i] = v;
				isCycle = true;
				cycleEle = v;
			}else{
				size = 1 + sizeCovered[cycle[v]];
			}
		}
		//vis[i] = false;
		if(isCycle && cycleEle != i){
			cycle[i] = cycleEle;
		}else{
			isCycle = false;
		}
		sizeCovered[i] = size;
		return size;
	}

}
