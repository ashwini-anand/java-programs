package geeksforgeeks;

import java.util.*;

public class CountSum {

	public static int[][] table;
	public static int n;
	public static int value;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		value = in.nextInt();
		table = new int[value + 1][n + 1];
		if (n == 1) { // many cases not handled properly
			System.out.println("1");
			System.exit(0);
		}
		for (int i = 0; i < table.length; i++) {
			Arrays.fill(table[i], -1);
		}
		table[value][n] = 0;
		for (int i = 1; i < 10; i++) {
			if (value - i >= 0) {
				table[value][n] += count(value - i, n - 1);
			}
		}
		System.out.println(table[value][n]);
	}

	public static int count(int sum, int k) {
		if (k == 0) {
			if (sum == 0)
				return 1;
			else
				return 0;
		}
		if (k < 0 || sum < 0)
			return 0;
		if (table[sum][k] != -1) {
			return table[sum][k];
		}
		table[sum][k] = 0;
		for (int i = 0; i < 10; i++) {
			if (sum - i >= 0) {
				table[sum][k] += count(sum - i, k - 1);
			}
		}
		return table[sum][k];
	}

}