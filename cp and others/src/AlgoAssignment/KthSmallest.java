package AlgoAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class KthSmallest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		long inparr[] = new long[n];

		// System.out.println("Enter elements of array");
		for (int i = 0; i < n; i++) {
			inparr[i] = s.nextLong();
		}

		// System.out.println("Array input is done. Now enter ranks");
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

		int i = goodPivot(inparr, start, end);
		swap(inparr, end, i);
		int pos = partition(inparr, start, end);
		if (rank == pos - start + 1) {
			System.out.println("Rank " + prank + " element is " + inparr[pos]);
			return;
		} else if (rank < pos - start + 1) {
			findRank(inparr, rank, start, pos-1, t, prank);
		} else {
			findRank(inparr, rank - (pos - start + 1), pos+1, end, t, prank);
		}
	}

	public static int goodPivot(long[] inparr, int start, int end) {
		int n = end - start + 1;
		int i = 0;
		for (i = 0; i < n / 5; i++)
			swap(inparr, start + i, getMedian(inparr, start + (i * 5), 5));
		if (i * 5 < n) {
			swap(inparr, start + i, getMedian(inparr, start + (i * 5), n % 5));
			i++;
		}
		int medianIndex = (i == 1) ? start + i - 1 : goodPivot(inparr, start,
				start + i - 1);
		return medianIndex;

	}

	public static int getMedian(long[] inparr, int start, int size) {
		Arrays.sort(inparr, start, start + size);
		return start + (size / 2);
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
