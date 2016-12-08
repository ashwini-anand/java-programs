package uva.DP;

import java.util.Arrays;
import java.util.Scanner;

public class ExactChange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t > 0) {
			t--;
			int p = in.nextInt();
			int n = in.nextInt();
			int maxVal = 15000;
			int[] coins = new int[n];
			for (int i = 0; i < coins.length; i++) {
				coins[i] = in.nextInt();
				//maxVal += coins[i];
			}
			
			int[][] sumMat = new int[n][maxVal];
			for (int i = 0; i < sumMat.length; i++) {
				Arrays.fill(sumMat[i], Integer.MAX_VALUE);
			}
			for (int i = 0; i < n; i++) {
				sumMat[i][0] = 0;
			}
			if (coins[0] < maxVal) {
				sumMat[0][coins[0]] = 1;
			}

			for (int i = 1; i < n; i++) {
				for (int j = 1; j < maxVal; j++) {
					sumMat[i][j] = sumMat[i - 1][j];
					if (j - coins[i] >= 0) {
						// System.out.println("here2");
						int prev = sumMat[i - 1][j - coins[i]];
						prev = (prev == Integer.MAX_VALUE ? prev : 1 + prev);
						int min = Math.min(sumMat[i - 1][j], prev);
						sumMat[i][j] = min;
					}
				}
			}

			for (int i = p; i < maxVal; i++) {
				// System.out.println("here1");
				if (sumMat[n - 1][i] != Integer.MAX_VALUE) {
					System.out.println(i + " " + sumMat[n - 1][i]);
					break;
				}
			}
		}

	}

}
