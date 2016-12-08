package tc;

import java.util.*;

public class Marketing {
	static boolean a[][] = new boolean[31][31];
	static boolean oddcycle = false;
	static int n;
	static int color[] = new int[31];
	public static void main(String[] args) {
      String[] compete =  	{"11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27", "11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27", "11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27", "11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27", "11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27", "11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27", "11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27", "11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27", "11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27", "11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27", "11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
      System.out.println(howMany(compete));
	}
	public static long howMany(String[] compete){
         n = compete.length; 
		for (int i = 0; i < compete.length; i++) {
			StringTokenizer s= new StringTokenizer(compete[i]," ");
			while(s.hasMoreElements()){
				int j = Integer.parseInt(s.nextToken());
				a[i][j] = a[j][i] = true;
			}
		}
		for (int i = 0; i < compete.length; i++) {
			color[i] = 0;
		}
		int retVal=0;
		for (int i = 0; i < n; i++) {
			if(color[i] == 0){
				retVal++;
				dfs(i,1);
			}
		}
		//System.out.println(oddcycle);
		if(oddcycle) return -1;
		long res = 1;
		while(retVal-- > 0) res *=2;
		return res;
		
	}
	private static void dfs(int i, int j) {
		if(color[i] != 0){
			if(color[i] != j){
			//	System.out.println(i+" inside odd "+j);
				oddcycle = true;
			}
			return;
		}
		color[i] = j;
		for (int j2 = 0; j2 < n; j2++) {
			if(a[i][j2]){
		//		System.out.println(i+" inside even "+j2);
				dfs(j2,3-j);
			}
		}
		
	}

}
