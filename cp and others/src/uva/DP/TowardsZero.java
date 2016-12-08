package uva.DP;

import java.util.*;

public class TowardsZero {

	static boolean[][][] mat;
	static int ans;
	static int n;
	static int m;
	static ArrayList<Integer>[] rows;
	static int precision = 3000;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			n = in.nextInt();
			if (n == 0) {
				break;
			}
			m = 2 * n - 1;
			rows = (ArrayList<Integer>[]) new ArrayList[m];
			int k = 0;
			int k1 = 0;
			for (int i = 0; i < m; i++) {
				k1++;
				ArrayList<Integer> al = new ArrayList<>();
				if (k1 <= n) {
					k++;
					for (int j = 0; j < k; j++) {
						al.add(in.nextInt());
					}
				} else {
					k--;
					for (int j = 0; j < k; j++) {
						al.add(in.nextInt());
					}
				}
				rows[i] = al;
			}
			mat = new boolean[31][61][3000+precision];
			ans = 52;
			recurse(rows[m - 1].get(0), 0, m - 1);
			System.out.println(Math.abs(ans));
		}
	}

	public static void recurse(int sum, int i, int n1) {
		if (n1 == 0) {
			//System.out.println(sum);
			if (Math.abs(sum) < Math.abs(ans)) {
				//ans = Math.abs(sum);
				ans = sum;
			}
			return;
		}
		if (mat[i][n1][sum+precision])
			return;
		// for(int i=0;i<rows[n1-1].size();i++){
		mat[i][n1][sum+precision] = true;
		if (n1 > n - 1) {
			recurse(sum + rows[n1 - 1].get(i), i, n1 - 1);
			recurse(sum + rows[n1 - 1].get(i + 1), i + 1, n1 - 1);
			recurse(sum - rows[n1 - 1].get(i), i, n1 - 1);
			recurse(sum - rows[n1 - 1].get(i + 1), i + 1, n1 - 1);
		} else {
			if (i != 0) {
				recurse(sum + rows[n1 - 1].get(i - 1), i - 1, n1 - 1);
				recurse(sum - rows[n1 - 1].get(i - 1), i - 1, n1 - 1);
			}
			if (i != rows[n1].size() - 1) {
				recurse(sum + rows[n1 - 1].get(i), i, n1 - 1);
				recurse(sum - rows[n1 - 1].get(i), i, n1 - 1);
			}
		}
		// }
	}

}

//4
//2
//3 1
//-3 5 7
//6 10 -2 20
//-7 -5 -8
//10 8
//7
//2
//5
//-6 -6
//7
//3
//19
//-50 4
//26 26 -43
//20 -16
//5
//6
//-1
//0 0
//18 0 -29
//26 0 0 1
//0 0 0 0 0
//0 0 0 0 0 50
//0 0 0 0 0
//0 0 0 0
//0 0 0
//0 0
//36
//3
//0
//-30 -30
//-7 -8 -5
//-50 -50
//0
//1
//50
//0