package gfg;

import java.util.Scanner;

public class MemoizedMatrixChainMulti {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of matrices");
		int n = sc.nextInt();
		int[] p = new int[n+1];
		System.out.println("Enter the size of matrices");
		for (int i = 0; i < p.length; i++) {
			p[i] = sc.nextInt();
		}
		int m[][] = new int[n][n];
		int s[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				m[i][j] = Integer.MAX_VALUE;
			}
		}
		System.out.println(lookUpChain(m, p, 0, n-1,s));
		printOptimal(s, 0, n-1);
	}
	
	public static int lookUpChain(int[][] m, int[] p,int i,int j, int[][] s){
		if(m[i][j] < Integer.MAX_VALUE) return m[i][j];
		if(i==j) m[i][j] = 0;
		else{
			for (int k = i; k <= j-1; k++) {
				int q = lookUpChain(m, p, i, k,s) + lookUpChain(m, p, k+1, j,s) + p[i]*p[k+1]*p[j+1];
				if(q<m[i][j]) {
					m[i][j] = q;
					s[i][j] = k;
				}
			}
		}
		return m[i][j];
		
	}
	
	public static void printOptimal(int[][] s , int i, int j){
		if(i==j) System.out.print(i+" ");
		else{
			System.out.print("( ");
			printOptimal(s, i, s[i][j]);
			printOptimal(s, s[i][j]+1, j);
			System.out.print(" )");
		}
	}

}
