package geeksforgeeks;

class LongestPalindromeSubstring {

	static boolean[][] mat;
	static boolean[][] auxmat;
	static String str;
	static int idx;
	static int maxL = -1;

	public static void main(String[] args) {
		// str = "forgeeksskeegfor";
		str = "agfgbc";
		mat = new boolean[str.length()][str.length()];
		auxmat = new boolean[str.length()][str.length()];
		for (int k = 0; k < mat.length; k++) {
			// Arrays.fill(mat[k], -1);
		}
		lps(0, str.length() - 1);
		// System.out.println(maxL);
		System.out.println("The lnegth of the LPS is "
				+ str.substring(idx, idx + maxL));
	}

	public static boolean lps(int i, int j) {

		if (auxmat[i][j])
			return mat[i][j];
		auxmat[i][j] = true;
		if (i == j) {
			mat[i][j] = true;
			if (maxL < 1) {
				maxL = 1;
				idx = i;
			}
		} else if (i + 1 == j && str.charAt(i) == str.charAt(j)) {
			mat[i][j] = true;
			if (maxL < 2) {
				maxL = 2;
				idx = i;
			}
		} else if (str.charAt(i) == str.charAt(j) && lps(i + 1, j - 1)) {
			mat[i][j] = true;
			if (maxL < j - i + 1) {
				maxL = j - i + 1;
				idx = i;
			}
		}

		else {
			mat[i][j] = false;
			lps(i + 1, j);
			lps(i, j - 1);
		}
		return mat[i][j];

	}

}