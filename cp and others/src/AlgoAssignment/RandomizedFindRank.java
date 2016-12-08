package AlgoAssignment;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandomizedFindRank {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		long inparr[] = new long[n];

		for (int i = 0; i < n; i++) {
			inparr[i] = s.nextLong();
		}

		int t = 1;
		// long startTime = System.currentTimeMillis();
		while (t <= m) {
			int rank = s.nextInt();
			findRank(inparr, rank, 0, n - 1, t, rank);
			t++;
		}
		// long endTime = System.currentTimeMillis();
		// System.out.println("It took " + (endTime - startTime) +
		// " milliseconds");
		s.close();
	}

	public static void findRank(long[] inparr, int rank, int start, int end,
			int t, int prank) {

		if (start <= end) {
			Random rand = new Random();
			int randpos = rand.nextInt((end - start) + 1) + start;
			swap(inparr, end, randpos);
			int pos = partition(inparr, start, end);
			if (rank == end - pos + 1) {
				System.out.println("Rank " + prank + " element is "
						+ inparr[pos]);
				return;
			} else if (rank < end - pos + 1) {
				findRank(inparr, rank, pos + 1, end, t, prank);
			} else {
				findRank(inparr, rank - (end - pos + 1), start, pos - 1, t,
						prank);
			}
		}
	}

	public static int partition(long[] inparr, int start, int end) {
		long x = inparr[end];
		int i = start - 1;

		for (int j = start; j <= end - 1; j++) {
			if (inparr[j] <= x) {
				i++;
				swap(inparr, i, j);
			}
		}
		swap(inparr, i + 1, end);
		return (i + 1);
	}

	public static void swap(long[] inparr, int pos1, int pos2) {
		long temp = inparr[pos2];
		inparr[pos2] = inparr[pos1];
		inparr[pos1] = temp;
	}

}
