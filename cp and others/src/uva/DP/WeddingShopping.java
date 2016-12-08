package uva.DP;

import java.util.*;

public class WeddingShopping {

	/**
	 * @param args
	 */
	static ArrayList<Integer>[] garments;
	static boolean[][] mat;
	static int[][] aux;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t > 0) {
			t--;
			int m = in.nextInt();
			int c = in.nextInt();
			garments = (ArrayList<Integer>[]) new ArrayList[c];
			mat = new boolean[m + 1][c];
			aux = new int[m + 1][c];
			if (c == 0) {
				System.out.println(0);
				continue;
			}
			if (m == 0) {
				System.out.println("no solution");
				continue;
			}
			for (int i = 0; i < c; i++) {
				int k = in.nextInt();
				ArrayList<Integer> al = new ArrayList<>();
				for (int j = 0; j < k; j++) {
					al.add(in.nextInt());
				}
				garments[i] = al;
			}

			boolean flag = false;
			for (int i = m; i >= 0; i--) {
				flag = false;
				for (int j = 0; j < garments[c - 1].size(); j++) {
					boolean temp = recurse(m - garments[c - 1].get(j), c - 1);
					if (temp) {
						flag = true;
						mat[i][c - 1] = temp;
						break;
					}
				}
				if (flag == true) {
					System.out.println(i);
					break;
				} else {
					mat[i][c - 1] = false;
					aux[i][c - 1] = 1;
				}
			}
			if (flag == false) {
				System.out.println("no solution11");
			}
		}

	}

	public static boolean recurse(int sum, int n) {
		//System.out.println(sum+" "+n);
		if(sum<0) return false;
		if(n==0) return true;
//		if (sum == 0)
//			return true;
//		if (sum < 0)
//			return false;
//		if (n <= 0)
//			return false;
		if (aux[sum][n - 1] == 1) {
			return mat[sum][n - 1];
		}
		for (int i = 0; i < garments[n - 1].size(); i++) {
			boolean temp = recurse(sum - garments[n - 1].get(i), n - 1);
			if (temp) {
				mat[sum][n - 1] = temp;
				return temp;
			}
		}
		return false;

	}
}
