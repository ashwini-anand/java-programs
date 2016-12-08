//Gives wrong answer in UVa OJ. But passing all the test cases that I could think of and could get from Internet.

package uva.DP;

import java.util.*;

public class Trouble13dot {

	static class PriceFavour implements Comparable<PriceFavour> {
		int p;
		int f;

		public int compareTo(PriceFavour o) {
			return this.p - o.p;
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int m;
			int t = in.nextInt();
			int n = in.nextInt();
			PriceFavour[] pfarr = new PriceFavour[n];
			for (int i = 0; i < n; i++) {
				int p = in.nextInt();
				int f = in.nextInt();
				PriceFavour pf = new PriceFavour();
				pf.p = p;
				pf.f = f;
				pfarr[i] = pf;
			}
			m = t;
			if (m + 200 > 2000) {
				m = m + 200;
			}
			if(t==0 || n==0){
				System.out.println(0);
				continue;
			}
			Arrays.sort(pfarr);
			int[][] mat = new int[n][m + 1];
			
			for (int i = 0; i < mat.length; i++) {
				Arrays.fill(mat[i], Integer.MIN_VALUE);
			}
			
			if (pfarr[0].p <= m) {
				mat[0][pfarr[0].p] = pfarr[0].f;
			}

			for (int i = 1; i < n; i++) {
				for (int j = 0; j <= m; j++) {
					mat[i][j] = mat[i - 1][j];
					if (j - pfarr[i].p >= 0) {
						mat[i][j] = Math.max(mat[i - 1][j], pfarr[i].f
								+ mat[i - 1][j - pfarr[i].p]);
					}
				}
			}
			int max = mat[n - 1][0];
			if (t < 2000 && t + 200 > 2000) {
				for (int i = 1; i <= m; i++) {
					// System.out.print(mat[n-1][i]+" ");
					if (mat[n - 1][i] > max && i != 2000) {
						max = mat[n - 1][i];
					}
				}
			} else {
				for (int i = 1; i <= m; i++) {
					// System.out.print(mat[n-1][i]+" ");
					if (mat[n - 1][i] > max) {
						max = mat[n - 1][i];
					}
				}
			}
            max = max < 0 ? 0:max;
			System.out.println(max);
		}

	}
}

//Test cases
//
//1800 3
//1950 1
//2000 5
//101 1
//
//1801 3
//2000 5
//1955 1
//101 1
//
//1890 3
//1955 1
//2000 5
//101 1
// 
//5000 4
//1000 2
//1000 2
//1000 3
//3200 5
//
//0 0
//
//1 1
//1 1
//
//5 5
//1 9
//2 9
//3 9
//1 9
//2 9
//
//1382 1
//1791 1