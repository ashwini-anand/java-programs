package uva.DP;

import java.util.*;

public class MurciaSkyline {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int k = 1;
		while (k <= t) {
			int n = in.nextInt();
			if (n == 0) {
				System.out.print("Case " + k + ". ");
				System.out.println("Increasing (0). Decreasing (0).");
				k++;
				continue;
			}

			int htarr[] = new int[n];
			int wdtharr[] = new int[n];

			for (int i = 0; i < n; i++) {
				htarr[i] = in.nextInt();
			}
			for (int i = 0; i < n; i++) {
				wdtharr[i] = in.nextInt();
			}

			int incseq[] = new int[n];
			int decseq[] = new int[n];

			for (int i = 0; i < n; i++) {
				incseq[i] = decseq[i] = wdtharr[i];
			}
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if (htarr[i] > htarr[j]
							&& incseq[i] < incseq[j] + wdtharr[i]) {
						incseq[i] = incseq[j] + wdtharr[i];
					}
				}
			}

			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if (htarr[i] < htarr[j]
							&& decseq[i] < decseq[j] + wdtharr[i]) {
						decseq[i] = decseq[j] + wdtharr[i];
					}
				}
			}

			int longestInc = incseq[0];
			for (int i = 1; i < n; i++) {
				longestInc = longestInc < incseq[i] ? incseq[i] : longestInc;
			}

			int longestdec = decseq[0];
			for (int i = 1; i < n; i++) {
				longestdec = longestdec < decseq[i] ? decseq[i] : longestdec;
			}
			System.out.print("Case " + k + ". ");
			if (longestInc >= longestdec) {
				System.out.println("Increasing (" + longestInc
						+ "). Decreasing (" + longestdec + ").");
			} else {
				System.out.println("Decreasing (" + longestdec
						+ "). Increasing (" + longestInc + ").");
			}

			k++;
		}

	}
}
