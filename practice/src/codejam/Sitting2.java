package codejam;

import java.util.*;
import java.io.*;

class Sitting2 {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	static int r;
	static int c;
	static int dp[][][];
	static int mat[][];

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(
				new FileOutputStream(
						"/home/ashwini/Desktop/to be deleted/codejam test cases/output.txt"));
		System.setOut(out);
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int test = 0;
		while (t-- > 0) {
			test++;
			r = in.nextInt();
			c = in.nextInt();
			dp = new int[r][c][2];
			mat = new int[r][c];
			for (int i = 0; i < r; i++) {
				for(int j=0; j<c; j++){
					dp[i][j][0] = -1;
					dp[i][j][1] = -1;
				}
			}
			int res1 = getCount(0, 1, 0);
			mat[0][0] = 1;
			int res2 = 1 + getCount(0, 1, 1);
			//System.out.println(res1+" "+res2);
			int res = Math.max(res1, res2);
			System.out.println("Case #" + test + ": " + res);
		}

	}

	static int getCount(int i, int j, int k) {
		// TODO Auto-generated method stub
		if (i == r - 1 && j == c) {
			return 0;
		}

		if (j == c) {
			i = i + 1;
			j = 0;
		}

		int res = -1;
		if(dp[i][j][0] != -1){
			res = dp[i][j][0];
		}else{
			res = getCount(i, j + 1, k);
			dp[i][j][0] = res;
		}
		boolean flag = true;
		if (!isTopBSafe(i, j) || !isLeftRSafe(i, j)) {
			flag = false;
		}
		if (flag) {
			if (!isNeihgboursSafe(i, j)) {
				flag = false;
			}
		}
		if (flag) {
			mat[i][j] = 1;
			int rest = -1;
			if(dp[i][j][1] != -1){
				rest = dp[i][j][1];
			}else{
				rest = 1 + getCount(i, j + 1, k + 1);
				dp[i][j][1] = rest;
			}
			res = Math.max(res, rest);
//			System.out.println(i+" "+j+" "+k+" "+flag+" "+res);
//			printMatrix(mat);
			//mat[i][j] = 0;
		}
		//dp[i][j] = res;
		return res;
	}

	static boolean isNeihgboursSafe(int i, int j) {
		mat[i][j] =1;
		if(isValid(i-1,j)&&mat[i-1][j]==1){
			if(!isTopBSafe(i-1, j)){
				mat[i][j] =0;
				return false;
			}
		}
		if(isValid(i,j-1)&&mat[i][j-1]==1){
			if(!isLeftRSafe(i, j-1)){
				mat[i][j] =0;
				return false;
			}
		}
		mat[i][j] =0;
		return true;
	}

	static boolean isLeftRSafe(int i, int j) {
		if (isValid(i, j-1) && isValid(i, j+1) && mat[i][j-1] == 1
				&& mat[i][j+1] == 1) {
			return false;
		}
		return true;
	}

	static boolean isTopBSafe(int i, int j) {
		if (isValid(i - 1, j) && isValid(i + 1, j) && mat[i - 1][j] == 1
				&& mat[i + 1][j] == 1) {
			return false;
		}
		return true;
	}

	static boolean isValid(int i, int j) {
		if(i <0 || i >=r || j <0 || j >=c){
			return false;
		}
		return true;
	}

	static void printMatrix(int[][] matrix){
		for(int i=0 ; i <matrix.length; i++){
			for(int j=0; j< matrix[i].length;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}
}
