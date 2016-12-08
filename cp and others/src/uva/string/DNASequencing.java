package uva.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class DNASequencing {

	/**
	 * @param args
	 */

	public static String text;
	public static char[] textCharArr;
	public static int[] suffixArray;

	static class Entry implements Comparable<Entry> {

		int[] nr = new int[2];
		int p;

		@Override
		public int compareTo(Entry en) {
			return this.nr[0] == en.nr[0] ? (this.nr[1] - en.nr[1])
					: (this.nr[0] - en.nr[0]);
		}

	}

	public static void getSuffixArray() {
		int n = textCharArr.length;
		Entry[] L = new Entry[n];
		int steps = (int) Math.ceil(Math.log(n) / Math.log(2));
		int[][] P = new int[steps + 1][n];
		for (int i = 0; i < n; i++) {
			P[0][i] = textCharArr[i] - '@'; // need to change 'A' to other char
											// as per req.
		}
		for (int i = 0; i < n; i++) {
			L[i] = new Entry();
		}
		int cnt = 1;
		for (int k = 1; k <= steps; k++, cnt <<= 1) // steps to calculate suffix
													// array
		{
			for (int i = 0; i < n; i++) {
				L[i].nr[0] = P[k - 1][i];
				L[i].nr[1] = i + cnt < n ? P[k - 1][i + cnt] : -1;
				L[i].p = i;
			}
			Arrays.sort(L);
			for (int i = 0; i < n; i++) {
				P[k][L[i].p] = i > 0 && L[i].nr[0] == L[i - 1].nr[0]
						&& L[i].nr[1] == L[i - 1].nr[1] ? P[k][L[i - 1].p] : i;
			}
		}
		//
		// for(int i = 0; i< steps+1; i++) {
		// for(int j = 0; j<n; j++) {
		// System.out.print(P[i][j]+"    ");
		// }
		// System.out.println();
		// }

		suffixArray = new int[n];
		for (int i = 0; i < n; i++) {
			suffixArray[i] = L[i].p;
			// System.out.println(suffixArray[i]);
		}
	}

	public static int lcp(int i, int j) {
		int count = 0;
		if ((i < spCharPos && j > spCharPos)
				|| (i > spCharPos && j < spCharPos)) {
			while (i < text.length() && j < text.length()
					&& text.charAt(i) != '@' && text.charAt(j) != '@') {
				if (text.charAt(i) == text.charAt(j)) {
					count++;
					i++;
					j++;
				} else {
					break;
				}
			}
		}
		return count;
	}

	static int spCharPos;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		while (in.hasNextLine()) {
			String s1 = in.nextLine();
			String s2 = in.nextLine();
			spCharPos = s1.length();
			text = s1 + "@" + s2;
			textCharArr = text.toCharArray();
			getSuffixArray();
			int longestMatch = 0;
			TreeSet<String> hs = new TreeSet<>();
			for (int i = 1; i < text.length(); i++) {
				int len = lcp(suffixArray[i], suffixArray[i - 1]);
				if (len >= longestMatch) {
					String lrs = text.substring(suffixArray[i], suffixArray[i]
							+ len);
					hs.add(lrs);
					longestMatch = len;
				}
			}
			for (String str : hs) {
				if (str.length() == longestMatch)
					System.out.println(str);
			}
			System.out.println();
			in.nextLine();
		}

	}

}
