package uva.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LifeForms {

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
			for (int i = n; i < lcpArray.length; i++) {
				int length = lcp(suffixArray[i], suffixArray[i - 1]);
				lcpArray[i] = length;
			}
//			for (int i = 0; i < lcpArray.length; i++) {
//				System.out.print(lcpArray[i] + " ");
//			}
			int count = 0;
			int idx = 0;
			ArrayList<Integer> alist = new ArrayList<>();
			ArrayList<String> res = new ArrayList<>();
			for (int i = n; i < lcpArray.length; i++) {
				if (lcpArray[i - 1] > lcpArray[i]) {
					alist.add(idx);
					for (int j = 0; j < alist.size(); j++) {
						// System.out.print(alist.get(j) + " ");
						count = i - alist.get(j);
						if (count + 1 > n / 2) {
							res.add(text.substring(
									suffixArray[alist.get(j)],
									suffixArray[alist.get(j)]
											+ lcpArray[alist.get(j)]));
						} else {
							break;
						}
					}
					alist.clear();
					idx = i;
				}
				if (lcpArray[i] == 0) {
					continue;
				}
				if (lcpArray[i - 1] < lcpArray[i] && lcpArray[i - 1] != 0) {
					alist.add(idx);
					idx = i;
				}
				if (lcpArray[i - 1] == 0 && lcpArray[i] != 0) {
					idx = i;
				}
				if (lcpArray[i] != 0 && i == lcpArray.length - 1) {
					alist.add(idx);
				}
			}
			
//			for (int i = 0; i < res.size(); i++) {
//				System.out.println(res.get(i));
//			}

			if (!alist.isEmpty()) {
				for (int j = 0; j < alist.size(); j++) {
					count = lcpArray.length - alist.get(j);
					if (count > n / 2) {
						res.add(text.substring(
								suffixArray[alist.get(j)],
								suffixArray[alist.get(j)]
										+ lcpArray[alist.get(j)]));
					} else {
						break;
					}
				}
				alist.clear();
			}

			if (res.isEmpty()) {
				System.out.println("?");
				System.out.println();
				continue;
			}

			// for (int i = 0; i < res.size(); i++) {
			// System.out.println(res.get(i));
			// }

			int maxL = 0;
			for (int i = 0; i < res.size(); i++) {
				if (res.get(i).length() > maxL) {
					maxL = res.get(i).length();
				}
			}
			for (int i = 0; i < res.size(); i++) {
				if (maxL == res.get(i).length()) {
					System.out.println(res.get(i));
				}
			}
			System.out.println();

		}

	}

}
