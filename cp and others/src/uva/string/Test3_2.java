package uva.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Test3_2 {

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
			P[0][i] = textCharArr[i] - '0';
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
		while (i < text.length() && j < text.length()) {
			if (text.charAt(i) == text.charAt(j)) {
				count++;
				i++;
				j++;
			} else {
				break;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int test = 1;
		while (test <= t) {
			text = in.nextLine();
			int k = Integer.parseInt(in.nextLine());
//			if (text.length() >= 100000) {
//				test++;
//				continue;
//			}
			// System.out.println(text.length());
			textCharArr = text.toCharArray();
			getSuffixArray();
			String lrs = "";
			int count = 0;
			int length = 0;
			// length = lcp(suffixArray[1], suffixArray[0]);
			// lrs = text.substring(suffixArray[1], suffixArray[1] + length);
			// count = 2;
			ArrayList<String> al = new ArrayList<>();
			HashMap<String, Integer> hm = new HashMap<>();

			int max = 0;
			for (int i = 1; i < text.length()-k; i++) {
				length = lcp(suffixArray[i], suffixArray[i +k- 1]);
				if(length > max){
					max  = length;
				}
			}
			System.out.println("case " + test + ": ");
			System.out.println(max);
			test++;
		}

	}

}
