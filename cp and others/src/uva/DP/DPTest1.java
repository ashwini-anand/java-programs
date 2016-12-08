package uva.DP;

import java.util.Scanner;

public class DPTest1 {

	/**
	 * @param args
	 */
	static int n;
	static int x;
	static int mat[][];
	static boolean sumMat[][][];
	static int res;
	static int maxValue;
	static int rval = 10000;
	static int rowVal = 10000+rval;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		while(t-- >0){
			n= in.nextInt();
			x = in.nextInt();
			//System.out.println(x);
			mat = new int[n][n];
			int maxEle = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					mat[i][j] = in.nextInt();
					//maxEle = Math.max(maxEle, mat[i][j]);
				}
			}
			// maxValue = maxEle * n;
			sumMat = new boolean[rowVal][n][n];
			res = Integer.MAX_VALUE;
			for (int i = 0; i <n; i++) {
				recurse(mat[0][i],i,0);
				recurse(-mat[0][i],i,0);
			}
			
			System.out.print(res+" ");
		}

	}
	
	public static void recurse(int sum,int k,int cnt){
		if(n-1==cnt){
			if(sum>=x && sum<res){
				res = sum;
			}
			return;
		}
//		if(sum+rval == -3){
//			System.out.println(sum+rval);
//			return;
//		}
		if(sum < -10000 || sum > 10000 || sumMat[sum+rval][k][cnt] ) return;
		
		sumMat[sum+rval][k][cnt] = true;
		recurse(sum+mat[cnt+1][k],k,cnt+1);
		recurse(sum-mat[cnt+1][k],k,cnt+1);
		if(k-1 >=0){
			recurse(sum+mat[cnt+1][k-1],k-1,cnt+1);
			recurse(sum-mat[cnt+1][k-1],k-1,cnt+1);
		}
		if(k+1 < n){
			recurse(sum+mat[cnt+1][k+1],k+1,cnt+1);
			recurse(sum-mat[cnt+1][k+1],k+1,cnt+1);
		}
	}

}
