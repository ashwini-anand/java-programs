package AlgoAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class DeterministicFindRank2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		// System.out.println("Enter 'n' and 'm'");
		int n = s.nextInt();
		int m = s.nextInt();
		long inparr[] = new long[n];

		// System.out.println("Enter elements of array");
		for (int i = 0; i < n; i++) {
			inparr[i] = s.nextLong();
		}

		// System.out.println("Array input is done. Now enter ranks");
		int t = 1;
		while (t <= m) {
			int rank = s.nextInt();
			findRank(inparr, rank, 0, n - 1, t, rank);
			t++;
		}
	}

	public static void findRank(long[] inparr, int rank, int start, int end,
			int t, int prank) {

		if (start <= end) {
			long[] subarr = new long[end - start + 1];
			int c = 0;
			for (int i = start; i <= end; i++) {
				subarr[c] = inparr[i];
				c++;
			}

			long median = goodPivot(subarr, start, end);
			int i = start;
			for (i = start; i <= end; i++) {
				if (inparr[i] == median)
					break;
			}
			// System.out.println(median+"  start"+start+" end"+end);
			// System.out.println(i);
			// System.out.println(Arrays.toString(inparr));
			swap(inparr, end, i);
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

	public static long goodPivot(long[] inparr, int start, int end) {
		int n = end - start + 1;
		int i = 0;
		for (i = 0; i < n / 5; i++)
			swap(inparr,i,getMedian(inparr, i * 5, 5));
		if (i * 5 < n) {
			swap(inparr,i,getMedian(inparr, i * 5, n % 5));
			i++;
		}

		long medOfMed = (i == 1) ? inparr[i - 1]
				: goodPivot(inparr, 0, i - 1);
		return medOfMed;

	}

	public static int getMedian(long[] inparr, int start, int size) {
		Arrays.sort(inparr, start, start + size - 1);
		return (start + size) / 2;
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
