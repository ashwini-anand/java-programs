package uva.DP;

import java.util.*;

public class CollectingBeepers {

	/**
	 * @param args
	 */
	static class Beepers {
		int x;
		int y;

		public Beepers() {
			// TODO Auto-generated constructor stub
		}

		public Beepers(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Beepers other = (Beepers) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}

	static int[][] mat;
	static int wsizeX, wsizeY;
	static int kposX, kposY;
	static HashSet<Beepers> hs;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		while (t > 0) {
			t--;
			wsizeX = in.nextInt();
			wsizeY = in.nextInt();
			kposX = in.nextInt();
			kposY = in.nextInt();
			int n = in.nextInt();
			hs = new HashSet<>();
			mat = new int[wsizeX + 1][wsizeY + 1];
			for (int i = 0; i < mat.length; i++) {
				Arrays.fill(mat[i], Integer.MAX_VALUE);
			}
			for (int i = 0; i < n; i++) {
				hs.add(new Beepers(in.nextInt(), in.nextInt()));
			}
			int ans = recurse(n, kposX, kposY);
			System.out.println(ans);
		}

	}

	public static int recurse(int n, int i, int j) {
		if (i < 1 || i > wsizeX || j < 1 || j > wsizeY) {
			return Integer.MAX_VALUE;
		}
		if (mat[i][j] != Integer.MAX_VALUE) {
			return mat[i][j];
		}
		if (n == 0 && i == kposX && j == kposY) {
			return 0;
		}
		if (n != 0 && hs.contains(new Beepers(i, j))) {
			hs.remove(new Beepers(i, j));
			n--;
		}
		int min = Math.min(recurse(n, i, j + 1), recurse(n, i, j - 1));
		min = Math.min(min, recurse(n, i - 1, j));
		min = Math.min(min, recurse(n, i + 1, j));
		min = min == Integer.MAX_VALUE ? min : min + 1;
		mat[i][j] = min;
		// mat[i][j] =
		// Math.min(recurse(n,i,j+1),recurse(n,i,j-1),recurse(n,i-1,j),recurse(n,i+1,j));
		return mat[i][j];
	}
}
