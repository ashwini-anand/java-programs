package geeksforgeeks;

import java.util.*;

public class ReachAScore {

	static int score;
	static int[] arr = { 3, 5, 10 };
	static int[][] table;

	public static void main(String[] args) {
		score = 20;
		table = new int[3][21];
		for (int i = 0; i < table.length; i++) {
			Arrays.fill(table[i], -1);
		}
		System.out.println(count(0, 2));
		score = 13;
		table = new int[3][14];
		for (int i = 0; i < table.length; i++) {
			Arrays.fill(table[i], -1);
		}
		System.out.println(count(0, 2));

	}

	public static int count(int currentScore, int i) {
		if(currentScore > score) return 0;
		if (currentScore == score)
			return 1;
		if (i < 0)
			return 0;
		if (table[i][currentScore] != -1)
			return table[i][currentScore];
		else {
			table[i][currentScore] = count(currentScore + arr[i], i)
					+ count(currentScore, i - 1);
		}
		return table[i][currentScore];
	}

}
