// For LCP look into GATTACA and GATTACA2. Both different types of LCP function. GATTACA2 LCP is faster O(logn).

package gfg;

import java.util.Arrays;

public class SuffixArrayCodechef {

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
			P[0][i] = textCharArr[i] - 'A'; // need to change 'A' to other char
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
		for(int i = 0; i< steps+1; i++) {
			for(int j = 0; j<n; j++) {
				System.out.print(P[i][j]+"    ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.print("suffix array is : ");
		suffixArray = new int[n];
		for (int i = 0; i < n; i++) {
			suffixArray[i] = L[i].p;
			System.out.print(suffixArray[i]+" ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		text= "BLOGGER";
		textCharArr = text.toCharArray();
		getSuffixArray();

	}

}
