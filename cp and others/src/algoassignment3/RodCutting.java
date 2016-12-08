package algoassignment3;

import java.util.Scanner;

public class RodCutting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		while(t>0){
			t--;
			int l = s.nextInt();
			int n = s.nextInt();
			
			int[] a  = new int[n+2];
			a[0] = 0;
			a[n+1] = l;
			for (int i = 1; i < n+1; i++) {
				a[i] = s.nextInt();
			}
			
			int[][] cut = new int[n+2][n+2];
			int[][] path = new int[n+2][n+2];
			
			for (int i = 1; i < n+2; i++) {
				cut[i-1][i] = 0;
//				for (int j = 1; j < n+2; j++) {
//					if(i+1 == j)
//					cut[i][j] = 0;
//					
//				}
			}
			int idx = a.length-1;
			int diff = 2;
			int q = 0;
			for (int k = 0; k < idx; k++) {
				int j = diff;
				for (int i = 0; i < idx && j < idx+1; i++,j++) {
					//System.out.println(i+","+j);
					cut[i][j] = Integer.MAX_VALUE; 
					for (int k1=i+1; k1<=j-1; k1++)
		            {
		                q = cut[i][k1] + cut[k1][j] + a[j]-a[i];
		                if (q < cut[i][j])
		                    cut[i][j] = q;
		                    path[i][j] = k1;
		            }
				}
				diff++;
			}
			
			for (int i = 0; i < cut.length; i++) {
				for (int j = 0; j < cut.length; j++) {
					System.out.print(path[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println(cut[0][n+1]);
			
		}
	}

}
