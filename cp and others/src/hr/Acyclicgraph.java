package hr;

import java.util.Scanner;

public class Acyclicgraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		boolean[][] mat = new boolean[n][n];
		
		for (int i = 0; i < m; i++) {
			mat[in.nextInt()-1][in.nextInt()-1] = true;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					if(mat[i][j] && mat[j][j2]) mat[i][j2] =true;
				}
			}
		}
		
		int totalC=0;
		for (int i = 0; i < n; i++) {
			int count =0;
			for (int j = 0; j < n; j++) {
				if(mat[i][j]) count++;
			}
			//System.out.println(count);
			count++;
			if(2*count>=n) totalC++;
		}
		System.out.println(totalC);
	}

}
