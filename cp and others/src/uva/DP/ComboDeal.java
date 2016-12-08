//Gives runtime error in UVa OJ. But passing all the test cases that I could think of and could get from Internet.

package uva.DP;

import java.util.*;

public class ComboDeal {

	public static int numOfIndiItems;
	public static int indiItemsPrices[];
	public static int numOfComboItems;
	public static int comboItemsPrices[];
	public static int indiItemsinCombos[][];
	public static int[][][][][][] dp;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			numOfIndiItems = in.nextInt();
			indiItemsPrices = new int[numOfIndiItems];
			for (int i = 0; i < numOfIndiItems; i++) {
				indiItemsPrices[i] = in.nextInt();
			}
			numOfComboItems = in.nextInt();
			comboItemsPrices = new int[numOfComboItems];
			indiItemsinCombos = new int[numOfComboItems][numOfIndiItems];
			for (int i = 0; i < numOfComboItems; i++) {
				for (int j = 0; j < numOfIndiItems; j++) {
					indiItemsinCombos[i][j] = in.nextInt();
				}
				comboItemsPrices[i] = in.nextInt();
			}

			int order = in.nextInt();
			dp = new int[10][10][10][10][10][10];
			for (int i = 0; i < order; i++) {
				int[] orders = new int[6];
				for (int j = 0; j < numOfIndiItems; j++) {
					orders[j] = in.nextInt();
				}
				int ans = recurse(orders);
				System.out.println(ans);
			}
		}
	}

	public static int recurse(int[] orders) {
		if (dp[orders[0]][orders[1]][orders[2]][orders[3]][orders[4]][orders[5]] != 0)
			return dp[orders[0]][orders[1]][orders[2]][orders[3]][orders[4]][orders[5]];
		int ans = 0;
		for (int i = 0; i < numOfIndiItems; i++) {
			ans += indiItemsPrices[i] * orders[i];
		}
		for (int i = 0; i < numOfComboItems; i++) {
			int temp[] = Arrays.copyOf(orders, orders.length);
			boolean flag = true;
			for (int j = 0; j < numOfIndiItems; j++) {
				if (orders[j] < indiItemsinCombos[i][j]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				for (int j = 0; j < numOfIndiItems; j++) {
					temp[j] -= indiItemsinCombos[i][j];
					ans = Math.min(ans, comboItemsPrices[i] + recurse(temp));
				}
			}
		}
		dp[orders[0]][orders[1]][orders[2]][orders[3]][orders[4]][orders[5]] = ans;
		return dp[orders[0]][orders[1]][orders[2]][orders[3]][orders[4]][orders[5]];
		//return ans;
	}
}
