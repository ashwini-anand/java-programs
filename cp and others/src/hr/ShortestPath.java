package hr;

import java.util.*;

public class ShortestPath {

	/**
	 * @param args
	 */
	public static int[][] mat;
	public static long[][] dp;
	public static int r1;
	public static int c1;
	public static int r2;
	public static int c2;
	public static long MIN = -99999999999999L;
	public static long MAX = 99999999999999L;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		mat = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		int t = in.nextInt();
		while(t-- > 0){
			r1 = in.nextInt();
			c1 = in.nextInt();
			r2 = in.nextInt();
			c2 = in.nextInt();
			dp = new long[n][m];
			
			for (int i = 0; i < dp.length; i++) {
				Arrays.fill(dp[i], -1);
			}
			
			System.out.println(getResult(r1, c1));
		}
		

	}
	
	public static long getResult(int r, int c){
		int n = mat.length;
		int m = mat[0].length;
		
		if(r<0 || r >= n || c <0 || c >=m){
			return MAX;
		}
		if(r==r2 && c == c2){
			return mat[r2][c2];
		}
		if(dp[r][c] != -1){
			return dp[r][c];
		}
		
		dp[r][c]= mat[r][c] + minValue(getResult(r-1, c), getResult(r+1, c), getResult(r, c-1), getResult(r, c+1));
		//dp[r][c]= mat[r][c] + Math.min(getResult(r+1, c), getResult(r, c+1));
		
		
		return dp[r][c];
		
	}
	
	public static long minValue(long w, long x, long y, long z){
		return Math.min(w, Math.min(x, Math.min(y,z)));
	}

}
