package uva.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LifeForms2 {

	/**
	 * @param args
	 */

	public static String text;
	public static char[] textCharArr;
	public static int[] suffixArray;
	public static int[] grpInfo;
	public static int[] lcpArray;

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
			P[0][i] = textCharArr[i] - '@'; // need to change '@' to other char
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

		// System.out.println();
		// System.out.println();
		// System.out.print("suffix array is : ");
		suffixArray = new int[n];
		for (int i = 0; i < n; i++) {
			suffixArray[i] = L[i].p;
			// System.out.print(suffixArray[i] + " ");
		}
		// System.out.println();
	}

	public static int lcp(int i, int j) {
		int count = 0;
		if (grpInfo[i] != grpInfo[j]) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (true) {
			int n = Integer.parseInt(in.nextLine());
			if (n == 0)
				break;
			text = in.nextLine();
			for (int i = 0; i < n - 1; i++) {
				text += "@" + in.nextLine();
			}
			grpInfo = new int[text.length()];
			int grpnum = 0;
			for (int i = 0; i < text.length(); i++) {
				if (text.charAt(i) != '@') {
					grpInfo[i] = grpnum;
				} else {
					grpnum++;
				}
			}

			textCharArr = text.toCharArray();
			getSuffixArray();
			lcpArray = new int[text.length()];
			int max = 0;
			ArrayList<String> strList = new ArrayList<>();
			for (int i = n; i < lcpArray.length - (n / 2 + 1); i++) {
				int length = lcp(suffixArray[i], suffixArray[i + (n / 2 + 1)
						- 1]);
				if (length != 0 && length > max) {
					max = length;
					strList.clear();
					strList.add(text.substring(suffixArray[i], suffixArray[i]
							+ length));
				} else if (length != 0 && length == max) {
					if (!strList.contains(text.substring(suffixArray[i],
							suffixArray[i] + length))) {
						strList.add(text.substring(suffixArray[i],
								suffixArray[i] + length));
					}
				}
			}

			if (strList.isEmpty()) {
				System.out.println("?");
			}

			for (int i = 0; i < strList.size(); i++) {
				System.out.println(strList.get(i));
			}
			System.out.println();

		}

	}

}
