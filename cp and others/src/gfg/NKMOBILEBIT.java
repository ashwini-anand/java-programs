package gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NKMOBILEBIT {

	/**
	 * @param args
	 */
	static int matrix[][];

	static void update(int x, int y, int v) {
		for (int i = x; i < matrix.length; i += (i & -i)) {
			for (int j = y; j < matrix[i].length; j += (j & -j)) {
				matrix[i][j] += v;
			}
		}
	}

	static int read(int x, int y) {
		int sum = 0;

		for (int i = x; i > 0; i -= (i & -i)) {
			for (int j = y; j > 0; j -= (j & -j)) {
				sum += matrix[i][j];
			}
		}

		return sum;

	}

	public static void main(String[] args) {

		MyScanner s = new MyScanner();
		int p = s.nextInt();
		int m = s.nextInt();
		matrix = new int[m + 1][m + 1];
		while (p != 3) {
			p = s.nextInt();
			if (p == 1) {

				int x = s.nextInt();
				int y = s.nextInt();
				int a = s.nextInt();
				update(x + 1, y + 1, a);

			} else if (p == 2) {

				int l = s.nextInt() + 1;
				int b = s.nextInt() + 1;
				int r = s.nextInt() + 1;
				int t = s.nextInt() + 1;
				int sum = 0;

				sum = read(r, t) - read(r, b - 1) - read(l - 1, t)
						+ read(l - 1, b - 1);
				System.out.println(sum);

			} else {
				break;
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
