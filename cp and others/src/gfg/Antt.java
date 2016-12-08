//Passing for sample input. TLE in spoj
//Using the concept of Union-find and Line Intersection.
//GrpId stores the parent of Union -find method.  O(n^2) algo.

package gfg;

import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Antt {

	/**
	 * @param args
	 */
	static class Line {
		long x1;
		long y1;
		long x2;
		long y2;
		long grpId;

		public Line() {
			// TODO Auto-generated constructor stub
		}

		public Line(long x1, long y1, long x2, long y2, long grpid) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.grpId = grpid;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyScanner s = new MyScanner();
		int t = s.nextInt();
		while (t > 0) {
			t--;
			int n = s.nextInt();
			int m = s.nextInt();
			// boolean mat[][] = new boolean[n][n];

			Line[] larr = new Line[n];

			for (int i = 0; i < n; i++) {
				long x1 = s.nextInt();
				long y1 = s.nextInt();
				long x2 = s.nextInt();
				long y2 = s.nextInt();
				Line l = new Line(x1, y1, x2, y2, i);
				larr[i] = l;
			}
			for (int i = 0; i < larr.length; i++) {
				for (int j = 0; j <= i; j++) {
					Line l1 = larr[i];
					Line l2 = larr[j];
					// if(j==i){
					// mat[i][j] = true;
					// continue;
					// }
					if (Line2D.linesIntersect(l1.x1, l1.y1, l1.x2, l1.y2,
							l2.x1, l2.y1, l2.x2, l2.y2)) {
						if (l1.grpId < l2.grpId) {
							l2.grpId = l1.grpId;
						} else {
							l1.grpId = l2.grpId;
						}
					}
				}
			}
			// for (int i = 0; i < n; i++) {
			// for (int k = 0; k < n; k++) {
			// for (int j = 0; j < n; j++) {
			// if(mat[i][k]&&mat[k][j]){
			// mat[i][j]=true;
			// }
			// }
			// }
			// }
			for (int i = 0; i < m; i++) {
				int x = s.nextInt() - 1;
				int y = s.nextInt() - 1;
				if (larr[x].grpId == larr[y].grpId) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}

		}
	}

	static class MyScanner {
		static BufferedReader br;
		static StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}
}
