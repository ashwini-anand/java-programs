package hr;

import java.util.Scanner;

public class Bishop {

	public static int ways;
	public static int inf = 99999;
	public static int[][] graph;
	public static int m;

	public static boolean isConsistent(int[] q, int n) {
		for (int i = 0; i < n; i++) {

			if (graph[i][q[i]] != inf && ((q[i] - q[n]) == (n - i))
					&& !(isObstacle(q[n], n, q[i], i, 2))) {
				return false;
			}

			if (graph[i][q[i]] != inf && (q[n] - q[i]) == (n - i)
					&& !(isObstacle(q[n], n, q[i], i, 1))) {
				return false;

			}
		}
		return true;
	}

	public static boolean isObstacle(int qn, int n, int qi, int i, int mode) {
		if (mode == 1) {
			n--;
			qn--;
			while (n > i && qn > qi) {
				if (graph[n][qn] == inf)
					return true;
				n--;
				qn--;
			}
		} else {
			n--;
			qn++;
			while (n > i && qn < qi) {
				if (graph[n][qn] == inf)
					return true;
				n--;
				qn++;
			}
		}

		return false;

	}

	public static void enumerate(int[] q, int n) {
		int N = q.length;
		if (n == N) {
			ways++;
			// printBisophs(q);
		} else {
			for (int i = 0; i < m; i++) {
				if (graph[n][i] != inf) {
					q[n] = i;
					if (isConsistent(q, n))
						enumerate(q, n + 1);
				}	
			}
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		m = s.nextInt();
		graph = new int[n][m];
		s.nextLine();
		for (int i = 0; i < n; i++) {
			String ss = s.nextLine();
			for (int j = 0; j < m; j++) {
				if (ss.charAt(j) == '*') {
					graph[i][j] = inf;
				}
			}
		}
		int[] a = new int[n];
		enumerate(a,0);
		System.out.println(ways);
	}
}
