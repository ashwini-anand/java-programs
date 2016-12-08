package gfg;

import java.util.Scanner;

public class CodegrndSMT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int r = s.nextInt();
		int c = s.nextInt();
		int m = r;
		int n = c;
		int mat[][] = new int[m][n];
		if (r != 0 && c != 0) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					mat[i][j] = s.nextInt();
				}
			}

			boolean startDown = true;
			for (int slice = 0; slice < m + n - 1; slice++) {
				
				if (startDown) {
					int z1 = slice < n ? 0 : slice - n + 1;
					int z2 = slice < m ? 0 : slice - m + 1;
					for (int j = slice - z2; j >= z1; --j) {
						System.out.print(mat[j][slice - j] + " ");
					}
					startDown = false;
				} else {
					int z2 = slice < n ? 0 : slice - n + 1;
					int z1 = slice < m ? 0 : slice - m + 1;
						
					for (int j = slice - z2; j >= z1; --j) {
						System.out.print(mat[slice - j][j] + " ");
					}
					startDown = true;
				}
			}
		}
	}

}
