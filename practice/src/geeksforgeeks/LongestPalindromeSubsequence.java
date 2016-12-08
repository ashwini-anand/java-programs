package geeksforgeeks;

import java.util.*;

class LongestPalindromeSubsequence {

	static int[][] mat;
	static String str;

	public static void main(String[] args) {
		str = "GEEKS FOR GEEKS";
		mat = new int[str.length()][str.length()];
		for (int k = 0; k < mat.length; k++) {
			Arrays.fill(mat[k], -1);
		}
		System.out.println("The lnegth of the LPS is "
				+ lps(0, str.length() - 1));
	}

	public static int lps(int i, int j) {

		if (i == j)
			return 1;
		if (i + 1 == j && str.charAt(i) == str.charAt(j))
			return 2;
		if (mat[i][j] != -1)
			return mat[i][j];
		if (str.charAt(i) == str.charAt(j)) {
			mat[i][j] = 2 + lps(i + 1, j - 1);
			return mat[i][j];
		}

		else {
			mat[i][j] = Math.max(lps(i, j - 1), lps(i + 1, j));
			return mat[i][j];
		}

	}

}