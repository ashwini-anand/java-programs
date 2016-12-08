package gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FFARM {

	/**
	 * @param args
	 */
	public static Integer[] generatePalindrome() {
		int limit = 1000;
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i <= 9 && i <= limit; i++)
			result.add(i);

		boolean cont = true;
		for (int i = 1; cont; i++) {
			StringBuffer rev = new StringBuffer("" + i).reverse();
			cont = false;
			for (String d : ",0,1,2,3,4,5,6,7,8,9".split(",")) {
				int n = Integer.parseInt("" + i + d + rev);
				if (n <= limit) {
					cont = true;
					result.add(n);
				}
			}
		}

		return result.toArray(new Integer[result.size()]);

	}

	public static void main(String[] args) {

		Integer[] arr = generatePalindrome();
		// for (int i = 0; i < arr.length; i++) {
		// System.out.println(arr[i]+" ");
		// }
		Arrays.sort(arr);
		MyScanner s = new MyScanner();
		int t = s.nextInt();
		while (t > 0) {
			t--;
			int a = s.nextInt();
			int b = s.nextInt();
			int l = s.nextInt();
			int start = -1, end = -1, k = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= a) {
					start = i;
					k = i;
					break;
				}
			}
			for (int i = k; i < arr.length; i++) {
				if (arr[i] > b) {
					end = i - 1;
					break;
				}
			}
			if ((start != -1) && (end == -1)) {
				end = arr.length - 1;
			}
			if (start > end) {
				System.out.println("Barren Land.");
			} else if (arr[end] - arr[start] + 1 <= l) {
				System.out.println(arr[start] + " " + arr[end]);
			} else {

				// for (int i = start; i <= end; i=i+count) {
				//
				// }
				int k1 = start, k2 = start, mincount = 1, minlen = l;
				for (int i = start; i <= end; i++) {
					int count = mincount, len = minlen;
					for (int j = i + mincount; j <= end; j++) {
						if (arr[j] <= arr[i] + l - 1) {
							count++;
							len = arr[j] - arr[i] + 1;
							if ((count > mincount)
									|| ((count == mincount) && len < minlen)) {
								k1 = i;
								k2 = j;
								mincount = count;
								minlen = len;
							}
						} else {
							break;
						}
					}
				}
				System.out.println(arr[k1] + " " + arr[k2]);
			}

		}

	}
	static class MyScanner {
		   static BufferedReader br;
		   static StringTokenizer st;

		   public MyScanner() {
		      br = new BufferedReader(new InputStreamReader(System.in));
		   }

		    String  next() {
		       while (st == null || !st.hasMoreElements()) {
		           try {
		               st = new StringTokenizer(br.readLine());
		           } catch (IOException e) {
		               e.printStackTrace();
		           }
		       }
		       return st.nextToken();
		   }

		    int nextInt() {
		       return Integer.parseInt(next());
		   }

		    long nextLong() {
		       return Long.parseLong(next());
		   }

		    double nextDouble() {
		       return Double.parseDouble(next());
		   }

		    String nextLine(){
		       String str = "";
			  try {
			     str = br.readLine();
			  } catch (IOException e) {
			     e.printStackTrace();
			  }
			  return str;
		   }

		}
}
