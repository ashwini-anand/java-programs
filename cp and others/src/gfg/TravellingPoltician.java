package gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TravellingPoltician {

	/**
	 * @param args
	 */

	static ArrayList<Integer>[] group;

	static ArrayList<Integer> results = new ArrayList<>();
	static int n;
	static int k;
	static int res;
	static boolean[][][] vis;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyScanner s = new MyScanner();
		while (true) {
			n = s.nextInt();
			int m = s.nextInt();
			k = s.nextInt();
			if (n == 0 && m == 0 && k == 0)
				break;

			group = (ArrayList<Integer>[]) new ArrayList[n];

			for (int i = 0; i < n; i++) {
				ArrayList<Integer> al = new ArrayList<>();
				group[i] = al;
			}

			for (int i = 0; i < m; i++) {
				int src = s.nextInt();
				int dest = s.nextInt();
				if(src==dest) continue;
				group[src].add(dest);
			}
			int count = 0;
			res = 21;
			vis = new boolean[51][51][22];
			giveResult(count, 0, 0);
			if (res > 20) {
				System.out.println("LOSER");
			} else {
				System.out.println(res);
			}
		}
	}

	static void giveResult(int count, int i, int p) {
		count++;
		if (count > res) {
			return;
		}
		if (i == n - 1 && count >= k) {
			// results.add(count);
			if (count < res) {
				res = count;
			}
			return;
		}

		if (vis[i][p][count])
			return;
		vis[i][p][count] = true;
		for (int j = 0; j < group[i].size(); j++) {
			giveResult(count, group[i].get(j), i);
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
